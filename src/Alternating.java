public class Alternating {
    static boolean turn = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while(true) {
                if(turn) {
                    System.out.println("I");
                    turn = false;
                }
            }
        }).start();

        new Thread(() -> {
            while(true) {
                if(!turn) {
                    System.out.println("II");
                    turn = true;
                }
            }
        }).start();
    }
}
