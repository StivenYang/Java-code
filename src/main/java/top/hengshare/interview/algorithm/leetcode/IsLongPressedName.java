package top.hengshare.interview.algorithm.leetcode;

/**
 * P925 长按键入
 *
 * @author v_yangjiaheng_dxm
 * @since  2020/10/21 6:02 下午
 **/
public class IsLongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
