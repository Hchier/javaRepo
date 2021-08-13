package com.example.springbootdemo1.dao;

import com.example.springbootdemo1.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.HashMap;

@Repository
public class UserDao {
    private static Map<Integer, User> users=null;
    static{
        users=new HashMap<Integer,User>();
        users.put(1,new User("101","a","a@qq.com"));
        users.put(2,new User("102","b","b@qq.com"));
        users.put(3,new User("103","c","c@qq.com"));
    }
}
