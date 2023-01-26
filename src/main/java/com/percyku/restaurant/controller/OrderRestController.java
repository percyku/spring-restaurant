package com.percyku.restaurant.controller;

import com.percyku.restaurant.entity.Order;
import com.percyku.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/api")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/checkOrderStatus")
    public Order checkOrderStatus(@RequestParam("id") @PathVariable String id){

        Order theOrder =orderService.getOrder(Integer.valueOf(id),true);

        return theOrder;
    }


}
