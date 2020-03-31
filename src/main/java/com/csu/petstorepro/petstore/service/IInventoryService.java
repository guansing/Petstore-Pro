package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Inventory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface IInventoryService extends IService<Inventory> {
    //更新库存数量
    void updateInventoryQuantity(Inventory inventory);

    int updateQtyBySupplier(Inventory inventory);

    Inventory getQtyBySupplier(String itemid);
}
