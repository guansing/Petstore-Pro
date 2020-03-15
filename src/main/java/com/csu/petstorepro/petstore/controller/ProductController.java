package com.csu.petstorepro.petstore.controller;

import com.csu.petstorepro.petstore.entity.Product;
import com.csu.petstorepro.petstore.service.impl.ProductServiceImpl;
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
@RestController
public class ProductController {
    @Resource
    private ProductServiceImpl productService;

    //映射位置
    @RequestMapping(value = "/getProductList",method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProductList()
    {
        return productService.getProductList();
    }

    @RequestMapping(value = "/getProductById",method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(String productId)
    {
        return productService.getProductById(productId);
    }

    @RequestMapping(value = "/insertProduct",method = RequestMethod.POST)
    @ResponseBody
    //参数中的@RequestBody注解，主要用来接收前端传递给后端的json字符串中的数据，并按字段名称装配给 product 实体类
    public int insertCategory(@RequestBody Product product)
    {
        return productService.insertProduct(product);
    }

    @RequestMapping(value = "/deleteProduct",method = RequestMethod.POST)
    @ResponseBody
    public int deleteCategory(@RequestBody Product product)
    {
        return productService.deleteProduct(product.getProductid());
    }

    @RequestMapping(value = "/updateProduct",method = RequestMethod.POST)
    @ResponseBody
    public int updateCategory(@RequestBody Product product)
    {
        return productService.updateProduct(product);
    }
}
