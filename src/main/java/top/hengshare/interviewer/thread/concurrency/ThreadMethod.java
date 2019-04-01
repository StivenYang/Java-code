package top.hengshare.interviewer.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/31
 * @description: 在方法内部创建线程
 *
 * 使用场合：当准备好运行线程时，可以调用这个方法，而在线程开始之后，方法将返回。
 * 如果该线程只执行辅助操作，而不是该类的重要操作，那么这与在该类的构造器内部启动
 * 线程相比，可能是一种更加有用而适合的方式。
 */
public class ThreadMethod {
    private final String name;
    private Thread t;
    private int countDown = 5;

    public ThreadMethod(String name){
        this.name = name;
    }

    public void runTask(){
        if (t == null) {
            t = new Thread(name){
                @Override
                public void run(){
                    try {
                        while (true) {
                            System.out.println(this);
                            if (--countDown == 0) {
                                return;
                            }
                            sleep(100);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public String toString(){
                    return "这是线程对象" + getName() + "被" + countDown + "次执行";
                }
            };
            t.start();
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<5; i++) {
            new ThreadMethod(String.valueOf(i)).runTask();
        }
    }
}
