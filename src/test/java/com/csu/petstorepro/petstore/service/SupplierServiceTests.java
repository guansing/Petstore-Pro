package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.entity.Supplier;
import com.csu.petstorepro.petstore.service.impl.SupplierServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierServiceTests
{
    @Resource
    private SupplierServiceImpl supplierService;

    @Test
    public void getSupplierBySupplierId(){
        Supplier supplier = supplierService.getSupplierBySupplierId("1");
        System.out.println(supplier);
    }

    @Test
    public void getSupplierBySupplierIdAndPassword(){
        Supplier result = supplierService.getSupplierBySupplierIdAndPassword("1","123456");
        System.out.println(result);
    }

    @Test
    public void insertSupplier(){
        Supplier supplier = new Supplier();
        supplier.setSuppid("4");
        supplier.setName("9");
        supplier.setStatus("t");
        supplier.setAddr1("Rode1");
        supplier.setAddr2("Rode2");
        supplier.setCity("Beijing");
        supplier.setState("Yes");
        supplier.setZip("yyy");
        supplier.setPhone("1330489");

        supplier.setPassword("1234");
        supplierService.insertSupplier(supplier);
    }


    @Test
    public void updateSupplier(){
        Supplier supplier = new Supplier();
        supplier.setSuppid("4");
        supplier.setName("92");
        supplier.setStatus("t2");
        supplier.setAddr1("Rode12");
        supplier.setAddr2("Rode22");
        supplier.setCity("Beijing2");
        supplier.setState("Yes2");
        supplier.setZip("yyy2");
        supplier.setPhone("13304892");

        supplier.setPassword("12342");
        supplierService.updateSupplier(supplier);
    }

}
