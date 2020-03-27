package com.csu.petstorepro.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.csu.petstorepro.petstore.common.ReturnEntity;
import com.csu.petstorepro.petstore.entity.Cart;
import com.csu.petstorepro.petstore.entity.Orders;
import com.csu.petstorepro.petstore.service.impl.AccountServiceImpl;
import com.csu.petstorepro.petstore.service.impl.CartServiceImpl;
import com.csu.petstorepro.petstore.service.impl.OrdersServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/insertTheItemToCart",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity newOrder(@RequestBody Orders orders){
        JSONObject data = new JSONObject();
//
//        String username = accountService.getAccountByUserId(data)
//
//
//        HttpSession session = request.getSession();
//        ordersService.insertOrder(orders);
//        cartService.deleteAllItemOutCart(username)
        return ReturnEntity.successResult(data);

    }


}
