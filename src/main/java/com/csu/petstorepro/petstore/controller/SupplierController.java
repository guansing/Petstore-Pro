package com.csu.petstorepro.petstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.csu.petstorepro.petstore.common.ReturnEntity;
import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.entity.Signon;
import com.csu.petstorepro.petstore.entity.Supplier;
import com.csu.petstorepro.petstore.service.impl.SignonServiceImpl;
import com.csu.petstorepro.petstore.service.impl.SupplierServiceImpl;
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
 * @since 2020-03-10
 */
@RestController
public class SupplierController {
    @Resource
    private SupplierServiceImpl supplierService;
    @Resource
    private SignonServiceImpl signonService;
    @Resource
    private HttpServletRequest request;

    @RequestMapping(value = "/signSupplierIn",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity signSupplierIn(@RequestBody Map<String,String> map)
    {
        JSONObject data = new JSONObject();
        Supplier result = supplierService.getSupplierBySupplierIdAndPassword(map.get("suppid"),map.get("password"));
        if (result != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("supplier",result);
            data.put("result",result);
            return ReturnEntity.successResult(data);
        }
        else {
            return ReturnEntity.failedResult("卖家名或密码错误");
        }
    }

    @RequestMapping(value = "signSupplierOut",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity signSupplierOut()
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();
        session.removeAttribute("supplier");
        data.put("supplier",null);
        return ReturnEntity.successResult(data);
    }

    @RequestMapping(value = "signSupplierUp",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity signSupplierUp(@RequestBody Supplier supplier)
    {
        JSONObject data = new JSONObject();
        String username = supplier.getSuppid();

        Signon signon = signonService.checkUsername(username);

        if(signon != null)
        {
            return ReturnEntity.failedResult("卖家名已存在");
        }
        else {
            supplierService.insertSupplier(supplier);
            data.put("suppid",supplier.getSuppid());
            return ReturnEntity.successResult(data);
        }
    }

    //用来检查用户名【买家卖家通用，因为同用一个signon表】
    @RequestMapping(value = "/checkSupplierUsername",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity checkSupplierUsername(String supplierId)
    {
        Signon signon = signonService.checkUsername(supplierId);
        if (signon == null){
            return ReturnEntity.successResult(true);
        }else {
            return ReturnEntity.failedResult("用户名已存在");
        }
    }

    @RequestMapping(value = "updateSupplierInfo",method = RequestMethod.POST)
    @ResponseBody
    public ReturnEntity updateSupplierInfo(@RequestBody Supplier supplier)
    {
        JSONObject data = new JSONObject();

        HttpSession session = request.getSession();
        Supplier supplierSession=(Supplier) session.getAttribute("supplier");
        //是否登录判断
        if (supplierSession.getSuppid()==null ){
            return ReturnEntity.failedResult("请卖家登录后访问");
        }

        supplierService.updateSupplier(supplier);
        session.setAttribute("supplier",supplier);
        data.put("supplier",supplier);
        return ReturnEntity.successResult(data);

    }

    @RequestMapping(value = "getSupplierInfo",method = RequestMethod.GET)
    @ResponseBody
    public ReturnEntity getSupplierInfo(@RequestBody Supplier supplier)
    {
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();
        Supplier supplierSession=(Supplier) session.getAttribute("supplier");

        //是否登录判断
        if (supplierSession==null ){
            return ReturnEntity.failedResult("请登录后访问");
        }
        Supplier result = supplierService.getSupplierBySupplierId(supplier.getSuppid());

        data.put("supplier",result);
        return ReturnEntity.successResult(data);
    }
}
