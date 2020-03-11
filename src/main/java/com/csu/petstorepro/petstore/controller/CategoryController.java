package com.csu.petstorepro.petstore.controller;


import com.csu.petstorepro.petstore.entity.Category;
import com.csu.petstorepro.petstore.service.impl.CategoryServiceImpl;
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
 * @since 2020-03-10
 */
//@RestController这个注解表示这是一个控制器
@RestController
//位置
@RequestMapping("/petstore/category")
public class CategoryController {
    @Resource
    private CategoryServiceImpl categoryService;
    //映射位置
    @GetMapping("findAll")
    public List<Category> categoryList(){
        //返回一个service
        return categoryService.getCategoryList();
    }

    @GetMapping("findCategoryById")
    public Category getCategory(String categoryId)
    {
        return categoryService.getCategory(categoryId);
    }

    @GetMapping("insertCategory")
    public int insertCategory(Category category)
    {
        return categoryService.insertCategory(category);
    }
}
