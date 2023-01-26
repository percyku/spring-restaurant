package com.percyku.restaurant.dao;

import com.percyku.restaurant.entity.Order;

import java.util.List;

public interface OrderDAO {

    public Order getOrder(int theId);
    public List<Order> getOrders();

    public void addNewOrder(Order theOrder);

    public void updatedOrderStatus(Order theOrder);



}
