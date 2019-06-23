package cn.itcast.service;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    List<Permission> findRoleByIdAndAllPermission(String id);

    Role findByRoleIdId(String id);

    void addPermissionToRole(String roleId, List<String> ids);
}
