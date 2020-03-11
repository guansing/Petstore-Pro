package com.csu.petstorepro;

import com.csu.petstorepro.petstore.entity.Category;
import com.csu.petstorepro.petstore.mapper.CategoryMapper;
import com.csu.petstorepro.petstore.service.impl.CategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogTests
{
    @Resource
    private CategoryServiceImpl categoryService;

    @Test
    public void check()
    {
        Category category = categoryService.getCategory("FISH");
        System.out.println(category);
    }

    @Test
    public void deleteCategoryTest()
    {
        Integer result = categoryService.deleteCategory("A");
        System.out.println(result);
    }

    @Test
    public void updateCategoryTest()
    {
        Category category=new Category();
        category.setCatid("A");
        category.setName("BBB");
        category.setDescn("des");
        Integer result = categoryService.updateCategory(category);
        System.out.println(result);
    }

    @Test
    public void insertCategoryTest()
    {
        Category category=new Category();
        category.setCatid("A11");
        category.setName("BBB111");
        category.setDescn("des11111111");
        Integer result = categoryService.insertCategory(category);
        System.out.println(result);
    }


}
