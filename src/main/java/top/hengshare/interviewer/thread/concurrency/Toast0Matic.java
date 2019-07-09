package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author StivenYang
 * @program interview
 * @description 吐司的协作生产-使用队列
 * @date 2019-07-09 19:13
 **/
public class Toast0Matic {
}

class Toast {
    /**
     * 制作状态：制作、抹油、涂果酱
     */
    public enum Status {
        /**
         * 吐司制作
         */
        DRY,
        /**
         * 给吐司抹黄油
         */
        BUTTERED,
        /**
         * 吐司涂果酱
         */
        JAMMED
    }
    //当前状态

    //标识id

    //构造函数

    //摸黄油

    //涂果酱

    //获取当前状态

    //获取标识

    //toString重载
}

/**
 * 吐司队列
 */
class ToastQueue extends LinkedBlockingDeque<Toast> {
}

/**
 * 吐司机-制作吐司（消费者）
 */
class Toaster implements Runnable {
    //吐司队列
    private ToastQueue toastQueue;
    //计数器

    //随机数

    //构造函数

    @Override
    public void run() {

    }
}

/**
 * 抹黄油机-（消费者）
 */
class Butterer implements Runnable {
    //吐司制作队列,抹黄油吐司队列


    @Override
    public void run() {

    }
}

/**
 * 涂果酱机-（消费者）
 */
class Jammer implements Runnable {
    //吐司制作队列、摸黄油队列、涂果酱队列

    //构造函数

    @Override
    public void run() {

    }
}

/**
 * 吃食
 */
class Eater implements Runnable {


    @Override
    public void run() {

    }
}
