package top.hengshare.interview.pattern.command.logCommand;

import java.io.Serializable;

public class ChopCommand implements Command, Serializable {

    private CookAPI cookAPI;

    private int tblNum;

    public ChopCommand(int tblNum) {
        this.tblNum = tblNum;
    }

    @Override
    public void execute() {
        cookAPI.cook(tblNum, "绿豆排骨煲");
    }

    @Override
    public void setCookAPI(CookAPI cookAPI) {
        this.cookAPI = cookAPI;
    }

    @Override
    public int getTblNum() {
        return tblNum;
    }
}
