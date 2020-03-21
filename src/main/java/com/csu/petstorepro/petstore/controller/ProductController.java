package com.csu.petstorepro.petstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.csu.petstorepro.petstore.common.ReturnEntity;
import com.csu.petstorepro.petstore.entity.Category;
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
    @RequestMapping(value = "/getProductListByCategory",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getProductListByCategory(String categoryId)
    {
        //1.定义JSON
        JSONObject data = new JSONObject();
        //2.调用Service
        List<Product> productList = productService.getProductListByCategory(categoryId);
        //3.压入数据
        data.put("productList",productList);
        //4.返回数据
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "/getProductById",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getProductById(String productId)
    {
        JSONObject data = new JSONObject();
        Product product = productService.getProductById(productId);
        data.put("product",product);
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "searchProductList",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity searchProductList(String name){
        JSONObject data = new JSONObject();
        List<Product> productList = productService.searchProductList(name);
        data.put("productList",productList);
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "/insertProduct",method = RequestMethod.POST)
    @ResponseBody
    //参数中的@RequestBody注解，主要用来接收前端传递给后端的json字符串中的数据，并按字段名称装配给 product 实体类
    public ReturnEntity insertProduct(@RequestBody Product product)
    {
        JSONObject data = new JSONObject();
        int result = productService.insertProduct(product);
        data.put("result",result);
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "/deleteProduct",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity deleteProduct(@RequestBody Product product)
    {
        JSONObject data = new JSONObject();
        int result = productService.deleteProduct(product.getProductid());
        data.put("result",result);
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "/updateProduct",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity updateProduct(@RequestBody Product product)
    {
        JSONObject data = new JSONObject();
        int result = productService.updateProduct(product);
        data.put("result",result);
        return ReturnEntity.successResult(data);
    }
}
