package com.unapec.cajaunapec.controllers;

import com.unapec.cajaunapec.entities.Estado;
import com.unapec.cajaunapec.entities.ModalidadPago;
import com.unapec.cajaunapec.repositories.ModalidadesPagoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/modalidades-pago")
public class ModalidadesPagoController {

    @Autowired
    private ModalidadesPagoRepository modalidadesPagoRepository;

    // Vista para listar todos las modalidades de pago
    @GetMapping({"/", ""})
    public String listarModalidadPago(Model model, @RequestParam(name = "estado", required = false) String estado) {
        Boolean mostrarTodo = estado != null && estado.toLowerCase().equals(Estado.INACTIVO.toString().toLowerCase());
        List<ModalidadPago> modalidadesPagoList = mostrarTodo ? modalidadesPagoRepository.findAll() :
                modalidadesPagoRepository.findByEstado(Estado.ACTIVO);


        model.addAttribute("modalidadesPagoList", modalidadesPagoList);
        model.addAttribute("mostrarTodo", mostrarTodo);
        return "modalidades-pago/list";
    }

    // Vista para crear una nueva modalidad de pago
    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("modalidadesPago", new ModalidadPago());
        return "modalidades-pago/create";
    }

    // Procesar la creación de una nueva modalidad de pago
    @PostMapping("/new")
    public String crearModalidadPago(@ModelAttribute("modalidadesPago") @Valid ModalidadPago modalidadesPago, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "modalidades-pago/create";
        }
        modalidadesPagoRepository.save(modalidadesPago);
        System.out.println(modalidadesPago.getDescripcion());
        System.out.println(modalidadesPago.getEstado());
        return "redirect:/modalidades-pago/";
    }

    // Vista para editar una modalidad de pago por su ID
    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        ModalidadPago modalidadesPago = modalidadesPagoRepository.findById(id).orElse(null);
        if (modalidadesPago != null) {
            model.addAttribute("modalidadesPago", modalidadesPago);
            return "modalidades-pago/edit";
        } else {
            return "redirect:/modalidades-pago/";
        }
    }

    // Procesar la actualización de una modalidad de pago
    @PostMapping("/{id}/edit")
    public String actualizarModalidadPago(@PathVariable Long id, @ModelAttribute("modalidadesPago") @Valid ModalidadPago modalidadesPago, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "modalidades-pago/edit";
        }
        modalidadesPago.setId(id);
        modalidadesPagoRepository.save(modalidadesPago);
        return "redirect:/modalidades-pago/";
    }

    // Eliminar una modalidad de pago por su ID
    @GetMapping("/{id}/delete")
    public String eliminarModalidadPago(@PathVariable Long id) {
        ModalidadPago modalidadesPago = modalidadesPagoRepository.findById(id).get();
        modalidadesPago.remove();
        modalidadesPagoRepository.save(modalidadesPago);
        return "redirect:/modalidades-pago/";
    }
}
