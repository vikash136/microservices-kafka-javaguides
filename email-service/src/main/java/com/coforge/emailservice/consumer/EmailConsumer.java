package com.coforge.emailservice.consumer;


import com.coforge.payload.OrderEventDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailConsumer.class);


    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeEmail(OrderEventDto orderEventDto) {
        LOGGER.info(String.format("order event   received in email service ->%s",orderEventDto.toString()));

        //send email to the customer

    }

}
