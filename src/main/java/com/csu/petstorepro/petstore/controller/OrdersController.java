package com.csu.petstorepro.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.csu.petstorepro.petstore.common.GetIp;
import com.csu.petstorepro.petstore.common.ReturnEntity;
import com.csu.petstorepro.petstore.entity.*;
import com.csu.petstorepro.petstore.service.impl.AccountServiceImpl;
import com.csu.petstorepro.petstore.service.impl.CartServiceImpl;
import com.csu.petstorepro.petstore.service.impl.OrdersServiceImpl;
import com.csu.petstorepro.petstore.service.impl.SyslogServiceImpl;
import org.apache.catalina.Session;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
public class OrdersController {
    @Resource
    OrdersServiceImpl ordersService;
    @Resource
    CartServiceImpl cartService;
    @Resource
    AccountServiceImpl accountService;
    @Resource
    private HttpServletRequest request;
    @Resource
    private SyslogServiceImpl syslogService;

    @RequestMapping(value = "/newOrders",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity newOrders(@RequestBody Orders orders) throws Exception
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");
        cartService.getCartList(accountSession.getUserid());

        if(orders.getShiptofirstname() == null){
            orders.setShiptofirstname(orders.getBilltofirstname());
            orders.setShiptolastname(orders.getBilltolastname());
            orders.setShipaddr1(orders.getBilladdr1());
            orders.setShipaddr2(orders.getBilladdr2());
            orders.setShipcity(orders.getBillcity());
            orders.setShipstate(orders.getBillstate());
            orders.setShipzip(orders.getBillzip());
            orders.setShipcountry(orders.getBillcountry());
        }
        ordersService.insertOrder(orders);
        cartService.deleteAllItemOutCart(accountSession.getUserid());

        //日志功能
        Syslog syslog = new Syslog(accountSession.getUserid(),"新增订单，总金额为 $" + orders.getTotalprice(),"newOrders","orders",new Date(),new GetIp().getIp());
        syslogService.insertSyslog(syslog);

        data.put("orders",orders);
        return ReturnEntity.successResult(data);
    }



    @RequestMapping(value = "/getOrdersByUser",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getOrdersByUser(String userId)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }else {
            List<Orders> result = ordersService.getOrdersByUserId(userId);
            data.put("result",result);
            return ReturnEntity.successResult(data);
        }
    }


    @RequestMapping(value = "/getOrdersByOrderId",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getOrdersByOrderId(int orderId)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }else {
                Orders orders = ordersService.getOrderByOrderId(orderId);
                if (orders==null){
                    return ReturnEntity.failedResult("用户无法访问");
                }
                data.put("result",orders);
                return ReturnEntity.successResult(data);
        }
    }



    //在打开创建新订单界面的时候开始执行初始化操作
    @RequestMapping(value = "/getOrderInit",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getOrderInit(){
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account == null){
            return ReturnEntity.failedResult("请登录后访问");
        }

        Orders orders = new Orders();
        Orders result = orders.initOrder(account);
        data.put("result",result);
        return ReturnEntity.successResult(data);
    }




    @RequestMapping(value = "/getSupplierOrders",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getSupplierOrders(String suppid)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Supplier supplierSession=(Supplier) session.getAttribute("supplier");
        //是否登录判断
        if (supplierSession==null ){
            return ReturnEntity.failedResult("请卖家登录后访问");
        }else {
            List<Orders> result = ordersService.getSupplierOrders(suppid);
            data.put("result",result);
            return ReturnEntity.successResult(data);
        }
    }

}
