package com.unapec.cajaunapec.controllers;

import com.unapec.cajaunapec.entities.Estado;
import com.unapec.cajaunapec.entities.FormaPago;
import com.unapec.cajaunapec.repositories.FormasPagoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/formas-pago")
public class FormasPagoController {

    @Autowired
    private FormasPagoRepository formasPagoRepository;

    // Vista para listar todos las formas de pago
    @GetMapping({"/", ""})
    public String listarFormaPago(Model model, @RequestParam(name = "estado", required = false) String estado) {
        Boolean mostrarTodo = estado != null && estado.toLowerCase().equals(Estado.INACTIVO.toString().toLowerCase());
        List<FormaPago> formasPagoList = mostrarTodo ? formasPagoRepository.findAll() :
                formasPagoRepository.findByEstado(Estado.ACTIVO);


        model.addAttribute("formasPagoList", formasPagoList);
        model.addAttribute("mostrarTodo", mostrarTodo);
        return "formas-pago/list";
    }

    // Vista para crear una nueva forma de pago
    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("formasPago", new FormaPago());
        return "formas-pago/create";
    }

    // Procesar la creación de una nueva forma de pago
    @PostMapping("/new")
    public String crearFormaPago(@ModelAttribute("formasPago") @Valid FormaPago formasPago, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("errors", bindingResult.getAllErrors());
            return "formas-pago/create";
        }
        formasPagoRepository.save(formasPago);
        System.out.println(formasPago.getDescripcion());
        System.out.println(formasPago.getEstado());
        return "redirect:/formas-pago/";
    }

    // Vista para editar una forma de pago por su ID
    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        FormaPago formasPago = formasPagoRepository.findById(id).orElse(null);
        if (formasPago != null) {
            model.addAttribute("formasPago", formasPago);
            return "formas-pago/edit";
        } else {
            return "redirect:/formas-pago/";
        }
    }

    // Procesar la actualización de una forma de pago
    @PostMapping("/{id}/edit")
    public String actualizarFormaPago(@PathVariable Long id, @ModelAttribute("formasPago") @Valid FormaPago formasPago, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "formas-pago/edit";
        }
        formasPago.setId(id);
        formasPagoRepository.save(formasPago);
        return "redirect:/formas-pago/";
    }

    // Eliminar una forma de pago por su ID
    @GetMapping("/{id}/delete")
    public String eliminarFormaPago(@PathVariable Long id) {
        FormaPago formasPago = formasPagoRepository.findById(id).get();
        formasPago.remove();
        formasPagoRepository.save(formasPago);
        return "redirect:/formas-pago/";
    }
}
