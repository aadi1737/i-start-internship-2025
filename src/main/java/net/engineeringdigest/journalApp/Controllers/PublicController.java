package net.engineeringdigest.journalApp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
    @GetMapping("/i-start")
    public String welcome(){
        return "We welcome you to the incubation center!";
    }
}
