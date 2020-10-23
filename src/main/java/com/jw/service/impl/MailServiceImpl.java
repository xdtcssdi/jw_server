package com.jw.service.impl;

import com.jw.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

@Service
@Transactional
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void sendMail(String from, String[] to, String title, String content) {

        System.out.println("send");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); //腾讯的限制，发送人必须与发送邮箱相同，不同会报异常
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);

        try {
            mailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发送简单邮件失败");
        }

        System.out.println("send mail to: "+ Arrays.toString(to) +"and content: "+ content);
    }
}