package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Category;
import com.csu.petstorepro.petstore.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface IProductService extends IService<Product>
{
    //用于查找Product的所有变量值的方法接口
    List<Product> getProductListByCategory(String categoryId);
    //通过id来查询Product的方法接口
    Product getProductById(String productId);
    //模糊查询Product
    List<Product> searchProductList(String name);
    //【卖家部分】对Product类别进行增加操作的方法接口
    int insertProduct(Product product);
    //【卖家部分】对Product类别进行删除操作的方法接口
    int deleteProduct(String productId);
    //【卖家部分】对Product类别进行修改操作的方法接口
    int updateProduct(Product product);
}
