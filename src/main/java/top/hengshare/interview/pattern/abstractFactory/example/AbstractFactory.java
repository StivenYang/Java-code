package top.hengshare.interview.pattern.abstractFactory.example;

public interface AbstractFactory {
    CpuAPI createCPU();
    MainBoardApi createMainBoard();
}
