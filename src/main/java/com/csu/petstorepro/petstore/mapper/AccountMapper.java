package com.csu.petstorepro.petstore.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.csu.petstorepro.petstore.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lgx
 * @since 2020-03-14
 */
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * 如果自定义的方法还希望能够使用MP提供的Wrapper条件构造器，则需要如下写法
     */
    //方法一
    //@Select("SELECT a.*,b.*,c.* FROM account a,signon b,profile c ${ew.customSqlSegment}")
    //@Select("SELECT account.*,profile.* FROM account,profile  ${ew.customSqlSegment}")
    //List<Account> selectByMyWrapper(@Param(Constants.WRAPPER) Wrapper<Account> accountWrapper);

    //方法二
    //自己定义sql
    //@Select("SELECT a.*,b.*,c.* FROM account a,signon b,profile c where a.userid=b.username and a.userid=c.userid and a.userid = #{userid}")
    //List<Account> selectByUserId(@Param("userid") String userid);

    Account getAccountByUserId(String userId);
    Account getAccountByUserIdAndPassword(Account account);


    //新增(分别是account,profile和signon表的方法)
    void insertAccount(Account account);
    void insertProfile(Account account);
    void insertSignon(Account account);

    //更新(分别是account,profile和signon表的方法)
    void updateAccount(Account account);
    void updateProfile(Account account);
    void updateSignon(Account account);
}
