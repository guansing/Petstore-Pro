package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Cart;
import com.csu.petstorepro.petstore.mapper.CartMapper;
import com.csu.petstorepro.petstore.service.ICartService;
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
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

}
