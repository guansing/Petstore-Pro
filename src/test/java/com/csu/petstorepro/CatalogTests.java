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


}
