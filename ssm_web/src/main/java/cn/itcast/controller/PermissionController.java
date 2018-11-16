package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("permission")
@RolesAllowed("ROLE_ADMIN")
public class PermissionController {
    @Autowired
    private PermissionService ps;

    @RequestMapping("findAllPermission")
    public String findAllPermission(Model model) {

        List<Permission> permissions = ps.findAllPermission();
        System.out.println(permissions);

        model.addAttribute("permissionList", permissions);

        return "permission/permissionList";
    }

    @RequestMapping("initAddPermission")
    public String initAddPermission() {
        return "permission/permissionAdd";
    }


    @RequestMapping("savePermission")
    public String savePermission(Permission permission) {
        System.out.println(permission);
        ps.savePermission(permission);

        return "redirect:/permission/findAllPermission";
    }


}
