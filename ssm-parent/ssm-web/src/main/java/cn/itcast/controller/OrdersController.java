package cn.itcast.controller;

import cn.itcast.domain.Orders;
import cn.itcast.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView,@RequestParam(name = "page", required = true, defaultValue = "1")
            Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "3")Integer pageSize){
        List<Orders> ordersList =  ordersService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(ModelAndView modelAndView,@RequestParam(name = "id",required = true) String id){

        Orders orders =  ordersService.findById(id);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

}
