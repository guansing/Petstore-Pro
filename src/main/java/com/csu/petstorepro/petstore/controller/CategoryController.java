package com.csu.petstorepro.petstore.controller;


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
    public List<Category> getCategoryList()
    {
        //返回一个service
        return categoryService.getCategoryList();
    }

    @RequestMapping(value = "/getCategoryById",method = RequestMethod.GET)
    @ResponseBody
    public Category getCategoryById(String categoryId)
    {
        return categoryService.getCategoryById(categoryId);
    }

    @RequestMapping(value = "/insertCategory",method = RequestMethod.POST)
    @ResponseBody
    //参数中的@RequestBody注解，主要用来接收前端传递给后端的json字符串中的数据，并按字段名称装配给category实体类
    public int insertCategory(@RequestBody Category category)
    {
        return categoryService.insertCategory(category);
    }

    @RequestMapping(value = "/deleteCategory",method = RequestMethod.POST)
    @ResponseBody
    public int deleteCategory(@RequestBody Category category)
    {
        return categoryService.deleteCategory(category.getCatid());
    }

    @RequestMapping(value = "/updateCategory",method = RequestMethod.POST)
    @ResponseBody
    public int updateCategory(@RequestBody Category category)
    {
        return categoryService.updateCategory(category);
    }
}
