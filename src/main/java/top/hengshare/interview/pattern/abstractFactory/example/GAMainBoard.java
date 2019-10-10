package top.hengshare.interview.pattern.abstractFactory.example;

public class GAMainBoard implements MainBoardApi {

    private int cpuHoles = 0;

    public GAMainBoard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("现在使用的是技嘉主板，针脚数是：" + cpuHoles);
    }
}
