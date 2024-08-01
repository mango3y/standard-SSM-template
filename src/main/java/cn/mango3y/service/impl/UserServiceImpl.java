package cn.mango3y.service.impl;

import cn.mango3y.dao.UserDAO;
import cn.mango3y.entity.Page;
import cn.mango3y.entity.User;
import cn.mango3y.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//类中的每个方法都切入事物(有自己的事物控制方法除外)
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, timeout = -1, readOnly = false, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public PageInfo<User> queryUsers(Page page) {
        //取第100页的内容，每页3条结果，由于该表只有7条数据，因为7/3=2…1，返回第3页内容，数据1条
        //PageHelper.startPage(100, 3);
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<User> users = userDAO.queryUsers();
        return new PageInfo<>(users);
    }
}
