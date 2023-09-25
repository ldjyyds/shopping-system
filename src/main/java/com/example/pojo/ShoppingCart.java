package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    private Integer id;  //主键id
    private Integer guestId;  //客户的id
    private Integer productId;  //产品的id
    private Integer productQuantity;  //购物车中该产品的数量
    private LocalDateTime updateTime;  //修改时间
    private LocalDateTime createTime;  //创建时间
}
