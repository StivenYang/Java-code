package top.hengshare.interview.pattern.prototype.prototypeManager;

public interface Prototype {
	Prototype clone();

	String getName();

	void setName(String name);
}
