package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Orders;
import com.csu.petstorepro.petstore.mapper.OrdersMapper;
import com.csu.petstorepro.petstore.service.IOrdersService;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
