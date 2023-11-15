package com.unapec.cajaunapec.controllers;

import com.unapec.cajaunapec.entities.Estado;
import com.unapec.cajaunapec.entities.Cliente;
import com.unapec.cajaunapec.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Vista para listar todos los clientes
    @GetMapping({"/", ""})
    public String listarCliente(Model model, @RequestParam(name = "estado", required = false) String estado) {
        Boolean mostrarTodo = estado != null && estado.toLowerCase().equals(Estado.INACTIVO.toString().toLowerCase());
        List<Cliente> clientesList = mostrarTodo ? clienteRepository.findAll() :
                clienteRepository.findByEstado(Estado.ACTIVO);


        model.addAttribute("clientesList", clientesList);
        model.addAttribute("mostrarTodo", mostrarTodo);
        return "clientes/list";
    }

    // Vista para crear un nuevo cliente
    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/create";
    }

    // Procesar la creación de un nuevo cliente
    @PostMapping("/new")
    public String crearCliente(@ModelAttribute("cliente") @Valid Cliente cliente, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "clientes/create";
        }
        clienteRepository.save(cliente);
        return "redirect:/clientes/";
    }

    // Vista para editar un cliente por su ID
    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {

        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clientes/edit";
        } else {
            return "redirect:/clientes/";
        }
    }

    // Procesar la actualización de un cliente
    @PostMapping("/{id}/edit")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") @Valid Cliente cliente, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "clientes/edit";
        }
        cliente.setIdCliente(id);
        clienteRepository.save(cliente);
        return "redirect:/clientes/";
    }

    // Eliminar un cliente por su ID
    @GetMapping("/{id}/delete")
    public String eliminarCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        cliente.remove();
        clienteRepository.save(cliente);
        return "redirect:/clientes/";
    }
}
