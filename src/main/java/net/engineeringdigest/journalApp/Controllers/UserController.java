package net.engineeringdigest.journalApp.Controllers;

import net.engineeringdigest.journalApp.DTOs.UserRequestDTO;
import net.engineeringdigest.journalApp.DTOs.UserResponseDTO;
import net.engineeringdigest.journalApp.Entity.UserEntity;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*") // OR use your frontend origin instead of '*'
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<UserResponseDTO> getAllUsers(){
        List<UserEntity> users = userService.getAll();
        List<UserResponseDTO> dtoList = new ArrayList<>();
        for (UserEntity user:users){
            UserResponseDTO dto = new UserResponseDTO();
            dto.setUserName(user.getUserName());
            dto.setRole(user.getRole());
            dto.setId(String.valueOf(user.getId()));
            dtoList.add(dto);
        }
        return dtoList;
    }

    @PostMapping
    public boolean addUser(@RequestBody UserRequestDTO dto){
        UserEntity user = new UserEntity();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        boolean save = userService.save(user);
        return save;
    }

    @GetMapping("/me")
    public UserResponseDTO getUserById(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserEntity user = userRepository.findByUserName(username);
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId().toString());
        dto.setUserName(user.getUserName());
        dto.setRole(user.getRole());
        return dto;
    }
}
