package com.csu.petstorepro.petstore.service;

import com.csu.petstorepro.petstore.entity.Syslog;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.annotation.Resource;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface ISyslogService extends IService<Syslog> {
    void insertSyslog(Syslog syslog);

}
