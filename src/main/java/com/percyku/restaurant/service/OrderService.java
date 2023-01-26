package com.percyku.restaurant.service;

import com.percyku.restaurant.entity.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getOrders(boolean showPrice);

    public Order getOrder(int thdId,boolean showPrice);

    public void addNewOrder(Order theOrder);


    public void updatedOrderStatus(Order theOrder);

}
