package ru.gb.gbjmsmart.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.gb.gbjmsmart.model.HelloWorldMessage;
import ru.gb.gbjmsmart.sender.MailService;

import static ru.gb.gbjmsmart.config.JmsConfig.MY_QUEUE;

@Component
@RequiredArgsConstructor
public class HelloListener {

    private final MailService mailService;

    @JmsListener(destination = MY_QUEUE)
    public void listenMessage(@Payload HelloWorldMessage helloWorldMessage,
                              @Headers MessageHeaders headers){
        System.out.println("-------------");
        System.out.println(helloWorldMessage);
        System.out.println(headers);
        System.out.println("-------------");
        mailService.sendSimpleMessage("vitalykri123@gmail.com","Change order", "dfsdf");

    }
}
