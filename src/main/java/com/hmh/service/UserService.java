package com.hmh.service;

import com.hmh.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

public interface UserService {

    public List<User> query(Map<String, Object> param);

    @Cacheable(value = "userCache", key = "#id")
    public User findById(int id);

    @CachePut(value = "userCache", key = "#id")
    public User saveUser(User user);

    @CacheEvict(value = "userCache", key = "#id")
    public void deleteUser(int id);

    public User updateUser(User user);

}
