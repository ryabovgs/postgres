package com.example.postgre.service;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
}
