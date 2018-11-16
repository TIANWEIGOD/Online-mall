package cn.itcast.controller;

import cn.itcast.domain.Order;
import cn.itcast.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService os;

    @RequestMapping("findAllOrder")
    public String findAllOrder(Model model, @RequestParam(required = true,defaultValue = "1")int pageNum,@RequestParam(required = true,defaultValue = "2")int pageSize) {
        PageInfo<Order> page = os.findAll(pageNum,pageSize);
        /*for (Order order : orders) {
            System.out.println(order);
        }*/
        System.out.println("findAllOrder--conroller执行了");
        model.addAttribute("page", page);
        return "order/orderList";
    }
}
