public class LiveLock {
    static boolean active = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while(active) {
                System.out.println("Flow 1");
                try { Thread.sleep(100); } catch (Exception e) {}
            }
        }).start();

        new Thread(() -> {
            while(active) {
                System.out.println("Flow 2");
                try { Thread.sleep(100); } catch (Exception e) {}
            }
        }).start();
    }
}
