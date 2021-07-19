package demo;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author summer
 * @see <a href=""></a><br/>
 */
public class ThreadLocalExample implements Runnable{
    private static final ThreadLocal<SimpleDateFormat> formatter=ThreadLocal.withInitial(
            ()->new SimpleDateFormat("yyyyMMdd HHmm")
    );
    @Override
    public void run() {
        System.out.println("thread name:"+Thread.currentThread().getName());
        System.out.println("default formatter:"+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat());
        System.out.println("thread name:"+Thread.currentThread().getName());
        System.out.println("formatter:"+formatter.get().toPattern());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample=new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(threadLocalExample, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }
}
