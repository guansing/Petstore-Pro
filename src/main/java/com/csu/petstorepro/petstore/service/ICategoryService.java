package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Category;
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
public interface ICategoryService extends IService<Category> {
    //用于查找Category的所有变量值的方法接口
    List<Category> getCategoryList();
}
