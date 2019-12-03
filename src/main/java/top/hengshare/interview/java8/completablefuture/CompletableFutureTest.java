package top.hengshare.interview.java8.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @program: Java-Interview
 * @description: CompletableFuture测试类，最佳价格查询器
 *          业务场景是：
 *                  1. 将两个异步计算合并为一个---这两个异步计算之前相互独立，同时第二个又依赖于第一个的结果
 *                  2. 等待Future中的所有任务都完成
 *                  3. 仅等待Future集合中最快结束的任务完成，并返回他的结果
 *                  4. 通过编程方式完成一个Future任务的执行（即以手工设定异步操作结果的方式）
 *                  5. 应对Future的完成事件
 *          可以学到的技能：
 *                  1. 如何给客户提供异步API
 *                  2. 如何让我们使用了同步API的代码变为非阻塞代码。我们会了解如何使用流水线将
 *                      两个接续的异步操作合并为一个异步计算操作。比如：在线商店返回了我们想要购买产品的原始价格，
 *                      并附带着一个折扣代码--最终要计算出来该商品的实际价格，你不得不访问第二个远程折扣服务，查询
 *                      该折扣代码对应的折扣比率。
 *                  3. 如何以响应式的方式处理异步操作的完成事件，以及随着各个商店返回它的商品价格，最佳价格查询器如何持续地更新每种商品的最佳推荐，
 *                      而不是等待所有的商店都返回他们各自的价格（这种方式存在着一定的风险，一旦某家商店的服务中断，用户可能遭遇白屏）
 *
 * @author: StivenYang
 * @create: 2019-12-01 21:42
 **/
public class CompletableFutureTest {
    public static void main(String[] args) {
        Shop shop = new Shop("shop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime()-start)/1_000_000);
        System.out.println("调用返回之后时间：" + invocationTime + "毫秒");

        //执行更多任务，比如查询商店
//        dosomethingElse();
        //在计算商品价格的同时
        try {
            double price = futurePrice.get();
            System.out.printf("价格是： %.2f%n", price);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        long retrievalTime = ((System.nanoTime()-start)/1_000_000);
        System.out.println("价格返回花费了"+ retrievalTime+ "毫秒");
    }
}

/**
 * 没有实现异步的商店
 */
class Shop{
    private String product;

    public Shop(String product) {
        this.product = product;
    }

    //从商店获取商品价格
    public double getPrice(String product){
        //计算商品价格
        return calculatePrice(product);
    }

    //计算价格
    private double calculatePrice(String product) {
        //等待调用服务
        delay();
        //返回一个double
        return new Random().nextDouble()* product.charAt(0)+product.charAt(1);
    }

    //模拟商店查询商品价格的延迟和请求的调用延迟
    public static void delay(){
        try {
            Thread.sleep(1000L);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 优化1：使用异步完成价格获取
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    /**
     * 优化2：捕获future线程中的异常，优化系统的异常处理系统
     * @param product 产品名称
     * @return 未来的价格
     */
    public Future<Double> getPriceAsync2(String product){
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                future.complete(price);
            }catch (Exception e){
                future.completeExceptionally(e);
            }
        }).start();
        return future;
    }

    /**
     * 优化3：使用工厂方法supplyAsync创建CompletableFuture
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync3(String product){
        return CompletableFuture.supplyAsync(()->calculatePrice(product));
    }


}