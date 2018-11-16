package cn.itcast.service;

import cn.itcast.domain.Order;
import com.github.pagehelper.PageInfo;

public interface OrderService {
    PageInfo<Order> findAll(int pageNum, int pageSize);
}
