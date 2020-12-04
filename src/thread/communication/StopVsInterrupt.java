package thread.communication;

public class StopVsInterrupt {

    public static void main(String[] args) {
//        stop();
        interrupt();
    }

    private static void interrupt() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_100; i++) {
                    if (isInterrupted()) {
                        return;
                    }
                    System.out.println(i);
                }
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Just to set the interrupt flag
        // 如果要终止线程，可以在线程内部的判断isInterrupted()判断线程状态
        thread.interrupt();
    }

    private static void stop() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_100; i++) {
                    System.out.println(i);
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 强制停止
        thread.stop();
    }
}
