package net.engineeringdigest.journalApp.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void sendMailTest(){

        emailService.sendEmail("aadityaprajapatwork@gmail.com","Checking Mail","Tashi Dilekh!");

    }
}
