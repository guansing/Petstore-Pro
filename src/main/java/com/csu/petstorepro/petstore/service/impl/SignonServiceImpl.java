package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Signon;
import com.csu.petstorepro.petstore.mapper.SignonMapper;
import com.csu.petstorepro.petstore.service.ISignonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
@Service
public class SignonServiceImpl extends ServiceImpl<SignonMapper, Signon> implements ISignonService {

    @Resource
    private SignonMapper signonMapper;

    @Override
    public Signon checkUsername(String username) {
        return signonMapper.selectById(username);
    }
}
