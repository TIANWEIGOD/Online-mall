package cn.itcast.service.impl;

import cn.itcast.dao.PermissionDao;
import cn.itcast.domain.Permission;
import cn.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao pd;

    @Override
    public List<Permission> findAllPermission() {
        return pd.findAllPermission();
    }

    @Override
    public void savePermission(Permission permission) {
        pd.savePermission(permission);
    }
}
