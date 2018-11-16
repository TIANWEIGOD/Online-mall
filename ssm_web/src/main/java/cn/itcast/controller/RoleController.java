package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import cn.itcast.service.PermissionService;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService rs;
    @Autowired
    private PermissionService ps;

    @RequestMapping("findAllRole")
    public String findAllRole(Model model){

        List<Role> roles = rs.findAllRole();
        // System.out.println("findAllRole--controller"+roles);
        model.addAttribute("roleList",roles);

        return "role/roleList";
    }

    @RequestMapping("initAddRole")
    public String initAddRole(){
        return "role/roleAdd";
    }

    @RequestMapping("saveRole")
    public String saveRole(Role role){
        rs.saveRole(role);

        return "redirect:/role/findAllRole"; // 或者 redirect:findAllRole
    }

    @RequestMapping("initAddPermissionToRole")
    public String initAddPermissionToRole(String roleId,Model model){
        Role role = rs.findRoleById(roleId);
        List<Permission> permissions = role.getPermissions();

        if (permissions != null && permissions.size() > 0){
            StringBuilder sb = new StringBuilder();
            for (Permission permission : permissions) {
                sb.append(permission.getPermissionName()+",");
            }
            System.out.println(1);
            model.addAttribute("permissionStr",sb.toString());
        }

        List<Permission> allPermission = ps.findAllPermission();

        model.addAttribute("permissionList",allPermission);
        model.addAttribute("role",role);

        return "role/role-permission-add";
    }

    @RequestMapping("addPermissionToRole")
    public String addPermissionToRole(String roleId,String[] ids){
        rs.addPermissionToRole(roleId,ids);

        return "redirect:/role/findAllRole";
    }
}
