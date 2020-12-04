package thread.sync;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {

    private int count = 1;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private void set() {
        try {
            writeLock.lock();
            System.out.println("set");
            count++;
            System.out.println(count);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    private void get() {
        try {
            readLock.lock();
            System.out.println("get");
            System.out.println(count);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread(lockTest::get).start();
        new Thread(lockTest::get).start();
    }
}
