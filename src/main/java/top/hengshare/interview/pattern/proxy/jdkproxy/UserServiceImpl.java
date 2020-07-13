package top.hengshare.interview.pattern.proxy.jdkproxy;

public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("-------add-------------");
    }

    @Override
    public void delete() {
        System.out.println("--------delete-----------");
    }
}
