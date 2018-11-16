package cn.itcast.service.impl;

import cn.itcast.dao.ProductDao;
import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao pd;

    @Override
    public List<Product> findAll() throws Exception {
        return pd.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        pd.save(product);
    }

    @Override
    public int update(Product product) {
        return pd.update(product);
    }

    @Override
    public int delete(int id) {
        return pd.delete(id);
    }

    @Override
    public Product findById(int id) {
        return pd.findProductById(id);
    }

    @Override
    public PageInfo<Product> findProductByPageHelper(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> products = pd.findAll();
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }
}
