package com.yeyangshu.controller;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/10/10 6:48
 */
public class HystrixTest extends HystrixCommand {

    /**
     * 降级：
     * try {
     *     1 发起向服务方的请求
     *         1.1 判断连接超时 -> 这次请求，记录到服务器里
     *             http请求，消耗线程
     *             线程隔离：
     *             针对当前URI开线程进行隔离
     *             map(URI, 线程数)
     *             线程池(线程数)
     *
     *             熔断：
     *             计数，连续失败次数，达到阈值，抛出异常
     *             count++
     *             if (count == 10) {
     *                 new romdom  == 1  按时间
     *                 发请求
     *                 throw exception
     *             }
     *             if (当前线程满了) {
     *                 throw exception
     *             }
     *         1.2 尝试向其他服务器发起请求
     *     2 还是没成功
     * } catch (Exception e) {
     *     1 避免返回不友好的错误信息 -> 好看点的页面、重试按钮、联系邮箱
     *     2 return 另外一个东西、写到MQ里、admin发个邮件
     *       return "客户端稍后再来"
     * }
     */

    protected HystrixTest(HystrixCommandGroupKey group) {
        super(group);
    }

    /**
     * 相当于 try 操作
     * @return
     * @throws Exception
     */
    @Override
    protected Object run() throws Exception {
        System.out.println("执行逻辑");
        int i = 1 / 0;
        return "ok";
    }

    /**
     * 相当于 catch 操作，备用方法
     * @return
     */
    @Override
    protected Object getFallback() {
        return "getFallbackGetFallback";
    }

    public static void main(String[] args) {

        /**
         * execute()：以同步阻塞方式执行run()
         * 调用 execute() 后，hystrix 先创建一个新线程运行 run()，
         * 接着调用程序要在 execute() 调用处一直阻塞着，直到 run() 运行完成
         */
        //HystrixTest hystrixTest = new HystrixTest(HystrixCommandGroupKey.Factory.asKey("ext"));
        //System.out.println("result:" + hystrixTest.execute());

        /**
         * queue()方法：以异步非阻塞方式执行 run()
         * 调用 queue() 方法返回一个 Future 对象，Future<R> queue()
         * 同时 hystrix 创建一个新线程运行 run()，调用程序通过 Future.get() 拿到 run() 的返回结果
         * 而 Future.get() 是阻塞执行的
         */
        Future<String> futureResult = new HystrixTest(HystrixCommandGroupKey.Factory.asKey("ext")).queue();
        String result = "";
        try {
            result = futureResult.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("程序结果：" + result);
    }
}