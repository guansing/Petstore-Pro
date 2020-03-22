package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTests {
    @Resource
    private AccountServiceImpl accountService;

    @Test
    public void getAccountByUserId(){
        Account account = accountService.getAccountByUserId("j2ee");
        System.out.println(account);
    }

    @Test
    public void getAccountByUserIdAndPassword(){
        Account account = new Account();
        account.setUserid("222");
        account.setPassword("2223334");
        Account result = accountService.getAccountByUserIdAndPassword(account.getUserid(),account.getPassword());
        System.out.println(result);
    }

    @Test
    public void insertAccount(){
        Account account = new Account();
        account.setUserid("222");
        account.setEmail("222");
        account.setFirstname("22");
        account.setLastname("33");
        account.setStatus("OK");
        account.setAddr1("22");
        account.setAddr2("33");
        account.setCity("NYC");
        account.setState("NC");
        account.setZip("fff");
        account.setCountry("china");
        account.setPhone("1330582");

        account.setPassword("222333");

        account.setLangpref("Eng");
        account.setFavcategory("cat");
        account.setMylistopt(1);
        account.setBanneropt(1);

        accountService.insertAccount(account);
    }

    @Test
    public void updateAccount(){
        Account account = new Account();
        //id是不能改变的
        account.setUserid("222");
        account.setEmail("222");
        account.setFirstname("2233");
        account.setLastname("3333");
        account.setStatus("OK");
        account.setAddr1("223");
        account.setAddr2("333");
        account.setCity("NYC3");
        account.setState("NC3");
        account.setZip("fff3");
        account.setCountry("china3");
        account.setPhone("10000");

        account.setPassword("2223334");

        account.setLangpref("Eng3");
        account.setFavcategory("cat3");
        account.setMylistopt(2);
        account.setBanneropt(2);

        accountService.updateAccount(account);
    }

}
