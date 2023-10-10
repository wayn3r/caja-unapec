package com.unapec.cajaunapec.controllers;

import com.unapec.cajaunapec.entities.Estado;
import com.unapec.cajaunapec.entities.Empleado;
import com.unapec.cajaunapec.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Vista para listar todos los empleados
    @GetMapping({"/", ""})
    public String listarEmpleado(Model model, @RequestParam(name = "estado", required = false) String estado) {
        Boolean mostrarTodo = estado != null && estado.toLowerCase().equals(Estado.INACTIVO.toString().toLowerCase());
        List<Empleado> empleadosList = mostrarTodo ? empleadoRepository.findAll() :
                empleadoRepository.findByEstado(Estado.ACTIVO);


        model.addAttribute("empleadosList", empleadosList);
        model.addAttribute("mostrarTodo", mostrarTodo);
        return "empleados/list";
    }

    // Vista para crear un nuevo empleado
    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/create";
    }

    // Procesar la creación de un nuevo empleado
    @PostMapping("/new")
    public String crearEmpleado(@ModelAttribute Empleado empleado) {
        empleadoRepository.save(empleado);
        return "redirect:/empleados/";
    }

    // Vista para editar un empleado por su ID
    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "empleados/edit";
        } else {
            return "redirect:/empleados/";
        }
    }

    // Procesar la actualización de un empleado
    @PostMapping("/{id}/edit")
    public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute Empleado empleado) {
        empleado.setId(id);
        empleadoRepository.save(empleado);
        return "redirect:/empleados/";
    }

    // Eliminar un empleado por su ID
    @GetMapping("/{id}/delete")
    public String eliminarEmpleado(@PathVariable Long id) {
        Empleado empleado = empleadoRepository.findById(id).get();
        empleado.remove();
        empleadoRepository.save(empleado);
        return "redirect:/empleados/";
    }
}
