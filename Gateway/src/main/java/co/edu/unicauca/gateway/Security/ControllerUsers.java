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
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/hello2")
    public String hello2(){
        return "Hello World ADMIN";
    }
    @GetMapping("/hello4")
    public String hello4(){
        return "Hello World Admin";
    }
    @GetMapping("/hello5")
    public String hello5(){
        return "Hello World Admin";
    }
}
