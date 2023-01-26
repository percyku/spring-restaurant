package com.percyku.restaurant.controller;

import com.percyku.restaurant.entity.MenuItem;
import com.percyku.restaurant.entity.Order;
import com.percyku.restaurant.service.MenuService;
import com.percyku.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private MenuService menuService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public String getMenuItems(Model theModel){

        List<MenuItem> theMenuItems =menuService.getMenuItems();
        theModel.addAttribute("menuItems",theMenuItems);

        return "order";
    }

    @PostMapping("/getOrder")
    public String getOrder(HttpServletRequest request){
        List<MenuItem>theMenuitems  = menuService.getMenuItems();
        String content="";
        Double total=0.0;

        for (int i = 1; i <theMenuitems.size()+1; i++) {
            String quantity = request.getParameter("item_" + i);
            if(quantity.equals(""))
                continue;

            try {
                int q = Integer.parseInt(quantity);
                if (q > 0) {
                    content+=""+i+","+q+":";
                    total +=(theMenuitems.get(i).getPrice()*q);
                }
            }catch (Exception e){
                continue;
            }
        }

        if(content.equals(""))
            return  "redirect:/order/list";

        Order theOrder =new Order();
        theOrder.setContents(content.substring(0,content.length()-1));
        theOrder.setStatus("pending");
        theOrder.setCustomer("Percy");

        orderService.updatedOrderStatus(theOrder);

        HttpSession session = request.getSession();
        session.setAttribute("total", total);
        session.setAttribute("id", theOrder.getId());
        session.setAttribute("status", theOrder.getStatus());

        return  "thankYou";
    }




    @GetMapping("/getOrder")
    public String getOrderTest(@RequestParam("id") @PathVariable int id,
                               HttpServletRequest request ){

        Order theOrder = orderService.getOrder(id,true);

        HttpSession session = request.getSession();
        session.setAttribute("total", theOrder.getContents());
        session.setAttribute("id", theOrder.getId());
        session.setAttribute("status", theOrder.getStatus());

        return  "thankYou";

    }




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

        return  "redirect:/order/processorder";
    }









}
