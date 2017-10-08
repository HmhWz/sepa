package com.hmh.dao;

import com.hmh.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> query(Map<String, Object> param);

    public int saveUser(Map<String, Object> param);

    public void deleteUser(Map<String, Object> param);

    public int updateUser(User user);
}
