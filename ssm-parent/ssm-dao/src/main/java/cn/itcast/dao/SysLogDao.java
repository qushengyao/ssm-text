package cn.itcast.dao;

import cn.itcast.domain.SysLog;

import java.util.List;

public interface SysLogDao {


    void save(SysLog sysLog);

    List<SysLog> findAll();
}