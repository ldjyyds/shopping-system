package com.example.mapper;

import com.example.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Insert("insert into admin(account,create_time,update_time)" +
            "values(#{account},#{createTime},#{updateTime})")
    void insert(Admin admin);

    @Delete("delete from where id=#{id}")
    void delete(Integer id);

    @Select("select * from shoppingsys.admin")
    List<Admin> list();

    void update(Admin admin);

    /**
     * 根据用户名和密码查询管理员
     * @param admin
     * @return
     */
    @Select("select * from shoppingsys.admin where account=#{account} and code=#{code}")
    Admin getByAccountAndCode(Admin admin);
}
