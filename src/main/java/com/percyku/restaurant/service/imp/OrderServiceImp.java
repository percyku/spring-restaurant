package com.percyku.restaurant.service.imp;

import com.percyku.restaurant.dao.MenuItemDAO;
import com.percyku.restaurant.dao.OrderDAO;
import com.percyku.restaurant.entity.MenuItem;
import com.percyku.restaurant.entity.Order;
import com.percyku.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private MenuItemDAO menuItemDAO;

    @Override
    @Transactional
    public List<Order> getOrders(boolean showPrice) {
        List<Order> theOrders = orderDAO.getOrders();
        if(theOrders == null )
            return new ArrayList<>();
        if(showPrice){
            List<MenuItem>  theMenuitems =menuItemDAO.getMenuItems();
            Map<String,Double> price =getPrice(theMenuitems);
            for(int i =0 ;i<theOrders.size();i++) {
                theOrders.get(i).setContents(getTotalPrice(theOrders.get(i).getContents(), price));
            }
        }


        return theOrders;
    }

    @Override
    @Transactional
    public Order getOrder(int thdId,boolean showPrice) {

        Order theOrder = orderDAO.getOrder(thdId);

        if(theOrder==null)
            return null;

        if(showPrice){
            List<MenuItem>  theMenuitems =menuItemDAO.getMenuItems();
            Map<String,Double> price =getPrice(theMenuitems);
            theOrder.setContents(getTotalPrice(theOrder.getContents(), price));

        }

        return theOrder;
    }

    @Override
    @Transactional
    public void addNewOrder(Order theOrder) {
        orderDAO.addNewOrder(theOrder);
    }

    @Override
    @Transactional
    public void updatedOrderStatus(Order theOrder) {
        orderDAO.updatedOrderStatus(theOrder);
    }



    private Map getPrice(List<MenuItem> theMenuitems){

        Map<String,Double> map =new HashMap<>();

        for(int i =0;i<theMenuitems.size();i++){
            String id = String.valueOf(theMenuitems.get(i).getId());
            if(!map.containsKey(id)){
                map.put(id,theMenuitems.get(i).getPrice());
            }
        }
        return map;
    }


    private String getTotalPrice(String theContents,Map<String,Double> price){

        String[] contents =theContents.split(":");
        double totalPrice =0.0;
        for(String items: contents) {
            String itemId =items.split(",")[0];
            String itemNum=items.split(",")[1];
            double tmpPrice= price.get(itemId);
            totalPrice = totalPrice +(tmpPrice * Double.valueOf(itemNum));
        }
        return String.valueOf(totalPrice);

    }



}
