package com.percyku.restaurant.controller;

import com.percyku.restaurant.entity.MenuItem;
import com.percyku.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public String getMenuItems(Model theModel){

        List<MenuItem> theMenuItems =menuService.getMenuItems();
        theModel.addAttribute("menuItems",theMenuItems);

        return "list-menu";
    }


    @GetMapping("/showSearchPage")
    public String showSearchPage(){

        return "search";
    }

    @GetMapping("/showSearchResults")
    public String getMenuItem(@RequestParam("menuItemName") @PathVariable String menuItemName, Model theModel){

        List<MenuItem> theMenuItems =menuService.getMenuItems(menuItemName);
        if(theMenuItems == null )
            theMenuItems=new ArrayList<>();

        theModel.addAttribute("menuItems",theMenuItems);
        return "searchResults";
    }




}
