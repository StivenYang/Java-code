package top.hengshare.interview.reflect;

import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class TestATest {

    @Test
    public void testClassReflectInfo() {
        Class<?> testA = TestA.class;
        System.out.println("getPackage(): " + testA.getPackage().getName());
        System.out.println("getName():" + testA.getName());
        System.out.println("getSimpleName():" + testA.getSimpleName());
        System.out.println("getClassLoader():" + testA.getClassLoader());
        System.out.println("getCanonicalName():" + testA.getCanonicalName());
        System.out.println("getModifiers():" + testA.getModifiers());
        System.out.println("getComponentType():" + testA.getComponentType());
        System.out.println("getResource(\"path\"):" + testA.getResource("path"));
        System.out.println("getSigners():" + Arrays.toString(testA.getSigners()));
        System.out.println("getSuperclass():" + testA.getSuperclass());

        System.out.println("getProtectionDomain():" + testA.getProtectionDomain());
        System.out.println("getEnclosingClass():" + testA.getEnclosingClass());
        System.out.println("getEnclosingConstructor():" + testA.getEnclosingConstructor());
        System.out.println("getEnclosingMethod():" + testA.getEnclosingMethod());
        System.out.println("getEnumConstants():" + Arrays.toString(testA.getEnumConstants()));


        System.out.println("getAnnotation(Data.class):" + testA.getAnnotation(Data.class));
        System.out.println("getAnnotatedSuperclass()" + testA.getAnnotatedSuperclass().toString());
        System.out.println("getInterfaces():" + Arrays.toString(testA.getInterfaces()));
        System.out.println("getConstructors():" + Arrays.toString(testA.getConstructors()));
        System.out.println("getFields():" + Arrays.toString(testA.getFields()));
        System.out.println("getMethods():" + Arrays.toString(testA.getMethods()));
        System.out.println("getAnnotations():" + Arrays.toString(testA.getAnnotations()));
        System.out.println("getAnnotatedInterfaces():" + Arrays.toString(testA.getAnnotatedInterfaces()));

        System.out.println("getDeclaringClass():" + testA.getDeclaringClass());
        System.out.println("getDeclaredConstructors():" + Arrays.toString(testA.getDeclaredConstructors()));
        System.out.println("getDeclaredFields():" + Arrays.toString(testA.getDeclaredFields()));
        System.out.println("getDeclaredMethods():" + Arrays.toString(testA.getDeclaredMethods()));
        System.out.println("getDeclaredAnnotations():" + Arrays.toString(testA.getDeclaredAnnotations()));
        System.out.println("getDeclaredClasses():" + Arrays.toString(testA.getDeclaredClasses()));
        System.out.println("getDeclaredAnnotationsByType(Data.class):" + Arrays.toString(testA.getDeclaredAnnotationsByType(Data.class)));
    }
}