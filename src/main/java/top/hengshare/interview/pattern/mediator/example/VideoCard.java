package top.hengshare.interview.pattern.mediator.example;

public class VideoCard extends Colleague {
    public VideoCard(Mediator mediator) {
        super(mediator);
    }

    public void showData(String data) {
        System.out.println("显卡：" + data);
    }
}
