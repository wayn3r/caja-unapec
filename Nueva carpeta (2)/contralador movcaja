
@Controller
@RequestMapping("/movimientos-caja")
public class MovimientoCajaController {
    @Autowired
    private MovimientoCajaService movimientoCajaService;

    @GetMapping("/listar")
    public String listarMovimientosCaja(Model model) {
        List<MovimientoCaja> movimientosCaja = movimientoCajaService.listarMovimientosCaja();
        model.addAttribute("movimientosCaja", movimientosCaja);
        return "listarMovimientosCaja";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("movimientoCaja", new MovimientoCaja());
        return "formularioMovimientoCaja";
    }

    @PostMapping("/guardar")
    public String guardarMovimientoCaja(@ModelAttribute("movimientoCaja") MovimientoCaja movimientoCaja) {
        movimientoCajaService.agregarMovimientoCaja(movimientoCaja);
        return "redirect:/movimientos-caja/listar";
    }
}
