package top.hengshare.interview.pattern.adapter.used;

public class AdapterClient {
    public static void main(String[] args) {
        Adapee adapee = new Adapee();
        Target adapter = new Adapter(adapee);
        adapter.request();
    }
}
