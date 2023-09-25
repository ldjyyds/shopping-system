package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
    private Integer id; //主键id
    private String account;//客户账号
    private String name; //客户姓名
    private Short level;  //客户等级
    private Integer amount; //客户消费总数
    private Long telephone;  //客户手机号
    private String email;  //客户邮箱
    private String code;  //客户密码
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
