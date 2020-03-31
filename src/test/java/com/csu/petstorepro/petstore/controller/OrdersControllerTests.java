package com.csu.petstorepro.petstore.controller;


import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.entity.Cart;
import com.csu.petstorepro.petstore.entity.Orders;
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
public class OrdersControllerTests {

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
        //建立account类
        Account account=new Account();
        account.setUserid("22");
        account.setEmail("666");
        account.setFirstname("777");
        account.setLastname("888");
        account.setStatus("OK");
        account.setAddr1("jjj2");
        account.setAddr2("lll2");
        account.setCity("Tokyo");
        account.setState("WWF");
        account.setZip("zero");
        account.setCountry("Japan");
        account.setPhone("1530080");
        //建立supplier类
        Supplier supplier = new Supplier();
        supplier.setSuppid("4");

        //分别设置两个session
        session.setAttribute("account",account); //拦截器那边会判断用户是否登录，所以这里注入一个用户
        session.setAttribute("supplier",supplier);
    }


    @Test
    public void getSupplierOrders() throws Exception
    {

        mvc.perform(MockMvcRequestBuilders.get("/getSupplierOrders?suppid=4")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }



    //测试无问题
    @Test
    public void getOrdersByUser() throws Exception
    {

        mvc.perform(MockMvcRequestBuilders.get("/getOrdersByUser?userId=22")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }



    //测试无问题
    @Test
    public void getOrdersByOrderId() throws Exception
    {

        mvc.perform(MockMvcRequestBuilders.get("/getOrdersByOrderId?orderId=1069")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void getOrderInit() throws Exception
    {
        Account account = new Account();
        account.setUserid("22");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(account);

        mvc.perform(MockMvcRequestBuilders.get("/getOrderInit")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void newOrders() throws Exception{
        Orders orders = new Orders();

        orders.setUserid("22");
        //这里没有测试Orderdate，因为是系统的时间,在OrdersService中写好了
        orders.setShipaddr1("ChangSha1");
        orders.setShipaddr2("Beijing1");
        orders.setShipcity("NewYork");
        orders.setShipstate("NYC");
        orders.setShipzip("88888");
        orders.setShipcountry("USA");
        orders.setBilladdr1("West Rode");
        orders.setBilladdr2("East Rode");
        orders.setBillcity("Tokyo");
        orders.setBillstate("JPN");
        orders.setBillzip("99999");
        orders.setBillcountry("China");
        orders.setCourier("WPS");
        //orders.setTotalprice(444.00); 不用,在OrdersService中写好了
        orders.setBilltofirstname("Li");
        orders.setBilltolastname("GX");
        orders.setShiptofirstname("Liu");
        orders.setShiptolastname("WL");
        orders.setCreditcard("77777777777");
        orders.setExprdate("03/27");
        orders.setCardtype("PayPay");
        orders.setLocale("DA");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(orders);

        mvc.perform(MockMvcRequestBuilders.post("/newOrders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }










}
