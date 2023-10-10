@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nombre;
    private int tipoCliente;
    private String carrera;
    private LocalDate fRegistro;
    private String estado;

    // Getters y setters
}
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
