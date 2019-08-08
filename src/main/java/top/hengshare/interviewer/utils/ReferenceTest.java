package top.hengshare.interviewer.utils;

import lombok.Data;

/**
 * @author StivenYang
 * @program interview
 * @description 引用传参
 * @date 2019-06-14 18:49
 **/
@Data
public class ReferenceTest {

    private String name;

    private String password;

    public static void main(String[] args) {
        ReferenceTest referenceTest = new ReferenceTest();
        referenceTest.testSet(referenceTest);

        System.out.println(referenceTest);
    }

    void testSet(ReferenceTest referenceTest) {
        referenceTest.name = "yang";
        referenceTest.password = "123456";
    }
}
