package top.hengshare.interview.id;

/**
 * DefaultIdentifierGenerator
 *
 * @author yangjh
 */
public class DefaultIdentifierGenerator implements IdentifierGenerator {
	private final Sequence sequence;

	public DefaultIdentifierGenerator() {
		this.sequence = new Sequence();
	}

	@Override
	public long nextId() {
		return sequence.nextId();
	}

	@Override
	public void reSetWorkerId(long workerId) {
		sequence.setWorkerId(workerId);
	}
}
