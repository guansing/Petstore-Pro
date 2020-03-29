package com.csu.petstorepro.petstore.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.csu.petstorepro.petstore.common.ReturnEntity;
import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.entity.Signon;
import com.csu.petstorepro.petstore.service.impl.AccountServiceImpl;
import com.csu.petstorepro.petstore.service.impl.SignonServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
    @Resource
    private SignonServiceImpl signonService;
    @Resource
    private HttpServletRequest request;

    @RequestMapping(value = "/signIn",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity signIn(@RequestBody Map<String,String> map)
    {
        JSONObject data = new JSONObject();
         Account result = accountService.getAccountByUserIdAndPassword(map.get("userId"),map.get("password"));
        if (result != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("account",result);
            data.put("result",result);
            return ReturnEntity.successResult(data);
        }
        else {
            return ReturnEntity.failedResult("用户名或密码错误");
        }
    }

    @RequestMapping(value = "signOut",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity signOut()
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();
        session.removeAttribute("account");
        data.put("account",null);
        return ReturnEntity.successResult(data);
    }




    //用户注册
    @RequestMapping(value = "signUp",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity signUp(@RequestBody Account account)
    {
        JSONObject data = new JSONObject();
        String username = account.getUserid();

        Signon signon = signonService.checkUsername(username);

        if(signon != null)
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
    public ReturnEntity checkUsername(String userId)
    {
        Signon signon = signonService.checkUsername(userId);
        if (signon == null){
            return ReturnEntity.successResult(true);
        }else {
            return ReturnEntity.failedResult("用户名已存在");
        }
    }

    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity updateUserInfo(@RequestBody Account account)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();
        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession==null ){
            return ReturnEntity.failedResult("请登录后访问");
          }
        accountService.updateAccount(account);
        session.setAttribute("account",account);

        data.put("account",account);

        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getUserInfo(@RequestBody Account account)
    {
        JSONObject data = new JSONObject();

        HttpSession session = request.getSession();
        Account accountSession=(Account) session.getAttribute("account");
        //是否登录判断
        if (accountSession ==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }

        Account result = accountService.getAccountByUserId(account.getUserid());


        data.put("account",result);
        return ReturnEntity.successResult(data);
    }



}
