package com.itheima.dao;

import com.itheima.bean.User;
import com.itheima.utils.C3P0Util;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class logindao {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Util.getDataSource());
    public List<User> login(String username, String password) throws Exception{
        String sql="select * from user  where username=? and password=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        return list;
    }

    public int insert(String username, String password) {
        String sql="insert into user values(null,username,password)?";
        int update = jdbcTemplate.update(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        return update;
    }
}
