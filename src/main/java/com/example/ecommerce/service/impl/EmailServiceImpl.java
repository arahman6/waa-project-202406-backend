package com.example.ecommerce.service.impl;

import com.example.ecommerce.service.EmailService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${smtp2go.api.base-url}")
    private String apiBaseUrl;

    @Value("${smtp2go.api.key}")
    private String apiKey;

    //    public void sendSimpleMessage(String to, String subject, String text) throws IOException {
//        Map<String, Object> emailData = new HashMap<>();
//        emailData.put("api_key", apiKey);
//
//        Map<String, Object> data = new HashMap<>();
//        data.put("sender", "your-email@example.com"); // Replace with your "from" email
//        data.put("to", new String[]{to});
//        data.put("subject", subject);
//        data.put("text_body", text);
//
//        emailData.put("data", data);
//
//        sendEmail(emailData);
//    }

    public void sendHtmlMessage(String to, String subject, String htmlBody) throws IOException {
        Map<String, Object> emailData = new HashMap<>();
        String sender = "company-info@example.com";
        emailData.put("sender", sender);
        emailData.put("to", new String[]{to});
        emailData.put("subject", subject);
        emailData.put("html_body", htmlBody);

        sendEmail(emailData);
    }


    private void sendEmail(Map<String, Object> emailData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(emailData);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(apiBaseUrl + "email/send");
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("X-Smtp2go-Api-Key", apiKey);
            httpPost.setEntity(new StringEntity(json, StandardCharsets.UTF_8));

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println(responseString);
            }
        } catch (IOException e) {
            throw new MailSendException("Failed to send email", e);
        }
    }



}

