package com.percyku.restaurant.service.imp;

import com.percyku.restaurant.dao.MenuItemDAO;
import com.percyku.restaurant.entity.MenuItem;
import com.percyku.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    private MenuItemDAO menuitemDAO;


    @Override
    @Transactional
    public List<MenuItem> getMenuItems(String theMenuName) {
        return menuitemDAO.getMenuItems(theMenuName);
    }

    @Override
    @Transactional
    public List<MenuItem> getMenuItems() {
        return menuitemDAO.getMenuItems();
    }
}
