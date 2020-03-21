package com.csu.petstorepro.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.csu.petstorepro.petstore.common.ReturnEntity;
import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.entity.Cart;
import com.csu.petstorepro.petstore.entity.Item;
import com.csu.petstorepro.petstore.service.impl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
@RestController
//@RequestMapping("/petstore/cart")
public class CartController {
    @Resource
    CartServiceImpl cartService;
    @Resource
    CategoryServiceImpl categoryService;
    @Resource
    ProductServiceImpl productService;

    @Resource
    private HttpServletRequest request;

    /**
     * itemService的引入主要是cart中需要用到这里面的一些方法：
     * boolean isItemInStock(String itemId); 来判断购物车中是够还有item商品，如果没有就插入
     */

    @Resource
    ItemServiceImpl itemService;
    @Resource
    AccountServiceImpl accountService;

    @RequestMapping(value = "/getCartList",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getCartList(String userId)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }else {
            List<Cart> result = cartService.getCartList(userId);
            data.put("result",result);
            return ReturnEntity.successResult(data);
        }
    }

    @RequestMapping(value = "/deleteTheItemOutCart",method = RequestMethod.POST)
    @ResponseBody
    //多参数需要使用map
    public ReturnEntity deleteTheItemOutCart(@RequestBody Map<String,String> map)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }else {
            int result = cartService.deleteTheItemOutCart(map.get("userid"), map.get("itemid"));
            List<Cart> cartList = cartService.getCartList(map.get("userid"));
            data.put("result",result);
            data.put("cartList",cartList);
            return ReturnEntity.successResult(data);
        }
    }

    @RequestMapping(value = "/insertTheItemToCart",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity insertTheItemToCart(@RequestBody Cart cart)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }else {
            //新增购物车，判断是否有库存在service中实现
            String result = cartService.insertTheItemToCart(cart);
            List<Cart> cartList = cartService.getCartList(cart.getUserid());
            data.put("result",result);
            data.put("cartList",cartList);
            return ReturnEntity.successResult(data);
        }
    }

    /**
     * 最开始定义JSON
     * 首先通过session验证用户身份，通过用户名来返回购物车中的item
     * 然后判断购物车中是否已经含有itemId为xxx的item商品，如果没有就先判断库存中有没有商品的存量（库存inventory可以被卖家所修改）
     * 如果库存存量不够，那么新增商品无效，如果有库存，那么新增商品
     * 如果购物车原来就含有itemId为xxx的item商品，那么该item的数量增加
     * 新增后调用计算总金额的方法
     * 最后返回json数据
     */
    @RequestMapping(value = "/updateCart",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity updateCart(@RequestBody Cart cart)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();

        Account accountSession=(Account) session.getAttribute("account");

        //是否登录判断
        if (accountSession==null ) {
            return ReturnEntity.failedResult("请登录后访问");
        }
        else {
            String result ;
            int quantity = cart.getQuantity();
            //判断当数量小于1的时候，若是，则执行删除的方法
            if(quantity < 1){
                result = String.valueOf(cartService.deleteTheItemOutCart(cart.getUserid(),cart.getItemid()));
            }else {
                //若数量大于1，数据库中若有则数量更新；若无则新增cart
                Cart cartItem = cartService.getCartItem(cart.getUserid(),cart.getItemid());
                if (cartItem == null){
                    result = cartService.insertTheItemToCart(cart);
                }else {
                    result = String.valueOf(cartService.updateItemNumberInCart(cart));
                }
            }
            data.put("result",result);
            return ReturnEntity.successResult(data);
        }
    }
}
