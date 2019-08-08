package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.Callable;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/21
 * @description: 带有返回值的任务对象，实现callable接口
 */
public class TaskWithResult implements Callable {

    private int id;

    public TaskWithResult() {
    }

    public TaskWithResult(int id) {
        this.id = id;
    }

    public Object call() throws Exception {
        return id + "的返回结果。";
    }
}
