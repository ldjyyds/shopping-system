package com.example.mapper;

import com.example.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product(name, manufacturer, date, model, retail_price, purchase_price, quantity, create_time, update_time) values(#{name},#{manufacturer},#{date},#{model},#{retailPrice},#{purchasePrice},#{quantity},#{createTime},#{updateTime})")
    void insert(Product product);

    void delete(List<Integer> ids);

    List<Product> list(String name, String manufacturer, LocalDate begin, LocalDate end);

    void update(Product product);

    @Select("select * from shoppingsys.product where id=#{productId}")
    Product findById(Integer productId);
}
