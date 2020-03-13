package com.csu.petstorepro.petstore.controller;


import com.csu.petstorepro.petstore.entity.Item;
import com.csu.petstorepro.petstore.service.impl.CategoryServiceImpl;
import com.csu.petstorepro.petstore.service.impl.ItemServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lgx
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/petstore/item")
public class ItemController {

    @Resource
    private ItemServiceImpl itemService;

    @GetMapping("getItemList")
    public List<Item> getItemList()
    {
        return itemService.getItemList();
    }

    @GetMapping("getItemById")
    public Item getItemById(String itemId)
    {
        return itemService.getItemById(itemId);
    }

    @GetMapping("insertItem")
    public int insertItem(Item item)
    {
        return itemService.insertItem(item);
    }

    @GetMapping("deleteItem")
    public int deleteItem(String itemId)
    {
        return itemService.deleteItem(itemId);
    }

    @GetMapping("updateItem")
    public int updateItem(Item item)
    {
        return itemService.updateItem(item);
    }

}
