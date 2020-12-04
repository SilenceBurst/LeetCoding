package thread.sync;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {

    public static void main(String[] args) {
//        thread();
//        runnable();
//        theadFactory();
//        executor();
        callable();
    }

    private static void callable() {
        // 有返回值的runnable
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Done";
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(callable);
        future.isDone(); // call方法执行完毕
        try {
            // 阻塞式
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void executor() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am executor runnable");
            }
        };
//        ThreadPoolExecutor 线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        // 固定线程数
//        ExecutorService executor = Executors.newFixedThreadPool(10);
        // 单线程
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 加延时
//        ExecutorService executor = Executors.newScheduledThreadPool(100);
        // shutdown 当前已提交还未执行的runnable执行完才会结束，后续的提交不会被执行
        // shutdownNow 所有的runnable马上结束 == 调用线程的interrupt()
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
    }

    private static void theadFactory() {
        ThreadFactory threadFactory = new ThreadFactory() {
            private final AtomicInteger count = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread-" + count.incrementAndGet());
            }
        };
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " started!");
            }
        };
        threadFactory.newThread(runnable).start();
        threadFactory.newThread(runnable).start();
    }

    private static void runnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am runnable");
            }
        };
        new Thread(runnable).start();
    }

    private static void thread() {
        // 虚拟机指挥不同平台操作系统的线程执行，不同平台会有不同的实现
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread started!");
            }
        };
        thread.start();
        thread.interrupt();
    }
}
