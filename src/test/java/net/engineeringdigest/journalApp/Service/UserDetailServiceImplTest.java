package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entity.UserEntity;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserDetailServiceImplTest {

    @InjectMocks
    private UserDetailServiceImpl userDetailService;

    @Mock
    UserRepository userRepository;


    @Test
    public void loadUserByUsernameTest(){

        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(UserEntity.builder().userName("aadi").password("aadi").role("ADMIN").build());

        UserDetails userDetails = userDetailService.loadUserByUsername("aadi");
        assertEquals("aadi",userDetails.getUsername());
    }
}
