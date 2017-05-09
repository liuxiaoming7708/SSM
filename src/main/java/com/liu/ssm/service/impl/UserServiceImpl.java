package com.liu.ssm.service.impl;

import com.liu.ssm.dao.UserMapper;
import com.liu.ssm.model.User;
import com.liu.ssm.model.UserExample;
import org.springframework.stereotype.Service;

import com.liu.ssm.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public User getUserById(int userId) {
        // TODO Auto-generated method stub
        return this.userMapper.selectByPrimaryKey(userId);
    }



    public boolean save(User user) {
        int i  = 0;
        i = this.userMapper.insert(user);
        if(i == 0){
            return false;
        }
        return true;
    }

    public boolean update(User user) {
        int i  = 0;
        i =  userMapper.updateByPrimaryKey(user);
        System.out.println(userMapper.updateByPrimaryKey(user));
        if(i == 0){
            return false;
        }
        return true;
    }

    public boolean delete(int id) {
        int i  = 0;
        i =  userMapper.deleteByPrimaryKey(id);
        System.out.println(userMapper.deleteByPrimaryKey(id));
        if(i == 0){
            return false;
        }
        return true;
    }

    public User findById(int id) {
        return null;
    }

    public List<User> findAll(UserExample user) {
        return this.userMapper.selectByExample(user);
    }
}