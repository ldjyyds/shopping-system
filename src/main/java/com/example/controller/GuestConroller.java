package com.example.controller;

import com.example.pojo.Admin;
import com.example.pojo.Guest;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.GuestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/guests")
public class GuestConroller {

    @Autowired
    private GuestService guestService;
    /**
     * 增加客户的信息
     * @param guest
     * @return
     */
    @PostMapping("/G")
    public Result saveG(@RequestBody Guest guest){
        log.info("新增客户,guest:{}",guest);
        guestService.saveG(guest);
        return Result.success();
    }

    /**
     * 增加管理员的信息
     * @param admin
     * @return
     */
    @PostMapping("/A")
    public Result saveA(@RequestBody Admin admin){
        log.info("新增管理员信息,admin:{}",admin);
        guestService.saveA(admin);
        return Result.success();
    }

    /**
     * 批量删除客户信息
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result deleteG(@PathVariable List<Integer> ids){
        log.info("批量删除客户,ids:{}",ids);
        guestService.deleteG(ids);
        return Result.success();
    }

    /**
     * 通过id删除管理员信息
     * @param id
     * @return
     */
    @DeleteMapping("/A/id")
    public Result deleteA(@PathVariable Integer id){
        log.info("通过id删除管理员信息,id:{}",id);
        guestService.deleteA(id);
        return Result.success();
    }

    /**
     * 通过姓名，手机号分页查找用户信息
     * @param page
     * @param pageSize
     * @param name
     * @param telephone
     * @return
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,  //@RequestParam的defaultValue属性是专门用来设置默认值的。
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Long telephone){
        log.info("分页查询,参数:{},{},{},{}",page,pageSize,name,telephone);
        //调用service分页查询

        PageBean pageBean = guestService.page(page,pageSize,name,telephone);
        return Result.success(pageBean);
    }

    /**
     * 展示管理员信息
     */
    @GetMapping("/A")
    public Result list(){
        log.info("查询全部管理员的信息");

        List<Admin> adminList=guestService.list();
        return Result.success(adminList);
    }

    /**
     * 更新客户信息
     * @param guest
     * @return
     */
    @PutMapping("/G")
    public Result updateG(@RequestBody Guest guest){

        log.info("更新用户信息:{}",guest);
        guestService.updateG(guest);
        return Result.success();
    }

    /**
     * 更新管理员密码
     * @param admin
     * @return
     */
    @PutMapping("/A")
    public Result updateA(@RequestBody Admin admin){
        log.info("更新管理员信息:{}",admin);
        guestService.updateA(admin);
        return Result.success();
    }

    /**
     * 注册
     * @param guest
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody Guest guest, HttpServletRequest request){

        if(guest.getAccount().equals("admin")){
            return Result.error("您输入的用户名被禁止，请重新注册");
        }
        log.info("用户 {} 注册账号中",guest.getName());
        guestService.register(guest);
        request.getSession().setAttribute("user", guest);
        return Result.success();
    }

}
