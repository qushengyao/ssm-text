package cn.itcast.service.Impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(String id) {
        return roleDao.findRoleByIdAndAllPermission(id);
    }

    @Override
    public Role findByRoleIdId(String id) {
        return roleDao.findByRoleId(id);
    }

    @Override
    public void addPermissionToRole(String roleId, List<String> ids) {
        for (String permissionId : ids) {
            roleDao.addPermissionToRole(permissionId,roleId);
        }

    }
}
