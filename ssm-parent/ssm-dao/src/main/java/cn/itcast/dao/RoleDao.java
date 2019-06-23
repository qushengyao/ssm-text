package cn.itcast.dao;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    List<Role> findById(String id);

    List<Role> findAll();

    void save(Role role);

    List<Permission> findRoleByIdAndAllPermission(String id);

    Role findByRoleId(String id);

    void addPermissionToRole(@Param("permissionId") String permissionId,@Param("roleId") String roleId);
}
