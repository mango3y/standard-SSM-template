package cn.mango3y;

import cn.mango3y.dao.UserDAO;
import cn.mango3y.entity.Page;
import cn.mango3y.entity.User;
import cn.mango3y.service.UserService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class TestSSM {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        List<User> users = userDAO.queryUsers();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void test2(){
        Page page = new Page(2, 3);
        PageInfo<User> users = userService.queryUsers(page);

    }
}
