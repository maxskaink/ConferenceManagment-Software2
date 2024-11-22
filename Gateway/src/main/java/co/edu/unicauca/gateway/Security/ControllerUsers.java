package co.edu.unicauca.gateway.Security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class ControllerUsers {
    public ControllerUsers() {}
    @GetMapping
    //@PreAuthorize("hasRole('Organier')")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/hello2")
    @PreAuthorize("hasRole('Author')")
    public String hello2(){
        return "Hello World ADMIN";
    }
}
