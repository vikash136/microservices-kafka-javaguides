package com.coforge.orderservice.producer;


import com.coforge.payload.OrderEventDto;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
    private final KafkaTemplate<String, OrderEventDto> kafkaTemplate;
    private NewTopic javaGuidesTJsonTopic;

    public OrderProducer(NewTopic javaGuidesTJsonTopic, KafkaTemplate<String, OrderEventDto> kafkaTemplate) {
        this.javaGuidesTJsonTopic = javaGuidesTJsonTopic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sedMessage(OrderEventDto orderEventDto) {
        LOGGER.info(String.format("Order Event ->%s", orderEventDto.toString()));

        // create message
        Message<OrderEventDto> orderEventDtoMessageBuilder =
                MessageBuilder
                        .withPayload(orderEventDto)
                        .setHeader(KafkaHeaders.TOPIC,javaGuidesTJsonTopic.name())
                        .build();
        kafkaTemplate.send(orderEventDtoMessageBuilder);
    }
}
