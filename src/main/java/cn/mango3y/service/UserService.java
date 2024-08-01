package cn.mango3y.service;

import cn.mango3y.entity.Page;
import cn.mango3y.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    PageInfo<User> queryUsers(Page page);
}
