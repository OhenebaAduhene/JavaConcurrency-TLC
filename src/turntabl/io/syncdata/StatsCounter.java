package turntabl.io.syncdata;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class StatsCounter {
    Lock lock = new ReentrantLock();


    private AtomicInteger successCount_  = new AtomicInteger(0);;

//    Using LockSync

//    private volatile int successCount_;

//    public final int getSuccessCount() {
//        return successCount_;
//    }

//    public final void increaseSuccessCount(int delta) {
//        successCount_ += delta;
//    }

//    End of using LockSync


//    AtomicInteger Implementation
    public final void increaseSuccessCount(int delta) {
        successCount_.addAndGet(delta);

    }

    public final int getSuccessCount() {
        return successCount_.get();
    }
//    AtomicInteger ending



//    public final void increaseSuccessCount(int delta) {
//
//        lock.lock();
//        try{
//            successCount_ += delta;
//        }finally {
//            lock.unlock();
//        }
//
//    }

//    public final synchronized void increaseSuccessCount(int delta) {
//
//        successCount_ += delta;
//
//    }
}
