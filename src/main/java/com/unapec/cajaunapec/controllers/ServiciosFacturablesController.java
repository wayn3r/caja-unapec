package com.unapec.cajaunapec.controllers;

import com.unapec.cajaunapec.entities.Estado;
import com.unapec.cajaunapec.entities.ServicioFacturable;
import com.unapec.cajaunapec.repositories.ServiciosFacturablesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/servicios-facturables")
public class ServiciosFacturablesController {

    @Autowired
    private ServiciosFacturablesRepository servicioFacturableRepository;

    // Vista para listar todos los servicios facturables
    @GetMapping({"/", ""})
    public String listarServicioFacturable(Model model, @RequestParam(name = "estado", required = false) String estado) {
        Boolean mostrarTodo = estado != null && estado.toLowerCase().equals(Estado.INACTIVO.toString().toLowerCase());
        List<ServicioFacturable> serviciosFacturablesList = mostrarTodo ? servicioFacturableRepository.findAll() :
                servicioFacturableRepository.findByEstado(Estado.ACTIVO);


        model.addAttribute("serviciosFacturablesList", serviciosFacturablesList);
        model.addAttribute("mostrarTodo", mostrarTodo);
        return "servicios-facturables/list";
    }

    // Vista para crear un nuevo servicio facturable
    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("servicioFacturable", new ServicioFacturable());
        return "servicios-facturables/create";
    }

    // Procesar la creación de un nuevo servicio facturable
    @PostMapping("/new")
    public String crearServicioFacturable(@ModelAttribute("servicioFacturable") @Valid ServicioFacturable servicioFacturable, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "servicios-facturables/create";
        }
        servicioFacturableRepository.save(servicioFacturable);
        return "redirect:/servicios-facturables/";
    }

    // Vista para editar un servicio facturable por su ID
    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        ServicioFacturable servicioFacturable = servicioFacturableRepository.findById(id).orElse(null);
        if (servicioFacturable != null) {
            model.addAttribute("servicioFacturable", servicioFacturable);
            return "servicios-facturables/edit";
        } else {
            return "redirect:/servicios-facturables/";
        }
    }

    // Procesar la actualización de un servicio facturable
    @PostMapping("/{id}/edit")
    public String actualizarServicioFacturable(@PathVariable Long id, @ModelAttribute("servicioFacturable") @Valid ServicioFacturable servicioFacturable, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "servicios-facturables/edit";
        }
        servicioFacturable.setId(id);
        servicioFacturableRepository.save(servicioFacturable);
        return "redirect:/servicios-facturables/";
    }

    // Eliminar un servicio facturable por su ID
    @GetMapping("/{id}/delete")
    public String eliminarServicioFacturable(@PathVariable Long id) {
        ServicioFacturable servicioFacturable = servicioFacturableRepository.findById(id).get();
        servicioFacturable.remove();
        servicioFacturableRepository.save(servicioFacturable);
        return "redirect:/servicios-facturables/";
    }
}
