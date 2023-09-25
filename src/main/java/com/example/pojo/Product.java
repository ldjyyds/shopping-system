package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;//主键id
    private String name;//产品名称
    private String manufacturer; //生产厂家
    private String model;//型号
    private Integer purchasePrice; //进货价
    private Integer retailPrice; //零售价
    private Integer quantity;   //数量
    private LocalDate date;//生产日期
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime;//修改时间
}
