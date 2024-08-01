package cn.mango3y.controller;

import cn.mango3y.entity.Page;
import cn.mango3y.entity.User;
import cn.mango3y.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //用RestController的话 return "user" 只会往前端返回一个user字符串
public class UserController {

    //在Controller中注入Service这个过程其实是往springMVC工厂中的一个bean中注入了spring工厂的bean，
    //这样跨工厂的注入本身是不允许的，因为工厂注入仅限于工厂内部。
    //为什么这里可以呢？
    //因为工厂总的父类ApplicationContext类中有一个getParent方法，意味着工厂都可以获得自己的父工厂，
    //而web.xml中DispatcherServlet组建了工厂1-创建与springMVC相关组件，
    //ContextLoaderListener组建了工厂2-创建与spring相关组件
    //而工厂1是2的子工厂。
    //这种关系就像java父子类一样，子工厂可以随意使用父工厂的所有对象。
    //正因如此我们才可以在springMVC的一个Controller中注入spring工厂的service
    @Autowired
    private UserService userService;

    /* http://localhost:8080/ssm/users */
    @GetMapping("/users")
    public String queryUsers(Model model, Page page){
        System.out.println("queryUsers");
        PageInfo<User> userPageInfo = userService.queryUsers(page);
        model.addAttribute("data", userPageInfo);
        return "userPro";
    }

    @GetMapping("/users/{id}")
    public String queryOne(@PathVariable Integer id){
        System.out.println("query user id:" + id);
        return "index";
    }

    @PostMapping("/users")
    public String updateUser(@RequestBody User user){
        System.out.println("update User:" + user);
        return "index";
    }
}
