package com.example.service.impl;

import com.example.mapper.PermissionMapper;
import com.example.pojo.PageBean;
import com.example.pojo.Permission;
import com.example.service.PermissionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public void save(Permission permission) {
        //将没输入的部分补全
        permission.setCreateTime(LocalDateTime.now());
        permission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insert(permission);
    }

    @Override
    public void delete(List<Integer> ids) {
        permissionMapper.delete(ids);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end) {
        //1.设置分页参数
        PageHelper.startPage(page,pageSize);

        //2.执行查询
        List<Permission> permissionList = permissionMapper.list(name, begin, end);  //现在获取的list集合是分页查询结果的封装类，也就是Page类型
        Page<Permission> p=(Page<Permission>) permissionList;
        //Page里面封装的就是分页查询的结果。

        //3.封装PageBean对象
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());

        return pageBean;
    }
}
