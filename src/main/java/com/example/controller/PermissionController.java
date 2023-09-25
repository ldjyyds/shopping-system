package com.example.controller;

import com.example.pojo.PageBean;
import com.example.pojo.Permission;
import com.example.pojo.Result;
import com.example.pojo.Role;
import com.example.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/permissions")
@Slf4j
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    /**
     * 增加权限
     * @param permission
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Permission permission){
        log.info("新增权限菜单,permission:{}",permission);
        permissionService.save(permission);
        return Result.success();
    }

    /**
     * 删除权限
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作,ids:{}",ids);
        permissionService.delete(ids);
        return Result.success();
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param name
     * @param begin
     * @param end
     * @return
     */
    @GetMapping
    //这里要注意接收参数，只有形参和前端传送的数据名完全一样才可以成功接收数据。
    public Result page(@RequestParam(defaultValue = "1") Integer page,  //@RequestParam的defaultValue属性是专门用来设置默认值的。
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        //在这里需要相应的注解来指定前端传递的日期格式是什么样的。
        log.info("分页查询,参数:{},{},{},{},{}",page,pageSize,name,begin,end);
        //调用service分页查询

        PageBean pageBean = permissionService.page(page,pageSize,name,begin,end);
        return Result.success(pageBean);
    }

    /**
     * 更新权限菜单
     * @param permission
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Permission permission){
       return Result.success();
    }

    /**
     * 根据角色（等级）来查找有那些权限功能。
     * @param role
     * @return
     */
    @PostMapping("/getByRoles")
     public Result getByRoles(@RequestBody Role role){
        return Result.success();
     }

}
