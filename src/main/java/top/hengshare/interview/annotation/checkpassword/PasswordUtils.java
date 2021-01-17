package top.hengshare.interview.annotation.checkpassword;

import java.util.List;

/**
 * PasswordUtils 密码工具类，可以用来对密码进行校验
 *
 * @author StevenYang
 * @since 2020/7/14
 **/
public class PasswordUtils {
    @UseCase(id = 1, description = "密码必须包含一个数字")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 2)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 3, description = "新旧密码不能相等")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
