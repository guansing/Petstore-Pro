package com.csu.petstorepro.petstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.entity.Profile;
import com.csu.petstorepro.petstore.entity.Signon;
import com.csu.petstorepro.petstore.mapper.AccountMapper;
import com.csu.petstorepro.petstore.mapper.ProfileMapper;
import com.csu.petstorepro.petstore.mapper.SignonMapper;
import com.csu.petstorepro.petstore.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService
{
    //引入三个Mapper
    @Resource
    private AccountMapper accountMapper;
    private SignonMapper signonMapper;
    private ProfileMapper profileMapper;


    @Override
    public Account getAccountByUserId(String userId) {
        return accountMapper.selectById("userid");
    }

    @Override
    public int getAccountByUserIdAndPassword(Account account) {
        return 0;
    }

    @Override
    public int insertAccount(Account account) {
        //方法1：使用MP默认单表的mapper，或在mapper中使用注解@Insert,@Select,@Update,优点是不用写sql语句，缺点是参数需要分别传三个表实体
//        Signon signon=new Signon();
//        signon.setUsername(account.getUserid());
//        signon.setPassword(account.getPassword());
//
//        Profile profile=new Profile();
//        profile.setUserid(account.getUserid());
//        profile.setBanneropt(account.getBanneropt());
//        profile.setFavcategory(account.getFavcategory());
//        profile.setLangpref(account.getLangpref());
//        profile.setMylistopt(account.getMylistopt());
//
//        return accountMapper.insert(account)+signonMapper.insert(signon)+profileMapper.insert(profile);
        //方法2：使用xml文件重写三个表的insert，优点是参数都是Account实体

        return accountMapper.insertSignon(account);
    }

    @Override
    public int updateAccount(Account account) {
        return 0;
    }

    @Override
    public int insertSignon(Account account) {
        return accountMapper.insertSignon(account);
    }

    @Override
    public Account selectByUserId(String userId) {
        return accountMapper.selectByUserId(userId);
    }

//    @Override
//    public List<Account> selectByMyWrapper(Wrapper<Account> accountWrapper) {
//        return accountMapper.selectByMyWrapper(accountWrapper);
//    }
}
