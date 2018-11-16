package cn.itcast.service;

import cn.itcast.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

// 给Security框架提供数据，要求service接口必须继承UserDetailsService接口，提供了方法，必须实现该方法
public interface UserService extends UserDetailsService {
    List<SysUser> findAllUser();

    void saveUser(SysUser sysUser);

    SysUser findUserById(String id);

    void addRoleToUser(String userId, String[] ids);
}
