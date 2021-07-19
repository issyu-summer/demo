package demo.pool;

import lombok.AllArgsConstructor;

import java.util.Date;

/**
 * @author summer
 * @see <a href=""></a><br/>
 */
@AllArgsConstructor
public class MyRunner implements Runnable{
    private String command;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" start. time="+new Date());
        proceessCommand();
        System.out.println(Thread.currentThread().getName()+" end. time="+new Date());
    }

    @Override
    public String toString() {
        return "MyRunner{" +
                "command='" + command + '\'' +
                '}';
    }

    private void proceessCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
