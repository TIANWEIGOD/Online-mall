package cn.itcast.service;

import cn.itcast.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();

    void saveRole(Role role);

    Role findRoleById(String roleId);

    void addPermissionToRole(String roleId, String[] ids);
}
