package cn.itcast.dao;

import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoDao {

    UserInfo findByUsername(String username);

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findOtherRole(String id);

    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
