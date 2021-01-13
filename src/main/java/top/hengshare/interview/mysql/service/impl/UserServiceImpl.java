package top.hengshare.interview.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.hengshare.interview.annotation.log.LogRecord;
import top.hengshare.interview.constant.LogActionEnum;
import top.hengshare.interview.mysql.mapper.UserMapper;
import top.hengshare.interview.mysql.model.User;
import top.hengshare.interview.mysql.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @LogRecord(action = LogActionEnum.DEFAULT_ACTION)
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    //循环引用
//    @Override
//    @Transactional
//    public int addUserTransaction(User user) throws Exception {
//        int i;
//        try {
//            i = userMapper.insert(user);
//            User user1 = new User();
//            user1.setUsername("abc");
//            throw new RuntimeException("插入失败");
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            throw e;
//        }
//    }




}
