package com.jw.service;

public interface MailService {
    void sendMail(String from, String[] to, String title,String content);
}