package com.liu.ssm.service;

import com.liu.ssm.model.User;
import com.liu.ssm.model.UserExample;

import java.util.List;

public interface UserService {
    User getUserById(int userId);
    boolean save(User user);
    boolean update(User user);
    boolean delete(int id);
    User findById(int id);
    List<User> findAll(UserExample user);

}