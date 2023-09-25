package com.example.controller;

import com.example.pojo.Product;
import com.example.pojo.Result;
import com.example.pojo.ShoppingCart;
import com.example.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shopcarts")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    /**
     * 四个功能
     * 将商品存入购物车
     * 将商品移除购物车
     * 展示，查询购物车
     * 付款
     * 修改产品的数量
     */


    /**
     * 展示用户的购物车信息
     * @param guestId
     * @return
     */
    @GetMapping
    public Result list(Integer guestId){
        log.info("展示用户id为{}的故购车信息",guestId);
        List<Product> productsList=shoppingCartService.list(guestId);
        return Result.success(productsList);
    }

    /**
     * 为用户增加商品到购物车中
     * @param shoppingCart
     * @return
     */
    @PostMapping
    public Result save(@RequestBody ShoppingCart shoppingCart){
        log.info("为用户id为{}的用户增加商品信息{}",shoppingCart.getGuestId(),shoppingCart);
        shoppingCartService.save(shoppingCart);
        return Result.success();
    }

    /**
     * 为用户删除从购物车中删除购物信息
     * @param shoppingCart
     * @return
     */
    @DeleteMapping
    public Result delete(@RequestBody ShoppingCart shoppingCart){
        log.info("为用户id为{}的用户删除商品信息{}",shoppingCart.getGuestId(),shoppingCart);
        shoppingCartService.delete(shoppingCart);
        return Result.success();
    }

    /**
     * 客户付款功能
     * @param id
     * @return
     */
    @GetMapping("/pay")
    public Result pay(Integer id){
        log.info("付款操作:{}",id);
        shoppingCartService.pay(id);
        return Result.success();
    }


    /**
     * 修改购物车中物品的数量
     * @param shoppingCart
     * @return
     */
    @PutMapping
    public Result update(@RequestBody ShoppingCart shoppingCart){
        log.info("客户正在修改物品的数量:{}",shoppingCart);
        if(shoppingCart.getProductQuantity()==0){
            shoppingCartService.delete(shoppingCart);
            return Result.success();
        }
        shoppingCartService.update(shoppingCart);
        return Result.success();
    }
}
