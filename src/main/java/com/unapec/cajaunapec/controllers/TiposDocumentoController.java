package com.unapec.cajaunapec.controllers;

import com.unapec.cajaunapec.entities.Estado;
import com.unapec.cajaunapec.entities.TiposDocumento;
import com.unapec.cajaunapec.repositories.TiposDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tiposdocumento")
public class TiposDocumentoController {

    @Autowired
    private TiposDocumentoRepository tiposDocumentoRepository;

    // Vista para listar todos los tipos de documentos
    @GetMapping({"/", ""})
    public String listarTiposDocumento(Model model, @RequestParam(name = "estado", required = false) String estado) {
        Boolean mostrarTodo = estado != null && estado.toLowerCase().equals(Estado.INACTIVO.toString().toLowerCase());
        List<TiposDocumento> tiposDocumentoList = mostrarTodo ? tiposDocumentoRepository.findAll() :
                tiposDocumentoRepository.findByEstado(Estado.ACTIVO);


        model.addAttribute("tiposDocumentoList", tiposDocumentoList);
        model.addAttribute("mostrarTodo", mostrarTodo);
        return "tiposdocumento/list";
    }

    // Vista para crear un nuevo tipo de documento
    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("tiposDocumento", new TiposDocumento());
        return "tiposdocumento/create";
    }

    // Procesar la creación de un nuevo tipo de documento
    @PostMapping("/new")
    public String crearTiposDocumento(@ModelAttribute TiposDocumento tiposDocumento) {
        tiposDocumentoRepository.save(tiposDocumento);
        System.out.println(tiposDocumento.getDescripcion());
        System.out.println(tiposDocumento.getEstado());
        return "redirect:/tiposdocumento/";
    }

    // Vista para editar un tipo de documento por su ID
    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        TiposDocumento tiposDocumento = tiposDocumentoRepository.findById(id).orElse(null);
        if (tiposDocumento != null) {
            model.addAttribute("tiposDocumento", tiposDocumento);
            model.addAttribute("tiposDocumento", tiposDocumento);
            return "tiposdocumento/edit";
        } else {
            return "redirect:/tiposdocumento/";
        }
    }

    // Procesar la actualización de un tipo de documento
    @PostMapping("/{id}/edit")
    public String actualizarTiposDocumento(@PathVariable Long id, @ModelAttribute TiposDocumento tiposDocumento) {
        tiposDocumento.setId(id);
        tiposDocumentoRepository.save(tiposDocumento);
        return "redirect:/tiposdocumento/";
    }

    // Eliminar un tipo de documento por su ID
    @GetMapping("/{id}/delete")
    public String eliminarTiposDocumento(@PathVariable Long id) {
        TiposDocumento tiposDocumento = tiposDocumentoRepository.findById(id).get();
        tiposDocumento.remove();
        tiposDocumentoRepository.save(tiposDocumento);
        return "redirect:/tiposdocumento/";
    }
}
