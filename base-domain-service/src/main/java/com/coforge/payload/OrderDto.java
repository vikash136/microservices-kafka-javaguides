package com.coforge.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {


    private String orderId;
    private String orderName;
    private int orderQuantity;
    private double orderPrice;


}
