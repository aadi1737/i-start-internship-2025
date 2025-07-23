package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PracticeTestClass {

    @Autowired
    private UserRepository userRepository;


    @Disabled
    @Test
    public void checkTest(){
        assertEquals(4,2+2);
    }

    @ParameterizedTest
    @CsvSource({
            "aadi",
            "akshat",
            "ajay",
            "ad",
            "aryan"
    })
    public void findByUsername(String username){
        assertNotNull(userRepository.findByUserName(username));
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,3,5",
            "1,3,2"
    })
    public  void addTest(int a,int b,int sum){
        assertEquals(sum,a+b);
    }

}


