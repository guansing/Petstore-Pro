package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Orders;
import com.csu.petstorepro.petstore.service.impl.OrdersServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersServiceTests
{
    @Resource
    private OrdersServiceImpl ordersService;


    //测试有一些问题，大概是和主键有关
    @Test
    public void insertOrder()
    {
        //测试过程中需要Account和Cart中有数据且对应
        Orders orders = new Orders();

        orders.setUserid("22");
        //这里没有测试Orderdate，因为是系统的时间,在OrdersService中写好了
        orders.setShipaddr1("ChangSha");
        orders.setShipaddr2("Beijing");
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

        ordersService.insertOrder(orders);
    }

    //测试无问题
    @Test
    public void getOrderByOrderId(){
        //注意，输入的OrderId必须是在order和orderstatus中存在的才能查到
        Orders orders = ordersService.getOrderByOrderId(1004);
        System.out.println(orders);
    }

    //测试无问题
    @Test
    public void getOrdersByUserId(){
        List<Orders> orders = ordersService.getOrdersByUserId("j2ee");
        System.out.println(orders);

    }

    //虽然测试成功但感觉nextId的值有问题（有可能是service部分的逻辑有问题）
    @Test
    public void getNextId(){
        int nextId = ordersService.getNextId("ordernum");
        System.out.println(nextId);
    }

    //无问题
    @Test
    public void getSupplierOrders(){
        List<Orders> orders = ordersService.getSupplierOrders("4");
        System.out.println(orders);
    }
}
