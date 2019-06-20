package top.hengshare.interviewer.thread.concurrency.ThreadPoolDemo;

import lombok.Data;

import java.util.concurrent.Callable;

@Data
public class Task implements Callable<Result>{

	private volatile Result result;

	private Object obj;

	private Indexalculation indexalculation;

	@Override
	public Result call() throws Exception {
		result = indexalculation.calculation(obj);
		return result;
	}
}
