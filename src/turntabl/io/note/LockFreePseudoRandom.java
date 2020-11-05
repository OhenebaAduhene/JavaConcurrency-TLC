package turntabl.io.note;

import java.util.concurrent.atomic.AtomicInteger;

public class LockFreePseudoRandom {
    private AtomicInteger seed;

    public LockFreePseudoRandom(int seed) {
        this.seed = new AtomicInteger(seed);
    }

    public static void main(String[] args) {
        LockFreePseudoRandom random =  new LockFreePseudoRandom(50);
        System.out.println(random.nextInt(20));
    }

    public int nextInt(int n){
        while (true){
            int s = seed.get();
            System.out.println("s: "+s);
            int nextSeed = calculateNext(s);

            if(seed.compareAndSet(s, nextSeed)){
                int remainder =  s % n;
                return remainder > 0 ? remainder : remainder + n;
            }
        }
    }

    private static int calculateNext(int s) {
        int sum  = 0;
        sum += s;
        return sum;
    }

}
