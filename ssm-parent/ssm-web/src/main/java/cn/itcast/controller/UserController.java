package cn.itcast.controller;

import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId ,@RequestParam(name = "ids",required = true) List<String> ids){

        userService.addRoleToUser(userId,ids);
        return "redirect:findAll.do" ;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(ModelAndView modelAndView ,@RequestParam(name = "id",required = true) String id){
        UserInfo user = userService.findById(id);
        List<Role> roleList =  userService.findOtherRole(id);
        modelAndView.addObject("user",user);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(ModelAndView modelAndView ,@RequestParam(name = "id",required = true) String id){
        UserInfo user =  userService.findById(id);

        modelAndView.addObject("user",user);
        modelAndView.setViewName("user-show1");
        return modelAndView;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<UserInfo> userList = userService.findAll();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do" ;
    }
}
