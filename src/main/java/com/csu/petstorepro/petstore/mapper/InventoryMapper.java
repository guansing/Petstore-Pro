package com.csu.petstorepro.petstore.mapper;

import com.csu.petstorepro.petstore.entity.Inventory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface InventoryMapper extends BaseMapper<Inventory> {
    //更新库存数量
    void updateInventoryQuantity(Inventory inventory);
    //获取库存数量(通过某一个具体的item的ID可以知道)
//    int getInventoryQuantity(String itemId); 本身就是一个常规的select
}
