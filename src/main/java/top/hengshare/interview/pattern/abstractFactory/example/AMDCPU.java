package top.hengshare.interview.pattern.abstractFactory.example;

public class AMDCPU implements CpuAPI {

    private int pins;

    public AMDCPU(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("现在使用的是AMD的CPU，针脚数是：" + pins);
    }
}
