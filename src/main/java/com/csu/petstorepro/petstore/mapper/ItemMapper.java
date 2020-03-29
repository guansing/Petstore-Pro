package com.csu.petstorepro.petstore.mapper;

import com.csu.petstorepro.petstore.entity.Item;
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
public interface ItemMapper extends BaseMapper<Item> {
    //通过productId获取item列表
    List<Item> getItemListByProduct(String productId);
    //通过具体的一个itemId来获取到某一个对应的item
    Item getItem(String itemId);

    //卖家查询他自己的item
    List<Item> getItemListBySupplierId(String supplierId);
}
