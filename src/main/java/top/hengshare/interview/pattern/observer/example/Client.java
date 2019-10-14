package top.hengshare.interview.pattern.observer.example;

public class Client {
    public static void main(String[] args) {
        //创建发布者-水质监测部门
        WaterQuality waterQuality = new WaterQuality();

        //创建订阅者-几个部门
        Watcher watcher = new Watcher();
        watcher.setJob("监测人员");

        Watcher watcher1 = new Watcher();
        watcher1.setJob("预警人员");

        Watcher watcher2 = new Watcher();
        watcher2.setJob("监测部门领导");

        waterQuality.attach(watcher);
        waterQuality.attach(watcher1);
        waterQuality.attach(watcher2);

        //填写水质报告
        System.out.println("当水质为正常的时候==========");
        waterQuality.setPolluteLevel(0);
        System.out.println("当水质为轻度污染的时候==========");
        waterQuality.setPolluteLevel(1);
        System.out.println("当水质为重度污染的时候==========");
        waterQuality.setPolluteLevel(2);
    }
}
