package top.hengshare.interview.pattern.state.workFlow;

import lombok.Data;
import lombok.Getter;

/**
 * @program: Java-Interview
 * @description: 请假流程的状态机
 * @author: Steven Yang
 * @create: 2019-10-17 21:19
 **/
@Data
public class StateMachine {

    /**
     * 当前审批的状态
     */
    private State state;

    /**
     * 包含流程处理需要的业务数据对象
     */
    private Object businessVO;

    public void doWork(){
        //转调相应的状态对象完成真正的功能处理
        this.state.doWork(this);
    }
}
