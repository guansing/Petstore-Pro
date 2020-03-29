package com.csu.petstorepro.petstore.mapper;

import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.entity.Supplier;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface SupplierMapper extends BaseMapper<Supplier> {
    //查询
    Supplier getSupplierBySuppId(String suppId);
    Supplier getSupplierBySuppIdAndPassword(Supplier supplier);

    //新增(分别是 supplier和signon表的方法)
    void insertSupplier(Supplier supplier);
    void insertSignon(Supplier supplier);

    //更新(分别是 supplier和signon表的方法)
    void updateSupplier(Supplier supplier);
    void updateSignon(Supplier supplier);
}
