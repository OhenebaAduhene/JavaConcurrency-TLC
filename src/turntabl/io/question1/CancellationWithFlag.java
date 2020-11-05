package turntabl.io.question1;

import java.util.concurrent.atomic.AtomicBoolean;

public class CancellationWithFlag {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean cancel = new AtomicBoolean(false);
        Thread hello = new Thread(() -> {
            while (cancel.get() == false) {

                try {
                    System.out.println("Hello");
                    Thread.sleep(1000);

                } catch (InterruptedException ignore){
                    System.err.println("task interrupted");
                }
            }
        });

        hello.start();
        Thread.sleep(5000);
        cancel.set(true);
    }
}
