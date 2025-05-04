public class DeadLock {
    public static void main(String[] args) {
        Object lockUp1 = new Object();
        Object lockUp2 = new Object();

        new Thread(() -> {
            synchronized(lockUp1) {
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized(lockUp2) {}
            }
        }).start();

        new Thread(() -> {
            synchronized(lockUp2) {
                synchronized(lockUp1) {}
            }
        }).start();
    }
}
