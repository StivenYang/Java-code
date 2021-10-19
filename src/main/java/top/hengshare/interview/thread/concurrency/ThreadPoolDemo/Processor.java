package top.hengshare.interview.thread.concurrency.ThreadPoolDemo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 处理器接口，
 */
public class Processor {

	void process(Object obj) throws ExecutionException, InterruptedException {
		List<Indexalculation> indexalculations = Factory.getIndexalculations();
		ArrayList<Future<Result>> submitList = Lists.newArrayList();
		Future<Result> submit = null;
		Task task = new Task();
		for (int i = 0; i < indexalculations.size(); i++) {
			task.setIndexalculation(indexalculations.get(i));
			task.setObj(obj);
			//            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 7, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(14));
			ExecutorService exec = Executors.newCachedThreadPool();
			submit = exec.submit(task);
			submitList.add(submit);
		}
		if (submitList.size() < indexalculations.size()) {
			submit.get();
		}
		for (Future<Result> stringFuture : submitList) {
			Result s = stringFuture.get();
			System.out.println(s.getStr());
		}
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Processor processor = new Processor();
		processor.process("123");
	}
}
