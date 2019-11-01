package top.hengshare.interview.pattern.chainOfResposiblity.example2;

import lombok.Setter;

/**
 * @program: Java-Interview
 * @description: Handler
 * @author: StivenYang
 * @create: 2019-11-01 09:04
 **/
public abstract class Handler {

    @Setter
    protected Handler successor;

    public abstract String handleFeeRequest(String user, double fee);

    public abstract boolean handlePreRequest(String user, double fee);
}
