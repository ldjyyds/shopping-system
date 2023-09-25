package com.example.controller;

import com.example.pojo.Admin;
import com.example.pojo.Guest;
import com.example.pojo.Result;
import com.example.service.GuestService;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private GuestService guestService;

    /**
     * 用户通过密码和账号登录
     * @param guest
     * @return
     */
    @PostMapping("/loginG")
    public Result loginG(@RequestBody Guest guest){
        log.info("顾客登录:{}",guest);
        Guest g=guestService.loginG(guest);

        //登录成功，生成令牌，下放令牌
        if(g != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",g.getId());
            claims.put("name",g.getName());
            claims.put("username",g.getAccount());

            String jwt = JwtUtils.generateJwt(null);//jwt令牌就已经包含了当前员工的登录信息.
            return Result.success(jwt);

        }

        //登录失败，返回失败信息
        return Result.error("用户名或密码错误");
    }


    @PostMapping("loginA")
    public Result loginA(@RequestBody Admin admin){
        log.info("管理员登录:{}",admin);
        Admin a=guestService.loginA(admin);

        if(a != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",a.getId());
            claims.put("username",a.getAccount());

            String jwt = JwtUtils.generateJwt(null);//jwt令牌就已经包含了当前员工的登录信息.
            return Result.success(jwt);

        }

        return Result.error("用户名或密码错误");
    }

}
