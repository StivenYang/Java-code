package top.hengshare.interview.pattern.abstractFactory.example;

public class Schema1 implements AbstractFactory {
    @Override
    public CpuAPI createCPU() {
        return new IntelCPU(1156);
    }

    @Override
    public MainBoardApi createMainBoard() {
        return new GAMainBoard(1156);
    }
}
