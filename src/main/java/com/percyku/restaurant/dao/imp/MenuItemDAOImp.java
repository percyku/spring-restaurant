package com.percyku.restaurant.dao.imp;

import com.percyku.restaurant.dao.MenuItemDAO;
import com.percyku.restaurant.entity.MenuItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MenuItemDAOImp implements MenuItemDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<MenuItem> getMenuItems() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<MenuItem> theQuery =currentSession.createQuery("from MenuItem"
                ,MenuItem.class);

        List<MenuItem> menuitems =theQuery.getResultList();

        return menuitems;
    }

    @Override
    public MenuItem getMenuItem(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();
        MenuItem theMenuItem = currentSession.get(MenuItem.class, theId);
        return theMenuItem;
    }


    @Override
    public List<MenuItem> getMenuItems(String theMenuName) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<MenuItem> theQuery =currentSession.createQuery("from MenuItem where name like:theMenuName "
                ,MenuItem.class);

        theQuery.setParameter("theMenuName","%"+theMenuName+"%");

        List<MenuItem> menuitems =theQuery.getResultList();

        return menuitems;
    }
}
