package top.hengshare.interview.id;

public class HSIdWorker {

	private HSIdWorker() {
	}

	private static final IdentifierGenerator IDENTIFIER_GENERATOR = new DefaultIdentifierGenerator();

	/**
	 * 获取唯一ID
	 * @return id
	 */
	public static long getId() {
		return IDENTIFIER_GENERATOR.nextId();
	}

	public static void reSetWorkerId(long workerId) {
		IDENTIFIER_GENERATOR.reSetWorkerId(workerId);
	}

}