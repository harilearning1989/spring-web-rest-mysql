package com.web.demo.services;

public interface EmailService {
    void sendEmail() throws Exception;

    void sendSimpleEmail(String email, String welcome, String s);

   // void sendEmailWithAttachment(String email, String orderConfirmation, String thanksForYourRecentOrder, String s);
}
