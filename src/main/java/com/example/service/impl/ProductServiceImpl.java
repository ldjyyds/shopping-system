package com.example.service.impl;

import com.example.mapper.ProductMapper;
import com.example.pojo.PageBean;
import com.example.pojo.Product;
import com.example.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void save(Product product) {
        product.setCreateTime(LocalDateTime.now());
        product.setUpdateTime(LocalDateTime.now());
        productMapper.insert(product);
    }

    @Override
    public void delete(List<Integer> ids) {
        productMapper.delete(ids);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, String manufacturer, LocalDate begin, LocalDate end) {
//1.设置分页参数
        PageHelper.startPage(page,pageSize);

        //2.执行查询
        List<Product> productList = productMapper.list(name, manufacturer, begin, end);  //现在获取的list集合是分页查询结果的封装类，也就是Page类型
        Page<Product> p=(Page<Product>) productList;
        //Page里面封装的就是分页查询的结果。

        //3.封装PageBean对象
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());

        return pageBean;
    }

    @Override
    public void update(Product product) {
        product.setUpdateTime(LocalDateTime.now());
        productMapper.update(product);
    }

    @Override
    public Product findById(Integer productId) {
        Product product = productMapper.findById(productId);
        return product;
    }
}
