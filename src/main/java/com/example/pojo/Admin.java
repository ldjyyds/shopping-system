package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id;//主键id
    private String account;//管理员账号
    private String code; //管理员密码
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//修改时间
}
