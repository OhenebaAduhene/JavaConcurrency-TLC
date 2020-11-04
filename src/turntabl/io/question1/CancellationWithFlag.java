package turntabl.io.question1;

import java.util.concurrent.atomic.AtomicBoolean;

public class CancellationWithFlag {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean cancel = new AtomicBoolean(true);
        Thread hello = new Thread(() -> {
            while (cancel.get()) {

                try {
                    System.out.println("Hello");
                    Thread.sleep(1000);

                } catch (InterruptedException ignore){}
            }
        });

        hello.start();
        Thread.sleep(5000);
        cancel.set(false);
    }
}
