package com.example.service.impl;

import com.example.mapper.RoleMapper;
import com.example.pojo.Role;
import com.example.service.RoleService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void save(Role role) {
        //进行逻辑处理
        role.setCreateTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        //String permissions=new Gson().toJson(role.getPermission());
        roleMapper.inset(role);
    }
}
