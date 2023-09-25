package com.example.mapper;

import com.example.pojo.Guest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GuestMapper {
    @Insert("insert into guest(account, name, telephone, email, create_time, update_time) values(#{account},#{name},#{telephone},#{email},#{createTime},#{updateTime})")
    void insert(Guest guest);

    void delete(List<Integer> ids);

    /**
     * 客户信息查询
     * @param name
     * @param telephone
     * @return
     */
    List<Guest> list(String name, Long telephone);

    void update(Guest guest);

    @Select("select * from shoppingsys.guest where id=#{id}")
    Guest findById(Integer id);


    /**
     * 通过账号和密码查询顾客
     * @param guest
     * @return
     */
    @Select("select * from shoppingsys.guest where account=#{account} and code=#{code}")
    Guest getByAccountAndCode(Guest guest);
}
