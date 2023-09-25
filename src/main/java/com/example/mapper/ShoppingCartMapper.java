package com.example.mapper;

import com.example.pojo.ShoppingCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    @Select("select * from shoppingsys.shopping_cart where guest_id=#{guestId}")
    List<ShoppingCart> list(Integer guestId);

    @Insert("insert into shopping_cart(guest_id, product_id, product_quantity, update_time, create_time) values(#{guestId},#{productId},#{productQuantity},#{updateTime},#{createTime})")
    void insert(ShoppingCart shoppingCart);

//    @Delete("delete from shopping_cart where guest_id=#{guestId} and product_id=#{productId}")
//    void delete(ShoppingCart shoppingCart);

    @Delete("delete from shopping_cart where id=#{id}")
    void delete(ShoppingCart shoppingCart);

    @Select("select * from shoppingsys.shopping_cart where id=#{id}")
    ShoppingCart findById(Integer id);

    @Update("update shoppingsys.shopping_cart set product_quantity=#{productQuantity},update_time=#{updateTime} where id=#{id}")
    void update(ShoppingCart shoppingCart);
}
