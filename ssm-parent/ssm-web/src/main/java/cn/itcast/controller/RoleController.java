package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId ,@RequestParam(name = "ids",required = true) List<String> ids){
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll.do" ;
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(ModelAndView modelAndView,@RequestParam(name = "id",required = true) String id){
        Role role = roleService.findByRoleIdId(id);
        List<Permission> permissionList =   roleService.findRoleByIdAndAllPermission(id);

        modelAndView.addObject("role",role);
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do" ;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView){

        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

}
