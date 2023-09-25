package com.example.service;

import com.example.pojo.PageBean;
import com.example.pojo.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {
    /**
     * 新增产品信息
     * @param product
     */
    void save(Product product);

    /**
     * 批量删除商品信息
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 分页查询商品信息
     * @param page
     * @param pageSize
     * @param name
     * @param manufacturer
     * @param begin
     * @param end
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, String manufacturer, LocalDate begin, LocalDate end);

    /**
     * 更新商品信息
     * @param product
     */
    void update(Product product);

    /**
     * 根据产品id查找产品
     * @param productId
     * @return
     */
    Product findById(Integer productId);
}
