package com.example.service;


import com.example.pojo.PageBean;
import com.example.pojo.Permission;

import java.time.LocalDate;
import java.util.List;

public interface PermissionService {
    /**
     * 新增权限功能
     * @param permission
     */
    void save(Permission permission);

    /**
     * 删除权限
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param name
     * @param begin
     * @param end
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end);
}
