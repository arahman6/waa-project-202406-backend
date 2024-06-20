package com.example.ecommerce.controller;

import com.example.ecommerce.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) {
        try {
            emailService.sendSimpleMessage(to, subject, text);
            return "Email sent successfully";
        } catch (IOException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }

    @GetMapping("/send-html-email")
    public String sendHtmlEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String htmlBody) {
        try {
            emailService.sendHtmlMessage(to, subject, htmlBody);
            return "HTML Email sent successfully";
        } catch (IOException e) {
            return "Failed to send HTML email: " + e.getMessage();
        }
    }
}

