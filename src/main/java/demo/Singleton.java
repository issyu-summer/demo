package demo;

/**
 * @author summer
 * @see <a href=""></a><br/>
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {

    }

    private Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
