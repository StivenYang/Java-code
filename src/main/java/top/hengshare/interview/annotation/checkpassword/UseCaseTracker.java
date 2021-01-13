package top.hengshare.interview.annotation.checkpassword;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 注解处理器，具体的使用注解
 *
 * @author yang
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("找到了使用UseCase的地方：" + uc.id() + ", " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (Integer i : useCases) {
            System.err.println("警告：没有找到useCase: " + i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 1, 2, 3, 4, 5);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
