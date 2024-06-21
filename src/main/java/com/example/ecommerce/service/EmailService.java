package com.example.ecommerce.service;

import java.io.IOException;
import java.util.Map;

public interface EmailService {
//    public void sendSimpleMessage(String to, String subject, String text) throws IOException;
    public void sendHtmlMessage(String to, String subject, String htmlBody) throws IOException;

}
