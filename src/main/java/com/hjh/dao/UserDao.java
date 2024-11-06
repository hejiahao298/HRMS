package com.hjh.dao;

import com.hjh.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {

    @Select("select user_id,username,password from Users where username = #{username} and password = #{password}")
    public User login(String username , String password);

    @Select("select user_id from Users where username = #{username}")
    public Integer findUsername(String username);

    @Update("update Users set password = #{password} where username = #{username}")
    public Integer resetPassword(String password, String username);
}
