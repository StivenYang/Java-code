package top.hengshare.interview.pattern.state.struct;

/**
 * @program: Java-Interview
 * @description: 状态机
 * @author: Steven Yang
 * @create: 2019-10-16 13:59
 **/
public interface State {
    /**
     * 根据传入的不同参数进行不同的处理
     * @param sampleParameter 实例参数
     */
    void handle(String sampleParameter);
}
