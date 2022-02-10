package top.hengshare.interview.id;

public interface IdentifierGenerator {

	long nextId();

	void reSetWorkerId(long workerId);
}