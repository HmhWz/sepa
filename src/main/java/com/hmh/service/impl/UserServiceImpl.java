package com.hmh.service.impl;

import com.hmh.dao.UserDao;
import com.hmh.entity.User;
import com.hmh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> query(Map<String, Object> param) {
        return userDao.query(param);
    }

    @Override
    public User findById(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<User> users = this.query(map);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User saveUser(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", user.getName());
        map.put("address", user.getAddress());
        userDao.saveUser(map);
        user.setId((int)map.get("id"));
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        userDao.deleteUser(map);
    }

    @Override
    public User updateUser(User user) {
        userDao.updateUser(user);
        return user;
    }
}
