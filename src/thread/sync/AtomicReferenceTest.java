package thread.sync;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    static class Test {

    }

    public static void main(String[] args) {
        Test test = new Test();
        AtomicReference<Test> atomicReference = new AtomicReference<>();
        atomicReference.set(test);
        Test test1 = atomicReference.get();
    }
}
