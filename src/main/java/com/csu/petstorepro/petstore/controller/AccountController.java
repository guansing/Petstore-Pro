package com.csu.petstorepro.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.csu.petstorepro.petstore.common.ReturnEntity;
import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.service.impl.AccountServiceImpl;
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
 * @since 2020-03-18
 */
@RestController
public class AccountController
{
    @Resource
    private AccountServiceImpl accountService;

    @RequestMapping(value = "/signIn",method = RequestMethod.POST)
    @ResponseBody
    public Account signIn(@RequestBody Account account,HttpServletRequest request)
    {
         Account ac;
         ac = accountService.getAccountByUserIdAndPassword(account);

        if (ac.getUserid() != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("account",ac);
            return ac;
        }
        else {
            return null;
        }
    }

    @RequestMapping(value = "signOut",method = RequestMethod.DELETE)
    @ResponseBody
    public String signOut(@RequestBody Account account,HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.removeAttribute("account");
        return "success";
    }

    //用户注册
    @RequestMapping(value = "signUp",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity signUp(@RequestBody Account account)
    {
        JSONObject data = new JSONObject();
        String username = account.getUserid();

        Account dbAccount = accountService.getAccountByUserId(username);

        if(dbAccount != null)
        {
            return ReturnEntity.failedResult("用户名已存在");
        }
        else {
            accountService.insertAccount(account);
            data.put("userid",account.getUserid());
            return ReturnEntity.successResult(data);
        }
    }


    //用来检查用户名
    @RequestMapping(value = "/checkUsername",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity checkUsername(Account account,HttpServletRequest request) {
        if (request.getParameter("username")!= null) {
            if (accountService.getAccountByUserId(request.getParameter("username")) != null) {
                return ReturnEntity.failedResult("Error");
            }
            return ReturnEntity.successResult(account);
        }else
            return ReturnEntity.failedResult("没有用户名");
    }

    //没有session，写得有问题
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity updateUserInfo(@RequestBody Account account,HttpServletRequest request)
    {
        JSONObject data = new JSONObject();
        Account ac;
        HttpSession session = request.getSession();
        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession.getUserid()==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }
        //判断用户的userid是否已经存在
        ac = accountService.getAccountByUserIdAndPassword(account);
        if (ac.getUserid() == null)
        {
            return ReturnEntity.failedResult("当前用户已存在");

        }
        else {
            accountService.updateAccount(account);
            data.put("account",account);
            return ReturnEntity.successResult(data);
        }
    }

    //没有session，写得有问题
    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getUserInfo(@RequestBody Account account,HttpServletRequest request)
    {
        JSONObject data = new JSONObject();
        Account ac;
        HttpSession session = request.getSession();
        Account accountSession=(Account) session.getAttribute("account");
        ac = accountService.getAccountByUserIdAndPassword(account);

        //是否登录判断
        if (accountSession.getUserid()==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }

        if (ac.getUserid() != null)
        {
            accountService.getAccountByUserIdAndPassword(account);
            data.put("account",account);
            return ReturnEntity.successResult(data);
        }
        else {
            return ReturnEntity.failedResult("Error");
        }
    }



}
