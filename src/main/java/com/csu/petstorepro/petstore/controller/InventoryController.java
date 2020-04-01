package com.csu.petstorepro.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.csu.petstorepro.petstore.common.ReturnEntity;
import com.csu.petstorepro.petstore.entity.Category;
import com.csu.petstorepro.petstore.entity.Inventory;
import com.csu.petstorepro.petstore.service.impl.InventoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
@RestController
//@RequestMapping("/petstore/inventory")
public class InventoryController {
    @Resource
    private InventoryServiceImpl inventoryService;

    @RequestMapping(value = "/getQtyBySupplier",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getQtyBySupplier(String itemid)
    {
        JSONObject data = new JSONObject();
        Inventory inventory = inventoryService.getQtyBySupplier(itemid);
        data.put("inventory",inventory);
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "/updateQtyBySupplier",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity updateQtyBySupplier(@RequestBody Inventory inventory)
    {
        JSONObject data = new JSONObject();
        int result = inventoryService.updateQtyBySupplier(inventory);
        data.put("result",result);
        return ReturnEntity.successResult(data);
    }


}
