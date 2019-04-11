/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author DANI
 */
public class ScheduledInputTask {
    
    public static void scheduledinputtask(int task)
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        QueueAddInput queueinput1 = new QueueAddInput ();
             
//        ScheduledFuture<?> result = executor.scheduleAtFixedRate(queueinput1, 1, 10, TimeUnit.SECONDS);
        executor.schedule(queueinput1, (long) 1, TimeUnit.MILLISECONDS);

        try { 
            TimeUnit.NANOSECONDS.sleep(1);
        }
        catch (InterruptedException e) {
        }
         
        executor.shutdownNow();
    }
}
