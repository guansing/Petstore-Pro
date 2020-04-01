package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Syslog;
import com.csu.petstorepro.petstore.mapper.SyslogMapper;
import com.csu.petstorepro.petstore.service.ISyslogService;
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
public class SyslogServiceImpl extends ServiceImpl<SyslogMapper, Syslog> implements ISyslogService {

    @Resource
    private SyslogMapper syslogMapper;

    @Override
    public void insertSyslog(Syslog syslog) {
        syslogMapper.insertSyslog(syslog);
    }
}
