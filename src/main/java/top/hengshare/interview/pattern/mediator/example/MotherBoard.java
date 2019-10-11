package top.hengshare.interview.pattern.mediator.example;

import lombok.Setter;

@Setter
public class MotherBoard implements Mediator {

    private CPU cpu = null;
    private VideoCard videoCard = null;
    private SoundCard soundCard = null;
    private CDDriver cdDriver = null;

    @Override
    public void changed(Colleague colleague) {
        if (colleague == cdDriver) {
            //表示光驱读取数据了
            CDDriver driver = (CDDriver)colleague;
            String data = driver.getData();
            this.cpu.executeData(data);
        }else if (colleague == cpu){
            //表示cpu处理完了
            CPU cpu = (CPU)colleague;
            String soundData = cpu.getSoundData();
            String videoData = cpu.getVideoData();
            this.soundCard.soundData(soundData);
            this.videoCard.showData(videoData);
        }
    }
}
