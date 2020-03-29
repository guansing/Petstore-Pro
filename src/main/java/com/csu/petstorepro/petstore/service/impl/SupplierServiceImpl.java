package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Supplier;
import com.csu.petstorepro.petstore.mapper.SupplierMapper;
import com.csu.petstorepro.petstore.service.ISupplierService;
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
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {

    @Resource
    private SupplierMapper supplierMapper;

    @Override
    public Supplier getSupplierBySupplierId(String supplierId) {
        return supplierMapper.getSupplierBySuppId(supplierId);
    }

    @Override
    public Supplier getSupplierBySupplierIdAndPassword(String supplierId, String password) {
        Supplier supplier = new Supplier();
        supplier.setSuppid(supplierId);
        supplier.setPassword(password);
        return supplierMapper.getSupplierBySuppIdAndPassword(supplier);
    }

    @Override
    public void insertSupplier(Supplier supplier) {
        supplierMapper.insertSupplier(supplier);
        supplierMapper.insertSignon(supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierMapper.updateSupplier(supplier);
        supplierMapper.updateSignon(supplier);
    }
}
