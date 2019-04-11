package simulation;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author DANI
 * classe thread
 */

public class MyThreadFactory implements ThreadFactory {

    //public static int count = 1;
        
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        return t;              
    }
    
        
}
