package co.edu.unicauca.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class Controller {

    public Controller(){}
    @GetMapping
    @PreAuthorize("hasRole('Organier')")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/hello2")
    @PreAuthorize("hasRole('Author')")
    public String hello2(){
        return "Hello World ADMIN";
    }
}
