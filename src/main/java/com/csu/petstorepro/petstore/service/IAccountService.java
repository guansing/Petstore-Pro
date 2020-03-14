package com.csu.petstorepro.petstore.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.csu.petstorepro.petstore.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface IAccountService extends IService<Account>
{
    //查找:通过账号返回个人的全部信息【买家和卖家】
    Account getAccountByUserId(String userId);
    //查找:通过账号和密码来返回account的全部信息【买家和卖家】
    int getAccountByUserIdAndPassword(Account account);
    //新增:用户注册的时候对个人基本信息的填写【买家和卖家】
    int insertAccount(Account account);
    //更新:用户登录后在个人主页中对于自己修改后信息的保存【买家和卖家】
    int updateAccount(Account account);


    //List<Account> selectByMyWrapper();

    //查找
    Account selectByUserId(String userId);


   // List<Account> selectByMyWrapper(@Param(Constants.WRAPPER) Wrapper<Account> accountWrapper);
}
