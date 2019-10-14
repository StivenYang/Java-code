package top.hengshare.interview.pattern.observer.example;

public class Watcher implements WaterObserver {

    private String job;

    @Override
    public void update(WaterQualitySubject subject) {
        System.out.println(job + "获取到通知，当前污染级别为：" + subject.getPolluteLevel());
    }

    @Override
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String getJob() {
        return this.job;
    }
}
