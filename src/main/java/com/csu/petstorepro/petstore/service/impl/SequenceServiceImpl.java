package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Orders;
import com.csu.petstorepro.petstore.entity.Sequence;
import com.csu.petstorepro.petstore.mapper.SequenceMapper;
import com.csu.petstorepro.petstore.service.ISequenceService;
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
public class SequenceServiceImpl extends ServiceImpl<SequenceMapper, Sequence> implements ISequenceService {

}
