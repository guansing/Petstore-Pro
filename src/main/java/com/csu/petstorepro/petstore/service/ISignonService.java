package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Signon;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface ISignonService extends IService<Signon> {
    Signon checkUsername(String username);
}
