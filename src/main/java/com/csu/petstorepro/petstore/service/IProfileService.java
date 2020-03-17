package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Profile;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface IProfileService extends IService<Profile> {
    //此时的 Profile 已经在AccountMapper中集成了
}
