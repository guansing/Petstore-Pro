package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Category;
import com.csu.petstorepro.petstore.mapper.CategoryMapper;
import com.csu.petstorepro.petstore.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
//Service注解，用于表示
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryList(){
        //返回一个mapper映射
        return categoryMapper.selectList(null);
    }
}
