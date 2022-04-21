package ru.gb.gbjmsmart.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.gb.gbjmsmart.model.HelloWorldMessage;

import static ru.gb.gbjmsmart.config.JmsConfig.MY_QUEUE;

@Component
public class HelloListener {

    @JmsListener(destination = MY_QUEUE)
    public void listenMessage(@Payload HelloWorldMessage helloWorldMessage,
                              @Headers MessageHeaders headers){
        System.out.println("-------------");
        System.out.println(helloWorldMessage);
        System.out.println(headers);
        System.out.println("-------------");
    }
}
