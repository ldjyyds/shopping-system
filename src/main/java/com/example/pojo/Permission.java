package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 权限类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    private Integer id;
    private String name;  //权限名称
    private String path;  //菜单路径
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间

}
