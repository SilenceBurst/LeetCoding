package thread.communication;

public class WaitTest {

    private String test;
    private final Object monitor = new Object();

    private void printString() {
        synchronized (monitor) {
            System.out.println("printString");
            if (test == null) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(test);
        }
    }

    private void initString() {
        synchronized (monitor) {
            test = "hello wait&notify";
            monitor.notifyAll();
        }
    }

    public static void main(String[] args) {
        WaitTest waitTest = new WaitTest();
        Thread printThread1 = new Thread() {
            @Override
            public void run() {
                waitTest.printString();
            }
        };
        Thread printThread2 = new Thread() {
            @Override
            public void run() {
                waitTest.printString();
            }
        };
        Thread initThread = new Thread() {
            @Override
            public void run() {
                waitTest.initString();
            }
        };
        printThread1.start();
        printThread2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        initThread.start();
    }
}
