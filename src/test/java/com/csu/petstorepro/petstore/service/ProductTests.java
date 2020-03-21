package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Product;
import com.csu.petstorepro.petstore.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTests
{
    @Resource
    private ProductServiceImpl productService;

    //对getProductList方法进行测试【测试无问题】
    @Test
    public void getProductList()
    {
        List<Product> productList = productService.getProductListByCategory("FISH");
        System.out.println(productList);
    }

    //对getProductById方法进行测试【测试无问题】
    @Test
    public void getProductById()
    {
        Product product = productService.getProductById("AV-CB-01");
        System.out.println(product);
    }

    @Test
    public void searchProductList(){
        List<Product> productList = productService.searchProductList("A");
        System.out.println(productList);
    }

    //对insertProduct方法进行测试【测试无问题】
    @Test
    public void insertProduct()
    {
        Product product=new Product();
        product.setProductid("a");
        //setCategory是条件
        product.setCategory("FISH");
        product.setName("BBB111");
        product.setDescn("des11111111");
        Integer result = productService.insertProduct(product);
        System.out.println(result);
    }

    //对deleteProduct方法进行测试【测试无问题】
    @Test
    public void deleteProduct()
    {
        Integer result = productService.deleteProduct("a");
        System.out.println(result);
    }

    //对updateCategory方法进行测试【测试无问题】
    @Test
    public void updateProduct()
    {
        Product product=new Product();
        //setProductid是条件
        product.setProductid("a");
        product.setCategory("FISH");
        product.setName("BBB22222222");
        product.setDescn("des2222222222222");
        Integer result = productService.updateProduct(product);
        System.out.println(result);
    }
}
