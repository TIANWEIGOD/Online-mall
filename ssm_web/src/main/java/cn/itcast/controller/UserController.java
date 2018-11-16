package cn.itcast.controller;

import cn.itcast.domain.Role;
import cn.itcast.domain.SysUser;
import cn.itcast.service.RoleService;
import cn.itcast.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService us;
    @Autowired
    private RoleService rs;

    @RequestMapping("findAllUser")
    public String findAllUser(Model model) {
        List<SysUser> users = us.findAllUser();
        model.addAttribute("userlist", users);
        return "user/userList";
    }

    @RequestMapping("initAddUser")
    public String initAddUser(){
        return "/user/userAdd";
    }


    @RequestMapping("saveUser")
    public String saveUser(SysUser sysUser) {

        us.saveUser(sysUser);

        return "redirect:/user/findAllUser";
    }

    @RequestMapping("showUserById")
    public ModelAndView showUserById(String id){
        ModelAndView mv = new ModelAndView();

        SysUser sysUser = us.findUserById(id);
        System.out.println("showUserById--controller"+sysUser);
        mv.addObject("user",sysUser);
        mv.setViewName("user/userShow");

        return mv;
    }

    @RequestMapping("initAddRoleToUser")
    public ModelAndView initAddRoleToUser(String id){
        ModelAndView mv = new ModelAndView();

        SysUser sysUser = us.findUserById(id);

        List<Role> roles = rs.findAllRole();

        StringBuilder sb = new StringBuilder();

        for (Role role : roles){
            sb.append(role.getRoleName());
            sb.append(",");
        }

        String roleStr = sb.toString();
        System.out.println("initAddRoleToUser--controller:"+roleStr+"--"+sysUser.getId());

        mv.addObject("roleStr","");
        mv.addObject("user",sysUser);
        mv.addObject("roleList",roles);
        mv.setViewName("user/user-role-add");

        return mv;
    }

    @RequestMapping("addRoleToUser")
    public String addRoleToUser(String userId,String[] ids){

        System.out.println("addRoleToUser--controller:"+userId+"--"+ids.toString());
        us.addRoleToUser(userId,ids);

        return "redirect:/user/findAllUser";
    }

}
