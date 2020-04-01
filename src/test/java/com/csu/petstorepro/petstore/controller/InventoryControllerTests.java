package com.csu.petstorepro.petstore.controller;

import com.csu.petstorepro.petstore.entity.Inventory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryControllerTests {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    //起到一个初始化 MockMVC 的作用
    @Before
    public void setupMock()
    {
        mvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(((request, response, chain) -> {
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        })).build();
    }

    //【测试无问题】
    @Test
    public void getQtyBySupplier() throws Exception
    {
        Inventory inventory = new Inventory();
        inventory.setItemid("EST-25");

        mvc.perform(MockMvcRequestBuilders.get("/getQtyBySupplier?itemid=EST-25")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //【测试无问题】
    @Test
    public void updateQtyBySupplier() throws Exception {
        Inventory inventory = new Inventory();
        inventory.setItemid("EST-25");
        inventory.setQty(200);
        //将类对象中的值转换为json
        ObjectMapper mapper = new ObjectMapper();
        String json =mapper.writeValueAsString(inventory);
        //修改url测试
        mvc.perform(MockMvcRequestBuilders.post("/updateQtyBySupplier")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
