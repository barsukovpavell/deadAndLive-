public class DeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(() -> {
            synchronized(lock1) {
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized(lock2) {} // Ждет lock2
            }
        }).start();

        new Thread(() -> {
            synchronized(lock2) {
                synchronized(lock1) {}
            }
        }).start();
    }
}
