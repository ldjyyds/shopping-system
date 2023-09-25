package com.example.service.impl;

import com.example.mapper.ShoppingCartMapper;
import com.example.pojo.Guest;
import com.example.pojo.Product;
import com.example.pojo.ShoppingCart;
import com.example.service.GuestService;
import com.example.service.ProductService;
import com.example.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private GuestService guestService;

    @Override
    public List<Product> list(Integer guestId) {
        List<ShoppingCart> SC=shoppingCartMapper.list(guestId);
        int n=SC.size();
        List<Product> productList=new ArrayList<>();
        for(int i=0;i<n;i++){
            Product p = productService.findById(SC.get(i).getProductId());
            p.setQuantity(SC.get(i).getProductQuantity());
            productList.add(p);
        }
        return productList;
    }

    @Override
    public void save(ShoppingCart shoppingCart) {
        shoppingCart.setCreateTime(LocalDateTime.now());
        shoppingCart.setUpdateTime(LocalDateTime.now());
        shoppingCartMapper.insert(shoppingCart);
    }

    @Override
    public void delete(ShoppingCart shoppingCart) {
        shoppingCartMapper.delete(shoppingCart);
    }

    @Override
    public void pay(Integer id) {
        ShoppingCart shoppingCart=shoppingCartMapper.findById(id);
        shoppingCartMapper.delete(shoppingCart);//从购物车中删除掉该商品

        Product product=productService.findById(shoppingCart.getProductId());
        Integer price=product.getRetailPrice();
        Integer amount=shoppingCart.getProductQuantity();

        Guest g=guestService.findById(shoppingCart.getGuestId());

        Guest guest = new Guest();
        guest.setAmount(price*amount+g.getAmount());
        guest.setId(shoppingCart.getGuestId());
        guestService.updateG(guest);//修改顾客的消费金额记录,以及修改信息的时间
        product.setQuantity(product.getQuantity()-shoppingCart.getProductQuantity());
        productService.update(product); //修改产品表的剩余数量
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        shoppingCart.setUpdateTime(LocalDateTime.now());
        shoppingCartMapper.update(shoppingCart);
    }
}
