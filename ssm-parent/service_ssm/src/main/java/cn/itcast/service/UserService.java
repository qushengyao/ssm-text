package cn.itcast.service;

import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findOtherRole(String id);

    void addRoleToUser(String userId, List<String> ids);
}
