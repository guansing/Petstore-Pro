package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Profile;
import com.csu.petstorepro.petstore.mapper.ProfileMapper;
import com.csu.petstorepro.petstore.service.IProfileService;
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
public class ProfileServiceImpl extends ServiceImpl<ProfileMapper, Profile> implements IProfileService {

}
