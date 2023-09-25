package com.example.mapper;

import com.example.pojo.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    void inset(Role role);

    /**
     * 新增角色
     * @param role
     */

}
