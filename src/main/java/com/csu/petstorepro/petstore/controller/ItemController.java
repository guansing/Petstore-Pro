package com.csu.petstorepro.petstore.controller;

import com.csu.petstorepro.petstore.entity.Item;
import com.csu.petstorepro.petstore.service.impl.ItemServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lgx
 * @since 2020-03-15
 */
@RestController
public class ItemController {
    @Resource
    private ItemServiceImpl itemService;

    //映射位置
    @RequestMapping(value = "/getItemList",method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getItemList()
    {
        //返回一个service
        return itemService.getItemList();
    }

    @RequestMapping(value = "/getItemById",method = RequestMethod.GET)
    @ResponseBody
    public Item getItemById(String itemId)
    {
        return itemService.getItemById(itemId);
    }

    @RequestMapping(value = "/insertItem",method = RequestMethod.POST)
    @ResponseBody
    //参数中的@RequestBody注解，主要用来接收前端传递给后端的 json 字符串中的数据，并按字段名称装配给 item 实体类
    public int insertItem(@RequestBody Item item)
    {
        return itemService.insertItem(item);
    }

    @RequestMapping(value = "/deleteItem",method = RequestMethod.POST)
    @ResponseBody
    public int deleteItem(@RequestBody Item item)
    {
        return itemService.deleteItem(item.getItemid());
    }

    @RequestMapping(value = "/updateItem",method = RequestMethod.POST)
    @ResponseBody
    public int updateCategory(@RequestBody Item item)
    {
        return itemService.updateItem(item);
    }
}
