package com.csu.petstorepro.petstore.controller;

import com.csu.petstorepro.petstore.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTests
{
    // MockMVC 的固定写法，用于测试控制器
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    private MockHttpSession session;

    //起到一个初始化 MockMVC 的作用
    @Before
    public void setupMock()
    {
        mvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(((request, response, chain) -> {
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        })).build();
    }

    //对控制器 getProductList 方法进行测试【测试无问题】
    @Test
    public void getProductListByCategory() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/getProductListByCategory?categoryId=FISH")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器 getProductById 方法进行测试【测试无问题】
    @Test
    public void getProductById() throws Exception
    {
        Product product = new Product();
        product.setProductid("a");
        mvc.perform(MockMvcRequestBuilders.get("/getProductById?productId=a")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void searchProductList() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/searchProductList?name=A")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器 insertProduct 方法进行测试【测试无问题】
    @Test
    public void insertProduct() throws Exception
    {
        Product product = new Product();
        product.setProductid("b");
        product.setCategory("FISH");
        product.setName("BBB33333333333");
        product.setDescn("des3333333333333");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(product);

        mvc.perform(MockMvcRequestBuilders.post("/insertProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器 updateProduct 方法进行测试【测试无问题】
    @Test
    public void updateProduct() throws Exception {
        Product product = new Product();

        product.setProductid("b");
        product.setCategory("FISH");
        product.setName("BBB3333333333322222");
        product.setDescn("des333333333333322222");


        //将类对象中的值转换为json
        ObjectMapper mapper = new ObjectMapper();
        String json =mapper.writeValueAsString(product);
        //修改url测试
        mvc.perform(MockMvcRequestBuilders.post("/updateProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器 deleteProduct 方法进行测试【测试无问题】
    @Test
    public void deleteProduct() throws Exception {
        Product product = new Product();
        product.setProductid("b");
        //将类对象中的值转换为json
        ObjectMapper mapper = new ObjectMapper();
        String json =mapper.writeValueAsString(product);
        //修改url测试
        mvc.perform(MockMvcRequestBuilders.post("/deleteProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
