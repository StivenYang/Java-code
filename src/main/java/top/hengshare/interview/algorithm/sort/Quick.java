package top.hengshare.interview.algorithm.sort;

import java.util.Arrays;

/**
 * Quick 快速排序
 *
 * @author yangjiaheng
 * @date 2020/7/10 1:52 下午
 **/
public class Quick {
    public static int[] arr = {1, 3, 5, 2, 11, 23, 34, 31, 12, 11};
    public static int count = 0;

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int i, j, x;
            i = left;
            j = right;
            x = arr[i];
            while (i < j) {
                //有一个左值针和右指针，如果左值针和右指针没有重合
                while (i < j && arr[j] > x) {
                    //如果左值针和右指针没有重合，且右指针指向的元素大于左指针指向的元素，
                    // 让右指针往左移，直到碰见右指针指向的元素小于或者等于左值针的元素
                    j--;
                }
                if (i < j) {
                    //如果左值针和右指针没有重合，就让右指针指向的元素的值赋给左指针指向的元素，并将左值针向右移动一位
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < x) {
                    //如果左值针和右指针没有重合，且左值针指向的元素小于左值针指向的元素，将左值针右移一位
                    i++;
                }
                if (i < j) {
                    //如果本轮还没完，就将右指针左移一位，并交换左右指针指向的值
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }
    }

    public static void main(String[] args) {
        sort1(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort1(int[] arr, int left, int right) {
        if (left < right) {
            //左指针，右指针，选择的比较因子
            int leftPointer, rightPointer, factor;
            leftPointer = left;
            rightPointer = right;
            //选左边元素作为比较因子
            factor = arr[leftPointer];
            //当左右指针没有重合的时候
            while (leftPointer < rightPointer) {
                //当左右指针没有重合，且右指针指向元素大于比较因子
                while (leftPointer < rightPointer && arr[rightPointer] > factor) {
                    //将右指针向最左移动一次
                    rightPointer--;
                }
                //当左右指针重合或者右指针指向元素小于比较因子的时候
                if ((leftPointer < rightPointer)) {
                    //将右指针指向的元素的值赋值给此时的左指针指向的元素
                    //这里不要误解数组值会被覆盖，此时被赋值的元素其实是比较因子，所以不会造成数据的丢失
                    arr[leftPointer++] = arr[rightPointer];
                }
                //经过上面两个步骤后，右边比比较因子小的数被置换到了左边
                //继续判断，此时左右指针未重合，且左指针指向的元素比比较因子小的时候，让左指针向右移动一次
                while (leftPointer < rightPointer && arr[leftPointer] < factor) {
                    leftPointer++;
                }
                //将左指针指向的比比较因子大的数放到右边
                if (leftPointer < rightPointer) {
                    arr[rightPointer--] = arr[leftPointer];
                }
                //经过此步骤之后，左边放的是比比较因子小的数，右边放的全部是大于比较因子的数
                //这时候就可以把取出来的比较因子重新放回到数组里面了
                //此时的数组是按照比较因子分隔的
                arr[leftPointer] = factor;
                //继续递归数组左边比比较因子小的部分，直到左指针和右指针重合，也就是左指针和右指针重合的时候
                sort1(arr, left, leftPointer - 1);
                //同上
                sort1(arr, leftPointer + 1, right);
            }
        }
    }
}
