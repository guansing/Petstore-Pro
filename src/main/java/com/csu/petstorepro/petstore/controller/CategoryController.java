package com.csu.petstorepro.petstore.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.csu.petstorepro.petstore.common.ReturnEntity;
import com.csu.petstorepro.petstore.entity.Category;
import com.csu.petstorepro.petstore.service.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
//@RestController这个注解表示这是一个控制器
@RestController
//位置
//@RequestMapping("/petstore/category")
public class CategoryController {
    @Resource
    private CategoryServiceImpl categoryService;

    //映射位置
    @RequestMapping(value = "/getCategoryList",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getCategoryList()
    {
        JSONObject data = new JSONObject();
        List<Category> categoryList = categoryService.getCategoryList();
        data.put("categoryList",categoryList);
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "/getCategoryById",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getCategoryById(String categoryId)
    {
        JSONObject data = new JSONObject();
        Category category = categoryService.getCategoryById(categoryId);
        data.put("category",category);
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "/insertCategory",method = RequestMethod.POST)
    @ResponseBody
    //参数中的@RequestBody注解，主要用来接收前端传递给后端的json字符串中的数据，并按字段名称装配给category实体类
    public ReturnEntity insertCategory(@RequestBody Category category)
    {
        JSONObject data = new JSONObject();
        int result = categoryService.insertCategory(category);
        data.put("result",result);
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "/deleteCategory",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity deleteCategory(@RequestBody Category category)
    {
        JSONObject data = new JSONObject();
        int result = categoryService.deleteCategory(category.getCatid());
        data.put("result",result);
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "/updateCategory",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity updateCategory(@RequestBody Category category)
    {
        JSONObject data = new JSONObject();
        int result = categoryService.updateCategory(category);
        data.put("result",result);
        return ReturnEntity.successResult(data);
    }
}
