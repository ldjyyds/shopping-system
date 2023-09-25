package com.example.controller;

import com.example.pojo.PageBean;
import com.example.pojo.Product;
import com.example.pojo.Result;
import com.example.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 新增产品信息
     * @param product
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Product product){
        log.info("新增商品,product:{}",product);
        productService.save(product);
        return Result.success();
    }

    /**
     * 批量删除商品信息
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除商品信息,ids:{}",ids);
        productService.delete(ids);
        return Result.success();
    }

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
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,  //@RequestParam的defaultValue属性是专门用来设置默认值的。
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, String manufacturer,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询商品信息,参数:{},{},{},{},{},{}",page,pageSize,name,manufacturer,begin,end);
        PageBean pageBean = productService.page(page,pageSize,name,manufacturer,begin,end);
        return Result.success(pageBean);
    }

    /**
     * 更新商品信息
     * @param product
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Product product){
        log.info("更新商品信息:{}",product);
        productService.update(product);
        return Result.success();
    }


}
