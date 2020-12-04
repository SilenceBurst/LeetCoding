package thread.sync;

public class SyncTest {

    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        new Thread(syncTest::test1).start();
        new Thread(syncTest::test2).start();
    }

    private void test1() {
        synchronized (monitor1) {
            try {
                System.out.println("test1");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void test2() {
        synchronized (monitor2) {
            try {
                System.out.println("test2");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
