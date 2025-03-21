package singleton;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;

    public String value;
    private ThreadSafeSingleton(String value){
        try {
             Thread.sleep(1000);
             this.value = value;
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static synchronized ThreadSafeSingleton getInstance(String value){
        if(instance == null){
            instance = new ThreadSafeSingleton(value);
        }
        return instance;
    }
}
