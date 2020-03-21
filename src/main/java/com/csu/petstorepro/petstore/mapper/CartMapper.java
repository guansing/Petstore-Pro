package com.csu.petstorepro.petstore.mapper;

import com.csu.petstorepro.petstore.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface CartMapper extends BaseMapper<Cart> {
    //下述两个方法暂时不需要，先不使用
    //计算整个购物车的总金额
    public double getSubTotal(String userId);
    //对某一用户的购物车进行数量和总金额的更新 @Param("userId")是指在xml配置文件中不用指定该变量的类型
    public int updateCart(@Param("userId") String userId, @Param("itemId") String itemId, @Param("quantity") int quantity);
}
