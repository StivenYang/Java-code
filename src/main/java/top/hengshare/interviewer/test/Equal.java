package top.hengshare.interviewer.test;

public class Equal {
    private long width;

    public Equal(long width) {
        this.width = width;
    }

    public static void main(String[] args) {
        Equal a, b, c;
        a = new Equal(42L);
        b = new Equal(42L);
        c = b;
        long s = 42L;

        System.out.println(a==b);
//        System.out.println(s==a);
        System.out.println(b==c);
        System.out.println(a.equals(s));
    }
}
