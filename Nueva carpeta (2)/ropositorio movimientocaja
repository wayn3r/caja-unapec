@Entity
public class MovimientoCaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String noMovimiento;
    private String empleado;
    private String cliente;
    private String servicio;
    private String tipoDocumento;
    private String formaPago;
    private LocalDate fechaMovimiento;
    private BigDecimal monto;
    private String estado;

    // Getters y setters
}
public interface MovimientoCajaRepository extends JpaRepository<MovimientoCaja, Long> {
}
@Service
public class MovimientoCajaService {
    @Autowired
    private MovimientoCajaRepository movimientoCajaRepository;

    public List<MovimientoCaja> listarMovimientosCaja() {
        return movimientoCajaRepository.findAll();
    }

    public MovimientoCaja agregarMovimientoCaja(MovimientoCaja movimientoCaja) {
        return movimientoCajaRepository.save(movimientoCaja);
    }
}
