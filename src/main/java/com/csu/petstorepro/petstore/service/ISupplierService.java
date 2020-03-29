package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.entity.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface ISupplierService extends IService<Supplier> {

    Supplier getSupplierBySupplierId(String supplierId);

    Supplier getSupplierBySupplierIdAndPassword(String supplierId,String password);

    void insertSupplier(Supplier supplier);

    void updateSupplier(Supplier supplier);
}
