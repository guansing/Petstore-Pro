package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lgx
 * @since 2020-03-13
 */
public interface ICartService extends IService<Cart> {
    //增一个：用户将一个商品添加到购物车中（这个商品之前从没有过）
    int insertTheItemToCart(Cart cart);
    //更新增一个：用户将一个商品增加一个到购物车中（这个商品之前有）
    int updateItemNumberInCart(Cart cart);
    //删一个：用户将某一个商品移出他的购物车
    int deleteTheItemOutCart(Cart cart);
    //全删：用于提交Order订单的时候清空刚才的购物车列表（清空购物车）
    int deleteAllItemOutCart(Cart itemId);
    //全查：查询购物车的所有信息
    List<Cart> getCartList(Cart cart);

    //列出下面这三个方法是为了提醒这三个点要在控制器或者前端实现，所以这三个方法就不实现了，只是便于提醒这三个点要考虑到

    //更新指定：修改个数的数据时可以实时将数据信息存到数据库中
    //int updateCart(Cart cart);
    //更新指定：判断某item是否在购物车中，有的话数量加一，没有就要新增item信息
    //boolean existItemInCart(Cart cart);
    //更新指定：更新计算所有金额的方法
    //BigDecimal getSubTotal(String userId);
}
