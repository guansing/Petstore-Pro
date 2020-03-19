package com.csu.petstorepro.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.csu.petstorepro.petstore.common.ReturnEntity;
import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.entity.Cart;
import com.csu.petstorepro.petstore.service.impl.*;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/petstore/cart")
public class CartController {
    @Resource
    CartServiceImpl cartService;
    @Resource
    CategoryServiceImpl categoryService;
    @Resource
    ProductServiceImpl productService;
    @Resource
    ItemServiceImpl itemService;
    @Resource
    AccountServiceImpl accountService;

    @RequestMapping(value = "/getCart",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getCart(Cart cart, HttpServletRequest request)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession.getUserid()==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }else {
            cartService.getCartList(cart);
            data.put("cart",cart);
            return ReturnEntity.successResult(data);
        }
    }


    @RequestMapping(value = "/deleteCart",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity deleteCart(Cart cart,HttpServletRequest request)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession.getUserid()==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }else {
            cartService.deleteTheItemOutCart(cart);
            data.put("cart",cart);
            return ReturnEntity.successResult(data);
        }
    }


    @RequestMapping(value = "/insertTheItemToCart",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity insertTheItemToCart(Cart cart,HttpServletRequest request)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession.getUserid()==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }else {
            cartService.insertTheItemToCart(cart);
            data.put("cart",cart);
            return ReturnEntity.successResult(data);
        }
    }


    @RequestMapping(value = "/updateCart",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity updateCart(Cart cart,HttpServletRequest request){
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession.getUserid()==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }else {
            cartService.updateItemNumberInCart(cart);
            data.put("cart",cart);
            return ReturnEntity.successResult(data);
        }

    }










}
