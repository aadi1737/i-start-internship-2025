package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entity.UserEntity;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @InjectMocks
    private UserService userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;


    @Test
    public void getAllTest(){

        List<UserEntity> mockUsers = Arrays.asList(
                new UserEntity(new ObjectId(), "aadi", "paassword", "USER"),
                new UserEntity(new ObjectId(), "aryan", "paassword", "USER"));
        when(userRepository.findAll()).thenReturn(mockUsers);
        assertEquals(2,userService.getAll().size());
    }


    @Test
    public void saveTest(){
        UserEntity inputUser = new UserEntity();
        inputUser.setPassword("abc");

        UserEntity savedUser = new UserEntity();
        savedUser.setPassword("encoded String");

        when(passwordEncoder.encode(anyString())).thenReturn("encoded String");
        when(userRepository.save(any(UserEntity.class))).thenReturn(savedUser);

        assertTrue(userService.save(inputUser));
    }

    @Test
    public void getByIdTest(){

        UserEntity returnUser = UserEntity.builder().userName("aadi").password("aadi").build();
        ObjectId inputId = new ObjectId();
        when(userRepository.findById(inputId)).thenReturn(Optional.ofNullable(returnUser));

        assertEquals("aadi",userService.getById(inputId).getUserName());
    }

}
