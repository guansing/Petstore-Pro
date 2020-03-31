package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.csu.petstorepro.petstore.entity.Sequence;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface IOrdersService extends IService<Orders> {
    //新增订单
    void insertOrder(Orders order);
    List<Orders> getOrdersByUserId(String userId);
    Orders getOrderByOrderId(int orderId);
    //获取序列表sequence中新的id序列值
    int getNextId(String name);
    //卖家条件查询orders
    List<Orders> getSupplierOrders(String suppid);
}
