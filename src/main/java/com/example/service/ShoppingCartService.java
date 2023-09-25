package com.example.service;

import com.example.pojo.Product;
import com.example.pojo.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    /**
     * 展示客户的购物车内容
     * @param guestId
     * @return
     */
    List<Product> list(Integer guestId);

    /**
     * 在购物车中增加商品的功能
     * @param shoppingCart
     */
    void save(ShoppingCart shoppingCart);

    /**
     * 从购物车中删除商品的功能
     * @param shoppingCart
     */
    void delete(ShoppingCart shoppingCart);

    /**
     * 在购物车中付款的功能
     * @param id
     */
    void pay(Integer id);

    /**
     * 在购物车中更新产品的数量
     * @param shoppingCart
     */
    void update(ShoppingCart shoppingCart);
}
