package com.csu.petstorepro.petstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csu.petstorepro.petstore.entity.Category;
import com.csu.petstorepro.petstore.mapper.CategoryMapper;
import com.csu.petstorepro.petstore.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //用于查找Category的所有变量值的方法接口实现
    @Override
    public List<Category> getCategoryList(){
        //返回一个mapper映射
        return categoryMapper.selectList(null);
    }

    //通过id来查询Category的方法接口的实现
    @Override
    public Category getCategoryById(String categoryId)
    {
        return categoryMapper.selectById(categoryId);
    }

    //【卖家部分】对Category类别进行增加操作
    @Override
    public int insertCategory(Category category)
    {
        return categoryMapper.insert(category);
    }

    @Override
    public int deleteCategory(String categoryId)
    {
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("catid",categoryId);
        return categoryMapper.deleteByMap(columnMap);
    }

    @Override
    public int updateCategory(Category category)
    {
        //此方法修改category下面的所有有数据的列
       return categoryMapper.update(category, new QueryWrapper<Category>()
                        .eq("catid",category.getCatid()));


            //方法1：适合单主键情况
            //return categoryMapper.updateById(category);

            //方法2：适合多主键情况，但update的时候主键会被重复更新一次，但不影响结果
            //Map<String,Object> columnMap = new HashMap<>();
            //columnMap.put("catid",category.getCatid());
            //columnMap.put("name",category.getName());
            //return categoryMapper.update(columnMap)

            //方法3：适合多主键情况,update的时候不会重复更新主键列
            //Category category1=new Category();
            //BeanUtils.copyProperties(category, category1);
            //category1.setCatid(null);
            //category1.setName(null);
            //return categoryMapper.update(category1,
            //       new QueryWrapper<Category>()
            //                .eq("catid",category.getCatid())
            //                .eq("name",category.getName())
            // );
            //}

    }
}
