package top.hengshare.interview.netty;

public class Worker {

    public void doWork() {
        MyFetcher myFetcher = new MyFetcher(new Data(1, 1));
        myFetcher.fetchData(new FetchCallBack() {
            @Override
            public void onData(Data data) throws Exception {
                System.out.println("接收到数据：" + data);
            }

            @Override
            public void onError(Throwable cause) {
                System.out.println("错误发生于：" + cause.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.doWork();
    }
}

interface Fetcher {
    void fetchData(FetchCallBack callback);
}

class MyFetcher implements Fetcher {

    final Data data;

    public MyFetcher(Data data) {
        this.data = data;
    }

    @Override
    public void fetchData(FetchCallBack callback) {
        try {
            callback.onData(data);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}

interface FetchCallBack {
    void onData(Data data) throws Exception;

    void onError(Throwable cause);
}

class Data {
    private int n;
    private int m;

    public Data(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public String toString() {
        int r = n / m;
        return n + "/" + m + "=" + r;
    }
}