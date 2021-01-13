package top.hengshare.interview.constant;

/**
 * 配置修改枚举常量
 *
 * @author yjh
 * @since 2021/1/13 12:27 下午
 **/
public enum LogActionEnum {

    /**
     * 默认动作
     */
    DEFAULT_ACTION(0, "默认动作"),

    /**
     * 机器人相关
     */
    ROBOT_ADD(100, "新增机器人配置"),
    ROBOT_DELETE(101, "删除机器人配置"),
    ROBOT_UPDATE(102, "修改机器人配置"),

    /**
     * 产品配置相关
     */
    PRODUCTION_CONFIG_ADD(200, "新增产品配置"),
    PRODUCTION_CONFIG_DELETE(201, "删除产品配置"),
    PRODUCTION_CONFIG_UPDATE(202, "更新产品配置"),

    /**
     * 字典相关
     */
    DICTIONARY_ADD(300, "新增字典"),
    DICTIONARY_DELETE(301, "删除字典"),
    DICTIONARY_UPDATE(302, "更新字典");

    /**
     * 动作码
     */
    private Integer actionCode;

    /**
     * 动作描述
     */
    private String actionDescription;

    LogActionEnum(Integer actionCode, String actionDescription) {
        this.actionCode = actionCode;
        this.actionDescription = actionDescription;
    }

    public Integer getActionCode() {
        return actionCode;
    }

    public void setActionCode(Integer actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }
}
