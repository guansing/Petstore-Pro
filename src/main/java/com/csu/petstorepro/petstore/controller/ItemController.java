package com.csu.petstorepro.petstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.csu.petstorepro.petstore.common.ReturnEntity;
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
    @RequestMapping(value = "/getItemListByProduct",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getItemListByProduct(String productId)
    {
        //返回一个service
        JSONObject data = new JSONObject();

        List<Item> itemList = itemService.getItemListByProduct(productId);
        data.put("itemList",itemList);
        return ReturnEntity.successResult(data);
    }


    @RequestMapping(value = "/getItemById",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getItemById(String itemId)
    {
        JSONObject data = new JSONObject();

        Item item = itemService.getItemById(itemId);
        data.put("item",item);
        return ReturnEntity.successResult(data);
    }



    @RequestMapping(value = "/insertItem",method = RequestMethod.POST)
    @ResponseBody
    //参数中的@RequestBody注解，主要用来接收前端传递给后端的 json 字符串中的数据，并按字段名称装配给 item 实体类
    public ReturnEntity insertItem(@RequestBody Item item)
    {
        JSONObject data = new JSONObject();

        int result = itemService.insertItem(item);
        data.put("result",result);
        return ReturnEntity.successResult(data);
    }


    @RequestMapping(value = "/deleteItem",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity deleteItem(@RequestBody String itemId)
    {
        JSONObject data = new JSONObject();

        int result = itemService.deleteItem(itemId);
        data.put("result",result);
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "/updateItem",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity updateItem(@RequestBody Item item)
    {
        JSONObject data = new JSONObject();

        int result = itemService.updateItem(item);
        data.put("result",result);
        return ReturnEntity.successResult(data);
    }
}
