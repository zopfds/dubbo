package com.example.provider.user;

import com.example.provider.po.UserPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: jianbo.pan
 * @date: 2022/7/8
 * @version: V1.0
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(user_name) values (#{userName})")
    int insert(UserPo userPo);

    @Select("select * from user where id=#{id}")
    UserPo getById(Long id);

    @Select("select * from user where user_name like %#{userName}%")
    List<UserPo> getByUserName(String userName);

    @Select("select * from user")
    List<UserPo> getAllUsers();
}