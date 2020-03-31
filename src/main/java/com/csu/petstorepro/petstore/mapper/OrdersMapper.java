package com.csu.petstorepro.petstore.mapper;

import com.csu.petstorepro.petstore.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface OrdersMapper extends BaseMapper<Orders>
{
    //通过用户名来获取用户的订单(order)信息列表
    List<Orders> getOrdersByUserId(String userId);
    //通过某一个orderId来查找相对应的order信息
    Orders getOrderByOrderId(int orderId);
    //卖家条件查询orders
    List<Orders> getSupplierOrders(String suppid);
}
