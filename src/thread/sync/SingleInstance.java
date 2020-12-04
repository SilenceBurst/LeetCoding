package thread.sync;

public class SingleInstance {
    private static volatile SingleInstance INSTANCE;

    private SingleInstance() {}

    public static SingleInstance getInstance() {
        if (INSTANCE == null) {
            synchronized (SingleInstance.class){
                if (INSTANCE == null) {
                    INSTANCE = new SingleInstance();
                }
            }
        }
        return INSTANCE;
    }
}
