package cn.itcast.service.impl;

import cn.itcast.dao.OrderDao;
import cn.itcast.domain.Order;
import cn.itcast.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao od;

    @Override
    public PageInfo<Order> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> orders = od.findAll();
        return new PageInfo<Order>(orders);
    }
}
