package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.Role;
import com.example.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;
    /**
     * 新增角色
     * @param role
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Role role){
        log.info("新增角色:{}",role);
        roleService.save(role);
        return Result.success();
    }
}
