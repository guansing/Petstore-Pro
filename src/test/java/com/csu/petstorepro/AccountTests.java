package com.csu.petstorepro;

import com.baomidou.mybatisplus.annotation.TableField;
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

    @Test
    public void getAccountByUserId()
    {
        System.out.println(accountMapper.getAccountByUserId("j2ee"));
    }

    @Test
    public void getAccountByUserIdAndPassword()
    {
        //Account account = accountMapper.getAccountByUserIdAndPassword("j2ee","j2ee");
        Account account = new Account();
        account.setUserid("j2ee");
        account.setPassword("j2ee");
        Account account1 = accountMapper.getAccountByUserIdAndPassword(account);
        System.out.println(account1);
    }

    @Test
    public void insertAccount()
    {
        Account account = new Account();
        account.setUserid("setUserid");
        account.setEmail("setEmail");
        account.setFirstname("setFirstname");
        account.setLastname("setLastname");
        account.setStatus("ok");
        account.setAddr1("setAddr1");
        account.setAddr2("setAddr2");
        account.setCity("setCity");
        account.setState("setState");
        account.setZip("setZip");
        account.setCountry("setCountry");
        account.setPhone("setPhone");

        account.setPassword("setPassword");

        account.setLangpref("setLangpref");
        account.setFavcategory("setFavcategory");
        account.setMylistopt(1);
        account.setBanneropt(2);

        accountMapper.insertAccount(account);
        accountMapper.insertProfile(account);
        accountMapper.insertSignon(account);
    }

    @Test
    public void updateAccount()
    {
        Account account = new Account();
        account.setUserid("setUserid");
        account.setEmail("setEmail2");
        account.setFirstname("setFirstname2");
        account.setLastname("setLastname2");
        account.setStatus("no");
        account.setAddr1("setAddr12");
        account.setAddr2("setAddr22");
        account.setCity("setCity2");
        account.setState("setState2");
        account.setZip("setZip2");
        account.setCountry("setCountry2");
        account.setPhone("setPhone2");

        account.setPassword("setPassword2");

        account.setLangpref("setLangpref2");
        account.setFavcategory("setFavcategory2");
        account.setMylistopt(12);
        account.setBanneropt(22);

        accountMapper.updateAccount(account);
        accountMapper.updateProfile(account);
        accountMapper.updateSignon(account);
    }



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

//    @Test
//    public void AccountSelectByUserIdTest()
//    {
//        Account accounts = accountMapper.getAccountByUserId("j2ee");
//        System.out.println(accounts);
//    }
//
//    @Test
//    public void insertAccountTest()
//    {
//        Account account=new Account();
//        account.setUserid("aaaa");
//        account.setPassword("123456");
//
//       int result = accountMapper.insertSignon(account);
//        System.out.println(result);
//    }

}
