package com.wh.mybatistest.services;

import com.wh.mybatistest.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> findUserByMobile(String id);
    User findUserById(Long id);
    Boolean create(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(Long id);
 }
