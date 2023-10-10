@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificador;
    private String nombre;
    private String cedula;
    private String tandaLabor;
    private LocalDate fechaIngreso;
    private String estado;

    // Getters y setters
}
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado agregarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}
//ejemplobd

spring.datasource.url=jdbc:mysql://localhost:3306/nombre_base_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
