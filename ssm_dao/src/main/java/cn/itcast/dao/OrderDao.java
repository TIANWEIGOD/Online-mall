package cn.itcast.dao;

import cn.itcast.domain.Order;
import cn.itcast.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderDao {
    @Select("select * from orders")
    @Results({
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "cn.itcast.dao.ProductDao.findProductById", fetchType = FetchType.LAZY))
    })
    List<Order> findAll();
}
