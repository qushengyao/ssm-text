package cn.itcast.service.Impl;

import cn.itcast.dao.UserInfoDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserInfo> findAll() {
         List<UserInfo>  userInfoList =  userInfoDao.findAll();
        return userInfoList;
    }

    @Override
    public void save(UserInfo userInfo) {

        //对密码进行加密处理
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userInfoDao.findById(id);
    }

    @Override
    public List<Role> findOtherRole(String id) {
        return  userInfoDao.findOtherRole(id);
    }

    @Override
    public void addRoleToUser(String userId, List<String> ids) {
        for (String roleId : ids) {
            userInfoDao.addRoleToUser(userId,roleId);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.findByUsername(username);

        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getList(userInfo.getRoles()));
        return user;
    }

    public  List<SimpleGrantedAuthority> getList(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getRoleName());
            list.add(simpleGrantedAuthority);
        }
        return list;
    }


}
