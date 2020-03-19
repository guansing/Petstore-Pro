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
    int insertTheItemToCart(Cart cart);
    int updateItemNumberInCart(Cart cart);
    int deleteTheItemOutCart(Cart cart);
    //这个方法是在提交订单的时候进行的
    int deleteAllItemOutCart(Cart cart);
    List<Cart> getCartList(Cart cart);

}
