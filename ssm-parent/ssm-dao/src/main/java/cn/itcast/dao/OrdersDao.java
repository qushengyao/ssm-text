package cn.itcast.dao;

import cn.itcast.domain.Orders;
import com.github.pagehelper.PageHelper;

import java.util.List;

public interface OrdersDao {

    List<Orders> findAll();


    Orders findById(String id);
}

