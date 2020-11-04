package turntabl.io.question1;

import static java.lang.Thread.interrupted;

public class CancelWithInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread hello = new Thread(() -> {
            while (!interrupted()) {
                try {
                    System.out.println("Hello");
                    Thread.sleep(1000);

                } catch (InterruptedException ignore){
                    System.out.println("Program interrupted");
                    return;
                }
            }
        });

        hello.start();
        Thread.sleep(5000);
        hello.interrupt();
    }
}
