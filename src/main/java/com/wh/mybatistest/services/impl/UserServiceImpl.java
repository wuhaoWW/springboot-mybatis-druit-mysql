package com.wh.mybatistest.services.impl;

import com.wh.mybatistest.mapper.UserMapper;
import com.wh.mybatistest.pojo.User;
import com.wh.mybatistest.pojo.UserExample;
import com.wh.mybatistest.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUserByMobile(String mobile) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        return  userMapper.selectByExample(example);
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean create(User user) {
        return  userMapper.insert(user)!=0;
    }

    @Override
    public Boolean updateUser(User user) {
        User newUser = findUserById(user.getId());
        newUser.setMobile(user.getMobile()!=null?user.getMobile():newUser.getMobile());
        newUser.setPassword(user.getPassword()!=null?user.getPassword():newUser.getPassword());
        newUser.setSex(user.getSex()!=null?user.getSex():newUser.getSex());
        newUser.setBirthdate(user.getBirthdate()!=null?user.getBirthdate():newUser.getBirthdate());
        newUser.setAddress(user.getAddress()!=null?user.getAddress():newUser.getAddress());
        newUser.setEmail(user.getEmail()!=null?user.getEmail():newUser.getEmail());
        newUser.setState(user.getState()!=null?user.getState():newUser.getState());
        newUser.setUpdateTime(user.getUpdateTime()!=null?user.getUpdateTime():newUser.getUpdateTime());
        return userMapper.updateByPrimaryKey(newUser)!=0;
    }

    @Override
    public Boolean deleteUser(Long id) {
        User users = findUserById(id);
        users.setState("-1");
        return updateUser(users);
    }
}
