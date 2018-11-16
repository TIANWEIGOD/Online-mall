package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.SysUser;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao ud;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> authorities = new ArrayList<>();
        // 这是添加赋予角色,角色对应相应的权限

        // authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        SysUser sysUser = ud.findUserByUsername(username);
        System.out.println(sysUser);
        if (sysUser != null) {
            List<Role> roles = sysUser.getRoles();
            System.out.println(roles);
            for (Role role : roles) {
                String roleName = role.getRoleName();
                System.out.println("ROLE_" + roleName);
                authorities.add(new SimpleGrantedAuthority("ROLE_" + roleName));
            }
        }

        System.out.println("spring-security--" + sysUser);
        // 这个是验证用户{noop}一定要加这个是校验方式
        User user = new User(username, sysUser.getPassword(), authorities);

        return user;
    }

    @Override
    public List<SysUser> findAllUser() {
        return ud.findAllUser();
    }

    @Override
    public void saveUser(SysUser sysUser) {

        String password = passwordEncoder.encode(sysUser.getPassword());
        sysUser.setPassword(password);
        System.out.println("saveUser--service" + password);

        ud.saveUser(sysUser);
    }

    @Override
    public SysUser findUserById(String id) {
        return ud.findUserById(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        ud.deleteUser_RoleById(userId);

        if (ids != null) {
            for (String id : ids) {
                ud.addRoLeToUser(userId, id);
            }
        }
    }

}
