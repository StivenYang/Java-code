package top.hengshare.interview.pattern.templateMethod.mapper;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.Collection;

/**
 * @program: Java-Interview
 * @description: 用户实体
 * @author: Steven Yang
 * @create: 2019-10-15 19:41
 **/
@Data
public class UserModel {
    private String uuid;
    private String name;
    private int age;
}
