package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao rd;

    @Override
    public List<Role> findAllRole() {
        return rd.findAllRole();
    }

    @Override
    public void saveRole(Role role) {
        rd.saveRole(role);
    }

    @Override
    public Role findRoleById(String roleId) {
        return rd.findRoleById(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        rd.deleteAllPermission(roleId);

        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                rd.addPermissionToRole(roleId, id);
            }
        }
    }

    public List<Role> findRoleByUserId(String id) {
        List<Role> roles = rd.findRoleByUserId(id);
        return roles;
    }
}
