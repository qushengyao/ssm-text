package cn.itcast.dao;

import cn.itcast.domain.Permission;

import java.util.List;

public interface PermissionDao {
    List<Permission> findById();

    List<Permission> findAll();

    void save(Permission permission);
}
