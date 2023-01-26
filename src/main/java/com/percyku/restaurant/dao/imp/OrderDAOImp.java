package com.percyku.restaurant.dao.imp;

import com.percyku.restaurant.dao.OrderDAO;
import com.percyku.restaurant.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderDAOImp implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Order getOrder(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Order theOrder =currentSession.get(Order.class,theId);
        currentSession.clear();
        return theOrder;
    }

    @Override
    public List<Order> getOrders() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Order> theQuery =currentSession.createQuery("from Order order by id"
                ,Order.class);

        List<Order> orders =theQuery.getResultList();
        currentSession.clear();
        return orders;
    }

    @Override
    public void addNewOrder(Order theOrder) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theOrder);
    }

    @Override
    public void updatedOrderStatus(Order theOrder) {
        Session currentSession =sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theOrder);
    }

//    @Override
//    public int getOrderSize() {
//        return 0;
//    }
//
//    @Override
//    public int newOrder(String userName) {
//        return 0;
//    }
//
//    @Override
//    public void addToOrder() {
//
//    }



}
