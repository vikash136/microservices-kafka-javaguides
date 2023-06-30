package com.coforge.orderservice.controller;


import com.coforge.orderservice.producer.OrderProducer;
import com.coforge.orderservice.serviceImpl.ProductServiceImpl;
import com.coforge.payload.OrderDto;
import com.coforge.payload.OrderEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private ProductServiceImpl productServiceImpl;


    @PostMapping("/orders")
    //@RequestBody json object to java object
    public String placeOrder(@RequestBody OrderDto orderDto){
        return productServiceImpl.placeOrder(orderDto);

    }

}
