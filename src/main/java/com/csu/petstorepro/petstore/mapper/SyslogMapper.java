package com.csu.petstorepro.petstore.mapper;

import com.csu.petstorepro.petstore.entity.Syslog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
public interface SyslogMapper extends BaseMapper<Syslog> {
    //对日志信息进行插入操作
    void insertSyslog(Syslog syslog);

}
