package simulation;

import static simulation.Start.queues;
import static simulation.AllocateThread.allocatethread;
import static simulation.Start.duration;
import static simulation.Start.maxduration;
import static simulation.Start.start;
import static simulation.Start.tasksrem;
/**
 *
 * @author DANI
 * aplica politica Fifo
 */
public class Fifo {
    
    public static void fifo() throws InterruptedException {
        
        int totsize = queues[0].size();
        
        while (totsize>0 && duration<maxduration){
            
            if (!queues[0].isEmpty()) {

                allocatethread(queues[0], totsize);
            }
            
            totsize = queues[0].size();
            duration = System.nanoTime() - start;   
        }   
        tasksrem = totsize;
    }
}

