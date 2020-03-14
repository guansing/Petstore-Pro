package com.csu.petstorepro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.mapper.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AccountTests
{
    @Resource
    private AccountMapper accountMapper;


//    @Test
//    public void AccountFindTest()
//    {
//        List<Account> accounts = accountMapper.selectByUserId("j2ee");
//        System.out.println(accounts);
//    }

//    @Test
//    public void selectByMyWrapperTests()
//    {
//        QueryWrapper<Account> wrapper = new QueryWrapper<>();
//        wrapper.eq("account.userid","j2ee").eq("account.userid","profile.userid");
//        //wrapper.eq("a.userid","b.username").eq("a.userid","c.userid").eq("a.userid","j2ee");
//        List<Account> accounts = accountMapper.selectByMyWrapper(wrapper);
//        System.out.println(accounts);
//    }

    @Test
    public void AccountSelectByUserIdTest()
    {
        Account accounts = accountMapper.selectByUserId("j2ee");
        System.out.println(accounts);
    }

    @Test
    public void insertAccountTest()
    {
        Account account=new Account();
        account.setUserid("aaaa");
        account.setPassword("123456");

       int result = accountMapper.insertSignon(account);
        System.out.println(result);
    }

}
