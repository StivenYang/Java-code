package top.hengshare.interview.pattern.abstractFactory.example;

public class IntelCPU implements CpuAPI {

    private int pins = 0;

    public IntelCPU(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("现在使用的是Intel的CPU，针脚数是： " + pins);
    }
}
