package com.example.service;

import com.example.pojo.Admin;
import com.example.pojo.Guest;
import com.example.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface GuestService {
    /**
     * 增加客户信息
     * @param guest
     */
    void saveG(Guest guest);

    /**
     * 增加管理员信息
     * @param admin
     */
    void saveA(Admin admin);

    /**
     * 批量删除客户信息
     * @param ids
     */
    void deleteG(List<Integer> ids);

    /**
     * 删除管理员信息
     * @param id
     */
    void deleteA(Integer id);

    /**
     * 分页查询客户信息
     * @param page
     * @param pageSize
     * @param name
     * @param telephone
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Long telephone);

    /**
     * 展示管理员信息
     * @return
     */
    List<Admin> list();

    /**
     * 用户注册
     * @param guest
     */
    void register(Guest guest);

    /**
     * 更新客户信息
     * @param guest
     */
    void updateG(Guest guest);

    /**
     * 更新管理员的密码
     * @param admin
     */
    void updateA(Admin admin);

    /**
     * 根据id查找客户信息
     * @param id
     * @return
     */
    Guest findById(Integer id);

    /**
     * 客户进行登录
     * @param guest
     * @return
     */
    Guest loginG(Guest guest);

    /**
     * 管理员进行登录
     * @param admin
     * @return
     */
    Admin loginA(Admin admin);
}
