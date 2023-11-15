package com.unapec.cajaunapec.controllers;

import java.util.UUID;
import com.unapec.cajaunapec.entities.*;
import com.unapec.cajaunapec.repositories.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movimientos-caja")
public class MovimientosCajaController {

    @Autowired
    private MovimientoCajaRepository movimientoCajaRepository;

    @Autowired
    private ClienteRepository clientesRepository;

    @Autowired
    private EmpleadoRepository empleadosRepository;

    @Autowired
    private ServiciosFacturablesRepository serviciosRepository;

    @Autowired
    private TiposDocumentoRepository documentosRepository;

    @Autowired
    private FormasPagoRepository formasPagoRepository;


    // Vista para listar todos los movimientos de caja
    @GetMapping({"/", ""})
    public String listarMovimientoCaja(Model model, @RequestParam(name = "estado", required = false) String estado) {
        Boolean mostrarTodo = estado != null && estado.toLowerCase().equals(Estado.INACTIVO.toString().toLowerCase());
        List<MovimientoCaja> movimientosCajaList = mostrarTodo ? movimientoCajaRepository.findAll() :
                movimientoCajaRepository.findByEstado(Estado.ACTIVO);

        model.addAttribute("movimientosCajaList", movimientosCajaList);
        model.addAttribute("mostrarTodo", mostrarTodo);
        return "movimientos-caja/list";
    }

    // Vista para crear un nuevo movimiento de caja
    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("movimientoCaja", new MovimientoCaja());

        setRelationalData(model);

        return "movimientos-caja/create";
    }

    // Procesar la creación de un nuevo movimientoCaja
    @PostMapping("/new")
    public String crearMovimientoCaja(@ModelAttribute("movimientoCaja") @Valid MovimientoCaja movimientoCaja, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            setRelationalData(model);
            return "movimientos-caja/create";
        }
        movimientoCaja.setNoMovimiento(UUID.randomUUID().toString());
        movimientoCajaRepository.save(movimientoCaja);
        return "redirect:/movimientos-caja/";
    }

    // Vista para editar un movimiento de caja por su ID
    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        MovimientoCaja movimientoCaja = movimientoCajaRepository.findById(id).orElse(null);
        if (movimientoCaja != null) {
            model.addAttribute("movimientoCaja", movimientoCaja);
            setRelationalData(model);
            return "movimientos-caja/edit";
        } else {
            return "redirect:/movimientos-caja/";
        }
    }

    // Procesar la actualización de un movimiento de caja
    @PostMapping("/{id}/edit")
    public String actualizarMovimientoCaja(@PathVariable Long id, @ModelAttribute("movimientoCaja") @Valid MovimientoCaja movimientoCaja, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            setRelationalData(model);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "movimientos-caja/edit";
        }
        movimientoCaja.setId(id);
        movimientoCajaRepository.save(movimientoCaja);
        return "redirect:/movimientos-caja/";
    }

    // Eliminar un movimiento de caja por su ID
    @GetMapping("/{id}/delete")
    public String eliminarMovimientoCaja(@PathVariable Long id) {
        MovimientoCaja movimientoCaja = movimientoCajaRepository.findById(id).get();
        movimientoCaja.remove();
        movimientoCajaRepository.save(movimientoCaja);
        return "redirect:/movimientos-caja/";
    }

    private void setRelationalData(Model model) {
        List<Empleado> empleadosList = empleadosRepository.findByEstado(Estado.ACTIVO);
        List<Cliente> clientesList = clientesRepository.findByEstado(Estado.ACTIVO);
        List<ServicioFacturable> serviciosList = serviciosRepository.findByEstado(Estado.ACTIVO);
        List<TiposDocumento> tiposDocumentoList = documentosRepository.findByEstado(Estado.ACTIVO);
        List<FormaPago> formasPagoList = formasPagoRepository.findByEstado(Estado.ACTIVO);

        model.addAttribute("empleadosList", empleadosList);
        model.addAttribute("clientesList", clientesList);
        model.addAttribute("serviciosList", serviciosList);
        model.addAttribute("tiposDocumentoList", tiposDocumentoList);
        model.addAttribute("formasPagoList", formasPagoList);
    }
}
