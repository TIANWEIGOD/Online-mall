package cn.itcast.dao;

import cn.itcast.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductDao {
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product values (common_sequence.nextval,#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    @Update("update product set productName=#{productName},cityName=#{cityName},departureTime=#{departureTime}," +
            "productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    int update(Product product);

    @Delete("delete from product where id = #{id}")
    int delete(int id);

    @Select("select * from product where id = #{id}")
    Product findProductById(int id);
}
