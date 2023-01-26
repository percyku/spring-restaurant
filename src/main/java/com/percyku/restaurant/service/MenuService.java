package com.percyku.restaurant.service;

import com.percyku.restaurant.entity.MenuItem;

import java.util.List;

public interface MenuService {

    public List<MenuItem> getMenuItems(String theMenuName);
    public List<MenuItem> getMenuItems();

 }
