package ru.gb.gbjmsmart.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    
    private final JavaMailSender emailSender;
    
    public void sendSimpleMessage(String to, String subject,String text){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("kropotov.geek@gmail.com");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        emailSender.send(mailMessage);

    }
}
