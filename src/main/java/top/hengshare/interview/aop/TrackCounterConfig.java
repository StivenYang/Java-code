package top.hengshare.interview.aop;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("sgt.的人们孤单的心俱乐部摇滚");
        cd.setArtist("The beatles披头士乐队");
        ArrayList<String> tracks = Lists.newArrayList();
        tracks.add("描述1");
        tracks.add("描述2");
        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}

@Aspect
class TrackCounter {
    private Map<Integer, Integer> trackCounts = Maps.newHashMap();

    @Pointcut(value = "execution(* top.hengshare.interview.aop.CompactDisc.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber) {
    }

    @Before(value = "trackPlayed(trackNumber)", argNames = "trackNumber")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }
}

@Data
class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

    @Override
    public void playTrack(int number) {
        System.out.println("正在播放第" + number + "首歌曲");
    }
}

interface CompactDisc {
    void playTrack(int number);
}