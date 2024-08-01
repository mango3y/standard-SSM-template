package cn.mango3y.dao;

import cn.mango3y.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> queryUsers();
}
