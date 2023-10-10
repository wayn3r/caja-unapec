@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/listar")
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "listarClientes";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formularioCliente";
    }

    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        model.addAttribute("cliente", cliente);
        return "formularioCliente";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/clientes/listar";
    }
}
