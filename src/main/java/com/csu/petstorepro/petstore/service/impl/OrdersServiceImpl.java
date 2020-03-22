package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Cart;
import com.csu.petstorepro.petstore.entity.Lineitem;
import com.csu.petstorepro.petstore.entity.Orders;
import com.csu.petstorepro.petstore.entity.Sequence;
import com.csu.petstorepro.petstore.mapper.CartMapper;
import com.csu.petstorepro.petstore.mapper.LineitemMapper;
import com.csu.petstorepro.petstore.mapper.OrdersMapper;
import com.csu.petstorepro.petstore.mapper.SequenceMapper;
import com.csu.petstorepro.petstore.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private CartMapper cartMapper;
    @Resource
    private SequenceMapper sequenceMapper;
    @Resource
    private CartServiceImpl cartService;
    @Resource
    private LineitemMapper line;

    @Override
    public int insertOrder(Orders order)
    {
        int orderId = getNextId("ordernum");
        order.setOrderid(orderId);
        order.setTotalprice(cartMapper.getSubTotal(order.getUserid()));
        List<Cart> cartList = cartService.getCartList(order.getUserid());
        List<Lineitem> lineitemList = new ArrayList<>();

        for (int i = 0;i < cartList.size();i++) {
            Lineitem lineitem = new Lineitem();
            lineitem.setOrderid(orderId);
            lineitem.setLinenum(i);
            lineitem.setItemid(cartList.get(i).getItemid());
            lineitem.setQuantity(cartList.get(i).getQuantity());
            //lineitem.setUnitprice(cartList.get(i).getListprice());
            lineitemList.add(lineitem);
            line.insert(lineitem);

            //更新库存数量

        }
        ordersMapper.insert(order);
        //insertOrderStatus 方法
        cartService.deleteAllItemOutCart(order.getUserid());
        return orderId; //这个返回值？？？
    }

    @Override
    public Orders getOrderByOrderId(String orderId) {
        return ordersMapper.selectById(orderId);
    }

    @Override
    public List<Orders> getOrdersByUserId(String userId) {
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("userid",userId);
        return ordersMapper.selectByMap(columnMap);
    }

    @Override
    public int getNextId(String name) {
        Sequence sequence = sequenceMapper.selectById(name);
        if (sequence == null){
            Sequence insertSequence = new Sequence();
            insertSequence.setName(name);
            insertSequence.setNextid(1);
            sequenceMapper.insert(insertSequence);
            return 1;
        }else {
            Sequence updateSequence = new Sequence();
            updateSequence.setName(name);
            int nextId = sequence.getNextid()+1;
            updateSequence.setNextid(nextId);
            sequenceMapper.updateById(updateSequence);
            return nextId;
        }
    }

    @Override
    public int insertOrderStatus(Orders orders) {
        return 0;
    }
}
