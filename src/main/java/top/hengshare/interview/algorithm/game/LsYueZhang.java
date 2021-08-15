package top.hengshare.interview.algorithm.game;

import cn.hutool.core.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 乱世乐章点击逻辑
 *
 * @author yangjh
 **/
public class LsYueZhang {
    private static int[][] arr = new int[4][4];
    private static Map<Integer, String> map = new HashMap<>(32);

    public static void fillArray() {
        int[] temp = ArrayUtil.range(0, 8, 1);
        int[] result = ArrayUtil.addAll(temp, temp);
        int step = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = result[step++];
            }
        }
    }

    public static void doFindPic() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (map.containsKey(arr[i][j])) {
                    System.out.println("(" + i + ", " + j + ") 找到配对的了: " + map.get(arr[i][j]));
                    //点击value
                } else {
                    //前面没有配对的，那就先放到map里面
                    map.put(arr[i][j], "(" + i + ", " + j + ")");
                    System.out.println("(" + i + ", " + j + ")没有找到配对");
                }
            }
        }
    }

    public static void main(String[] args) {
        fillArray();

        doFindPic();
    }
}
