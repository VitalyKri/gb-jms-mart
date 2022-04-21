package ru.gb.gbjmsmart.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.gb.gbjmsmart.model.HelloWorldMessage;

import static ru.gb.gbjmsmart.config.JmsConfig.MY_QUEUE;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;// парсит к Json

    @Scheduled(fixedRate = 5000)// каждые 5 сек отправляет
    public void sendMessage(){
        HelloWorldMessage message = HelloWorldMessage.builder().message("Hello world.").build();
        jmsTemplate.convertAndSend(MY_QUEUE,message);
    }

}
