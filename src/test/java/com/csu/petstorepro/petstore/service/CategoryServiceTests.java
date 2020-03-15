package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Category;
import com.csu.petstorepro.petstore.mapper.CategoryMapper;
import com.csu.petstorepro.petstore.service.impl.CategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTests
{
    @Resource
    private CategoryServiceImpl categoryService;

    //对getCategoryList方法进行测试【测试无问题】
    @Test
    public void getCategoryList()
    {
        List<Category> categoryList = categoryService.getCategoryList();
        System.out.println(categoryList);
    }

    //对getCategoryById方法进行测试【测试无问题】
    @Test
    public void getCategoryById()
    {
        Category category = categoryService.getCategoryById("FISH");
        System.out.println(category);
    }

    //对insertCategory方法进行测试【测试无问题】
    @Test
    public void insertCategory()
    {
        Category category=new Category();
        category.setCatid("A2");
        category.setName("BBB111");
        category.setDescn("des11111111");
        Integer result = categoryService.insertCategory(category);
        System.out.println(result);
    }

    //对deleteCategory方法进行测试【测试无问题】
    @Test
    public void deleteCategory()
    {
        Integer result = categoryService.deleteCategory("A");
        System.out.println(result);
    }

    //对updateCategory方法进行测试【测试无问题】
    @Test
    public void updateCategory()
    {
        Category category=new Category();
        category.setCatid("A2");
        category.setName("BBB");
        category.setDescn("des");
        Integer result = categoryService.updateCategory(category);
        System.out.println(result);
    }
}
