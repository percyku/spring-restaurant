package com.percyku.restaurant.controller;

import com.percyku.restaurant.entity.Order;
import com.percyku.restaurant.service.MenuService;
import com.percyku.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/manage")
public class ManagerController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/processorder")
    public String getProcessorder(Model theModel){
        List<Order> theOrders = orderService.getOrders(true);
        if(theOrders == null )
            theOrders=new ArrayList<>();

//        List<MenuItem>  theMenuitems =menuService.getMenuItems();
//        Map<String,Double> price =getPrice(theMenuitems);
//        for(int i =0 ;i<theOrders.size();i++) {
//            theOrders.get(i).setContents(getTotalPrice(theOrders.get(i).getContents(), price));
//        }
        theModel.addAttribute("orders",theOrders);


        List<String> statuses = new ArrayList<String>();
        statuses.add("order accepted");
        statuses.add("payment received");
        statuses.add("being prepared");
        statuses.add("ready for collection");
        theModel.addAttribute("statuses", statuses);

        return  "processorder";

    }


    @PostMapping("/processorder")
    public String updateProcessorder(@RequestParam("orderId") @PathVariable int orderId,
                                     @RequestParam("orderStatus") @PathVariable String orderStatus){

        Order theOrder =orderService.getOrder(orderId,false);
        theOrder.setStatus(orderStatus);
        orderService.updatedOrderStatus(theOrder);

        return  "redirect:/manage/processorder";
    }




}
