package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 角色类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;

    private String name;  //角色名称

    private String permissions;  //角色拥有的权限

    //private List<Integer> permission;  //角色拥有的权限

    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间

}
