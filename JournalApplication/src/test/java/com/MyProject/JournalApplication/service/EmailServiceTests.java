package com.MyProject.JournalApplication.service;

import com.MyProject.JournalApplication.Service.EmailService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Disabled
    @Test
    void testSendMail(){
        emailService.sendEmail("ansarikaif8587@gmail.com","Testing java mail sender ", "hey, russian is available on the price of 6000 ");

    }
}
