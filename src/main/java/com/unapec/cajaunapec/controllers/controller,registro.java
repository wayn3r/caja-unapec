import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping
    public String registerPage() {
        return "register"; // Esto devuelve el nombre de la vista HTML (sin la extensión .html)
    }

    @PostMapping
    public String registerUser(@RequestParam("name") String name,
                               @RequestParam("address") String address,
                               @RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("phone") String phone,
                               @RequestParam("role") String role,
                               Model model) {
        // Aquí puedes agregar la lógica para registrar al usuario en tu base de datos
        // y realizar otras operaciones necesarias, como encriptar la contraseña, etc.

        // Por simplicidad, simplemente estamos devolviendo una vista de confirmación
        // Aquí podrías realizar la lógica real de registro de usuario

        model.addAttribute("message", "User registered successfully!");
        return "registration_confirmation"; // Puedes crear una vista de confirmación
    }
}
