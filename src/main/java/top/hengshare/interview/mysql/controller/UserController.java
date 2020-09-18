package top.hengshare.interview.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hengshare.interview.mysql.model.User;
import top.hengshare.interview.mysql.service.UserService;

import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("insert")
    private void insert() throws Exception {
        User user = new User();
        user.setUsername("abc");
        user.setPassword("adf");
        user.setEmail("abc@ac.com");
        user.setCreateTime(new Date());
        user.setCreator("abc");
        userService.addUser(user);
        System.out.println(user);
    }
}
