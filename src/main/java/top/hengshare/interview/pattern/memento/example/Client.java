package top.hengshare.interview.pattern.memento.example;

/**
 * @program: Java-Interview
 * @description: 测试流程
 * @author: Steven Yang
 * @create: 2019-10-18 10:28
 **/
public class Client {
    public static void main(String[] args) {
        //创建模拟流程运行的对象
        FlowAMock flowAMock = new FlowAMock("工作流程A");

        //运行流程的第一个阶段
        flowAMock.runPhaseOne();

        //得到第一个阶段运行所产生的数据
        int tempResult = flowAMock.getTempResult();
        String tempState = flowAMock.getTempState();

        //按照方案一运行之后的流程
        flowAMock.schema1();

        //把运行方案之前的数据设置进去
        flowAMock.setTempResult(tempResult);
        flowAMock.setTempState(tempState);

        //按照方案二运行之后的流程
        flowAMock.schema2();
    }
}
