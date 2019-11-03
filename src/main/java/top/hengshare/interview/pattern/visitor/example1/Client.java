package top.hengshare.interview.pattern.visitor.example1;

import com.google.common.collect.Lists;

import java.util.Collection;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-11-03 19:25
 **/
public class Client {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();

        EnterpriseCustomer enterpriseCustomner = new EnterpriseCustomer();
        enterpriseCustomner.setName("ABC集团");
        os.addElement(enterpriseCustomner);

        EnterpriseCustomer enterpriseCustomner1 = new EnterpriseCustomer();
        enterpriseCustomner1.setName("CDE集团");
        os.addElement(enterpriseCustomner1);

        PersonalCustomer personalCustomer = new PersonalCustomer();
        personalCustomer.setName("张三");
        os.addElement(personalCustomer);

        //客户提出服务请求，传入服务请求的Visitor
        ServiceRequestVisitor requestVisitor = new ServiceRequestVisitor();
        os.handleRequest(requestVisitor);

        //要对客户进行偏好分析，传入偏好分析的Visitor
        PredilectionAnalyzeVisitor analyzeVisitor = new PredilectionAnalyzeVisitor();
        os.handleRequest(analyzeVisitor);
    }
}
