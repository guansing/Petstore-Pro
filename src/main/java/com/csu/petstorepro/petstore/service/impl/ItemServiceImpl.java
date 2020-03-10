package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Item;
import com.csu.petstorepro.petstore.mapper.ItemMapper;
import com.csu.petstorepro.petstore.service.IItemService;
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
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

}
