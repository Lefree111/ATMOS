package com.company;

import com.company.zaybal.EmailService;
import com.company.zaybal.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class AtmocApplication /*implements ApplicationRunner*/ {

/*

    private static Logger log = Logger.getLogger(String.valueOf(AtmocApplication.class));

    @Autowired
    private EmailService emailService;
*/

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AtmocApplication.class, args);
    }

   /* @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Mail mail = new Mail();
        mail.setFrom("lefree111@mail.ru");
        mail.setTo("lefree112@gmail.com");
        mail.setSubject("Welcome ATMOS traning center");
        emailService.sendSimpleMessage(mail);
    }*/

}
