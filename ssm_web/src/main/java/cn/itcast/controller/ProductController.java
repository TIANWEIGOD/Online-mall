package cn.itcast.controller;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService ps;

    @RequestMapping("findAllProduct")
    public String findAll(Model model) throws Exception {

        List<Product> list = ps.findAll();

        for (Product product : list) {
            // System.out.println(product);
        }
        model.addAttribute("plist", list);

        return "product/productList";
    }


    @RequestMapping("initAdd")
    public String initAdd() {
        return "product/product-add";
    }

    @RequestMapping("saveProduct")
    public String saveProduct(Product product) throws Exception {
        System.out.println(product);
        ps.save(product);

        return "redirect:/product/findAllProduct";
    }

    @RequestMapping("initUpdate")
    public ModelAndView initUpdate(int id) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println(id);
        Product product = ps.findById(id);
        mv.addObject("product", product);
        mv.setViewName("product/product-update");

        return mv;
    }

    @RequestMapping("updateProduct")
    public String updateProduct(Product product) throws Exception {
        ps.update(product);

        return "redirect:/product/findAllProduct";
    }

    @RequestMapping("deleteProduct")
    public String deleteProduct(int id) throws Exception {
        ps.delete(id);

        return "redirect:/product/findAllProduct";
    }

    @RequestMapping("findProductByPageHelper")
    public ModelAndView findProductByPageHelper(@RequestParam(required = true, defaultValue = "1") int pageNum, @RequestParam(required = true, defaultValue = "2") int pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        PageInfo<Product> page = ps.findProductByPageHelper(pageNum, pageSize);
        mv.addObject("page", page);
        mv.setViewName("product/product-list");
        return mv;
    }
}
