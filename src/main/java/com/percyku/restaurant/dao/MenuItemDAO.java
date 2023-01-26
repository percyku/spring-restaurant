package com.percyku.restaurant.dao;

import com.percyku.restaurant.entity.MenuItem;

import java.util.List;

public interface MenuItemDAO {

    public List<MenuItem> getMenuItems(String theMenuName);
    public List<MenuItem> getMenuItems();

    public MenuItem getMenuItem(int theId);

}
