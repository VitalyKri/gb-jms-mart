package ru.gb.gbjmsmart.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.gb.gbapi.events.OrderEvent;
import ru.gb.gbapi.order.dto.OrderDto;
import ru.gb.gbjmsmart.sender.MailService;

import static ru.gb.gbjmsmart.config.JmsConfig.ORDER_QUEUE;

@Component
@RequiredArgsConstructor
public class OrderListener {

    private final MailService mailService;

    @JmsListener(destination = ORDER_QUEUE)
    public void listen(@Payload OrderEvent orderEvent){
        OrderDto orderDto = orderEvent.getOrderDto();
        mailService.sendSimpleMessage(orderDto.getMail(),"Change order", orderDto.toString());
    }

}
