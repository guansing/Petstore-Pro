package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Inventory;
import com.csu.petstorepro.petstore.mapper.InventoryMapper;
import com.csu.petstorepro.petstore.service.IInventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements IInventoryService {

    @Resource
    private InventoryMapper inventoryMapper;

    @Override
    public void updateInventoryQuantity(Inventory inventory) {
        inventoryMapper.updateInventoryQuantity(inventory);
    }

    @Override
    public int updateQtyBySupplier(Inventory inventory) {
        return inventoryMapper.updateById(inventory);
    }

    @Override
    public Inventory getQtyBySupplier(String itemid) {
        return inventoryMapper.selectById(itemid);
    }

}
