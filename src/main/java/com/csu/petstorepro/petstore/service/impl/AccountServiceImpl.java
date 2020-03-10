package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.mapper.AccountMapper;
import com.csu.petstorepro.petstore.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
