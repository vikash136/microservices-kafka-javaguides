package com.coforge.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEventDto {

    private String orderMessage;
    private String orderStatus;
    private OrderDto orderDto;
}
