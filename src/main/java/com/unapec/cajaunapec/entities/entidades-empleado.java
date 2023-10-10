@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String cedula;
    private String tandaLabor;
    private LocalDate fechaIngreso;
    private String estado;

    // Getters y setters
}
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipoCliente; // Puedes usar un enum para representar los tipos
    private String carrera;
    private LocalDate fechaRegistro;
    private String estado;

    // Getters y setters
}
@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private BigDecimal precio;

    // Getters y setters
}
@Entity
public class MovimientoCaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String noMovimiento;
    
    @ManyToOne
    private Empleado empleado;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Servicio servicio;

    private String tipoDocumento;
    private String formaPago;
    private LocalDate fechaMovimiento;
    private BigDecimal monto;
    private String estado;

    // Getters y setters
}
