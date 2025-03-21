package singleton;

public class TestSingleTon {
    public static void main(String[] args) {
//        System.out.println("hello world");
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread3());

        thread1.start();
        thread2.start();
        thread3.start();


    }

    static class Thread1 implements Runnable{

        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("1111");
            System.out.println(singleton.hashCode()+"--"+singleton.value);
        }
    }
    static class Thread2 implements Runnable{

        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("2222");
            System.out.println(singleton.hashCode()+"--"+singleton.value);
        }
    }
    static class Thread3 implements Runnable{

        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("3333");
            System.out.println(singleton.hashCode()+"--"+singleton.value);
        }
    }
}
