package top.hengshare.interview.algorithm.interview;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void filterStudent(){
        Student yang = new Student("yang", new Date(1680));
        Student yang1 = new Student("yang", new Date(1680));
        Student yang2 = new Student("yang", new Date(1680));
        Student wang = new Student("wang", new Date(1680));
        Student[] sourceArray = new Student[4];
        sourceArray[0] = yang;
        sourceArray[1] = wang;
        sourceArray[2] = yang1;
        sourceArray[3] = yang2;

        List<Student> targetList = Arrays.stream(sourceArray).distinct().collect(Collectors.toList());
        System.out.println(Arrays.toString(targetList.toArray(sourceArray)));
    }
}