package cn.itcast.service;

import cn.itcast.domain.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {

    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;

    int update(Product product);

    int delete(int id);

    Product findById(int id);

    PageInfo<Product> findProductByPageHelper(int pageNum, int pageSize) throws Exception;
}
