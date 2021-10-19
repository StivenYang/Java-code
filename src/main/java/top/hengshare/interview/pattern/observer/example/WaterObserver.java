package top.hengshare.interview.pattern.observer.example;

public interface WaterObserver {
	void update(WaterQualitySubject subject);

	void setJob(String job);

	String getJob();
}
