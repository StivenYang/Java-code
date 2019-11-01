package top.hengshare.interview.pattern.chainOfResposiblity.common;

/**
 * @program: Java-Interview
 * @description: ProjectManager2
 * @author: StivenYang
 * @create: 2019-11-01 15:38
 **/
public class GeneralManager2 extends GeneralManager {
    @Override
    public Object handleRequest(RequestModel requestModel) {
        if (PreFeeRequestModel.FEE_TYPE.equals(requestModel.getType())) {
            return myHandler(requestModel);
        }else {
            return super.handleRequest(requestModel);
        }
    }

    private Object myHandler(RequestModel requestModel) {
        PreFeeRequestModel pfrm = (PreFeeRequestModel)requestModel;
        if (pfrm.getFee() >= 10000) {
            System.out.println("总经理同意"+pfrm.getUser()+"预支差旅费"+pfrm.getFee());
            return true;
        }else {
            if (this.successor != null) {
                return this.successor.handleRequest(requestModel);
            }
        }
        return false;
    }
}
