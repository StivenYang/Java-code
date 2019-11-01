package top.hengshare.interview.pattern.chainOfResposiblity.common;

import lombok.Data;

/**
 * @program: Java-Interview
 * @description: FeeRequestHandler
 * @author: StivenYang
 * @create: 2019-11-01 11:58
 **/
@Data
public class FeeRequestModel extends RequestModel {

    public final  static String FEE_TYPE = "fee";

    public FeeRequestModel() {
        super(FEE_TYPE);
    }

    private String user;

    private double fee;
}
