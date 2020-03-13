package com.csu.petstorepro.petstore.controller;


import com.csu.petstorepro.petstore.entity.Category;
import com.csu.petstorepro.petstore.entity.Product;
import com.csu.petstorepro.petstore.service.impl.CategoryServiceImpl;
import com.csu.petstorepro.petstore.service.impl.ProductServiceImpl;
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
@RestController
@RequestMapping("/petstore/product")
public class ProductController {

    @Resource
    private ProductServiceImpl productService;

    @GetMapping("getProductList")
    public List<Product> getProductList()
    {
        return productService.getProductList();
    }

    @GetMapping("getProductById")
    public Product getProductById(String productId)
    {
        return productService.getProductById(productId);
    }

    @GetMapping("insertProduct")
    public int insertProduct(Product product)
    {
        return productService.insertProduct(product);
    }

    @GetMapping("deleteProduct")
    public int deleteProduct(String productId)
    {
        return productService.deleteProduct(productId);
    }

    @GetMapping("productProduct")
    public int updateProduct(Product product)
    {
        return productService.updateProduct(product);
    }
}
