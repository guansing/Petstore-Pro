package com.csu.petstorepro.petstore.controller;

import com.csu.petstorepro.petstore.entity.Item;
import com.csu.petstorepro.petstore.entity.Supplier;
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
public class ItemControllerTests
{
    // MockMVC 的固定写法，用于测试控制器
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void setupMock()
    {
        mvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(((request, response, chain) -> {
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        })).build();
        session = new MockHttpSession();
        Supplier supplier = new Supplier();
        supplier.setSuppid("4");
        session.setAttribute("supplier",supplier);
    }

    //对控制器 getItemList 方法进行测试【测试无问题】
    @Test
    public void getItemListByProduct() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/getItemListByProduct?productId=RP-SN-01")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器 getItemById 方法进行测试【测试无问题】
    @Test
    public void getItemById() throws Exception
    {
        Item item = new Item();
        item.setItemid("Aaa-a");
        mvc.perform(MockMvcRequestBuilders.get("/getItemById?itemId=Aaa-a")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器 insertProduct 方法进行测试【测试无问题】
    @Test
    public void insertProduct() throws Exception
    {
        Item item = new Item();

        item.setItemid("Bbb-b311");
        item.setProductid("FL-DLH-02");
        item.setListprice(1.0);
        item.setUnitcost(1.0);
        item.setSupplier("1");
        item.setStatus("S3");
        item.setAttr1("test13");
        item.setAttr2("test23");
        item.setAttr3("test33");
        item.setAttr4("test43");
        item.setAttr5("test53");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(item);

        mvc.perform(MockMvcRequestBuilders.post("/insertItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器 updateItem 方法进行测试【测试无问题】
    @Test
    public void updateItem() throws Exception {
        Item item = new Item();

        item.setItemid("aa");
        item.setProductid("FL-DLH-02");
        item.setListprice(12.0);
        item.setUnitcost(12.0);
        item.setSupplier("2");
        item.setStatus("T2");
        item.setAttr1("test132");
        item.setAttr2("test232");
        item.setAttr3("test332");
        item.setAttr4("test432");
        item.setAttr5("test532");

        ObjectMapper mapper = new ObjectMapper();
        String json =mapper.writeValueAsString(item);
        //修改url测试
        mvc.perform(MockMvcRequestBuilders.post("/updateItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器 deleteItem 方法进行测试【测试无问题】
    @Test
    public void deleteItem() throws Exception {
        Item item = new Item();
        item.setItemid("Bbb-b311");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(item);
        //String json="{\"itemId\":\"Bbb-b311\"}";
        //修改url测试
        mvc.perform(MockMvcRequestBuilders.post("/deleteItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getItemListBySupplierId() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/getItemListBySupplierId?supplierId=2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}