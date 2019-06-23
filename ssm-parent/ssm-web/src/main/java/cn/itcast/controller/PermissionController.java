package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/save.do")
    public String save(Permission permission){
        permissionService.sava(permission);
        return "redirect:findAll.do" ;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Permission> permissionList = permissionService.findAll();
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

}
