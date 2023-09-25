package com.example.service.impl;

import com.example.mapper.AdminMapper;
import com.example.mapper.GuestMapper;
import com.example.pojo.Admin;
import com.example.pojo.Guest;
import com.example.pojo.PageBean;
import com.example.service.GuestService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestMapper guestMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void saveG(Guest guest) {
        guest.setCreateTime(LocalDateTime.now());
        guest.setUpdateTime(LocalDateTime.now());
        guestMapper.insert(guest);
    }

    @Override
    public void saveA(Admin admin) {
        admin.setCreateTime(LocalDateTime.now());
        admin.setUpdateTime(LocalDateTime.now());
        adminMapper.insert(admin);
    }

    @Override
    public void deleteG(List<Integer> ids) {
        guestMapper.delete(ids);
    }

    @Override
    public void deleteA(Integer id) {
        adminMapper.delete(id);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Long telephone) {
        //1.设置分页参数
        PageHelper.startPage(page,pageSize);

        //2.执行查询
        List<Guest> guestList = guestMapper.list(name, telephone);  //现在获取的list集合是分页查询结果的封装类，也就是Page类型
        Page<Guest> p=(Page<Guest>) guestList;
        //Page里面封装的就是分页查询的结果。

        //3.封装PageBean对象
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());

        return pageBean;
    }

    @Override
    public List<Admin> list() {
        return adminMapper.list();
    }

    @Override
    public void register(Guest guest) {
        guest.setCreateTime(LocalDateTime.now());
        guest.setUpdateTime(LocalDateTime.now());
        guestMapper.insert(guest);
    }

    @Override
    public void updateG(Guest guest) {
        guest.setUpdateTime(LocalDateTime.now());
        guestMapper.update(guest);
    }

    @Override
    public void updateA(Admin admin) {
        admin.setUpdateTime(LocalDateTime.now());
        adminMapper.update(admin);
    }

    @Override
    public Guest findById(Integer id) {
        Guest guest=guestMapper.findById(id);
        return guest;
    }

    @Override
    public Guest loginG(Guest guest) {
        return guestMapper.getByAccountAndCode(guest);
    }

    @Override
    public Admin loginA(Admin admin) {
        return adminMapper.getByAccountAndCode(admin);
    }
}
