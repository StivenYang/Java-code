package top.hengshare.interview.pattern.state.workFlow2;

import lombok.Data;

/**
 * @program: Java-Interview
 * @description: 请假单的模型
 * @author: Steven Yang
 * @create: 2019-10-17 21:25
 **/
@Data
public class LeaveRequestModel {

    /**
     * 请假人
     */
    private String user;

    /**
     * 请假开始时间
     */
    private String beginDate;

    /**
     * 请假时长
     */
    private int leaveDays;

    /**
     * 审核结果
     */
    private String result;
}
