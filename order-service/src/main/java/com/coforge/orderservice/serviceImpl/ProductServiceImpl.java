package com.coforge.orderservice.serviceImpl;

import com.coforge.orderservice.producer.OrderProducer;
import com.coforge.payload.OrderDto;
import com.coforge.payload.OrderEventDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl {


    private OrderProducer orderProducer;

    public ProductServiceImpl(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    public String placeOrder(OrderDto orderDto) {

        orderDto.setOrderId(UUID.randomUUID().toString());
        OrderEventDto orderEventDto = new OrderEventDto();
        orderEventDto.setOrderStatus("PENDING");
        orderEventDto.setOrderMessage("Order status is in pending");
        orderEventDto.setOrderDto(orderDto);
        orderProducer.sedMessage(orderEventDto);

        return  "Order Placed Successfully";


    }
}
