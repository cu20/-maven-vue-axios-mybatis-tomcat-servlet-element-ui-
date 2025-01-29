package com.itheima.sh.service;

import com.itheima.sh.dao.UserMapper;
import com.itheima.sh.pojo.User;
import com.itheima.sh.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl {
    public User login(User user){
        //获取mybatis的会话对象，使用了工具类
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //使用会话技术调用方啊获取dao层的接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //使用接口代理对象调用接口中的登陆方法
        User u = mapper.login(user);
        //释放资源
        sqlSession.close();
        return u;
    }

    public User check(User user){
        //获取mybatis的会话对象，使用了工具类
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //使用会话技术调用方啊获取dao层的接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //使用接口代理对象调用接口中的登陆方法
        User u = mapper.check(user);
        //释放资源
        sqlSession.close();
        return u;
    }

    public int register(User user) {
        //获取mybatis的会话对象，使用了工具类
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //使用会话技术调用方啊获取dao层的接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //使用接口代理对象调用接口中的登陆方法
        int u = mapper.register(user);
        //释放资源
        sqlSession.close();
        return u;
    }
}
