package com.csu.petstorepro.petstore.controller;

import com.csu.petstorepro.petstore.entity.Account;
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

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierControllerTests {
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
        supplier.setSuppid("1");
        session.setAttribute("supplier",supplier);
    }

    @Test
    public void signSupplierIn() throws Exception
    {
        Map<String,String> map=new HashMap<>();
        map.put("suppid","1");
        map.put("password","123456");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);

        mvc.perform(MockMvcRequestBuilders.post("/signSupplierIn")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void signSupplierOut() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.post("/signSupplierOut")
                .contentType(MediaType.APPLICATION_JSON)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void signSupplierUp() throws Exception{
        Supplier supplier = new Supplier();

        supplier.setSuppid("5");
        supplier.setName("51");
        supplier.setStatus("11");
        supplier.setAddr1("21");
        supplier.setAddr2("31");
        supplier.setCity("41");
        supplier.setState("yes1");
        supplier.setZip("71");
        supplier.setPhone("81");

        supplier.setPassword("91");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(supplier);

        mvc.perform(MockMvcRequestBuilders.post("/signSupplierUp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void checkSupplierUsername() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/checkSupplierUsername?supplierId=1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateSupplierInfo() throws Exception{
        Supplier supplier = new Supplier();

        supplier.setSuppid("5");
        supplier.setName("512");
        supplier.setStatus("2");
        supplier.setAddr1("212");
        supplier.setAddr2("312");
        supplier.setCity("412");
        supplier.setState("yes12");
        supplier.setZip("712");
        supplier.setPhone("812");

        supplier.setPassword("912");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(supplier);

        mvc.perform(MockMvcRequestBuilders.post("/updateSupplierInfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getSupplierInfo() throws Exception
    {
        Supplier supplier = new Supplier();
        supplier.setSuppid("5");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(supplier);
        mvc.perform(MockMvcRequestBuilders.get("/getSupplierInfo")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
