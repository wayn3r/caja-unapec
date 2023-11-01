import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Date sessionExpirationTime;

    // Resto de los campos y métodos getter y setter

    public Date getSessionExpirationTime() {
        return sessionExpirationTime;
    }

    public void setSessionExpirationTime(Date sessionExpirationTime) {
        this.sessionExpirationTime = sessionExpirationTime;
    }
}
