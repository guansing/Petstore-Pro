package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Product;
import com.csu.petstorepro.petstore.mapper.ProductMapper;
import com.csu.petstorepro.petstore.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}