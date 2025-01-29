package com.itheima.sh.dao;

import com.itheima.sh.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
//创建接口

public interface UserMapper {
    //定义登陆方法
    //在方法上用注解查询数据
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(User user);

    //用相同的方法开发注册
    @Insert("insert into user(username, password) values (#{username},#{password})")
    int register(User user);

    //查询该用户名是否被注册
    @Select("select * from user where username=#{username}")
    User check(User user);
}
