package com.example.mapper;

import com.example.pojo.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface PermissionMapper {

    /**
     * 增加权限
     * @param permission
     */
    @Insert("insert into permission(name, path, create_time, update_time) values(#{name},#{path},#{createTime},#{updateTime})")
    void insert(Permission permission);

    /**
     * 删除权限
     * @param ids
     */
    @Delete("")
    void delete(List<Integer> ids);

    List<Permission> list(String name, LocalDate begin, LocalDate end);
}
