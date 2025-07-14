package net.engineeringdigest.journalApp.Controllers;

import net.engineeringdigest.journalApp.DTOs.LoginDTO;
import net.engineeringdigest.journalApp.Service.PublicService;
import net.engineeringdigest.journalApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class PublicController {

    @Autowired
    private PublicService publicService;
    @GetMapping("/greet")
    public String welcome(HttpServletRequest request){
        return "Tashi Dilek!"+request.getSession().getId();
    }


    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginDTO dto){
        String verify = publicService.verify(dto);
        return verify;
    }
}