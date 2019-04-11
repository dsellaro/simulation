package simulation;

import static simulation.AllocateThread.allocatethread;
import static simulation.Start.numtask;
import static simulation.Start.preemptask;
import static simulation.Start.queues;
import static simulation.Start.duration;
import static simulation.Start.maxduration;
import static simulation.Start.start;
import static simulation.Start.tasksrem;


/**
 *
 * @author DANI
 * aplica politica RR «COM» preempcao
 */

public class RoundRobin {
    public static void roundrobin() throws InterruptedException {
        int totsize = 1;//tamanho total das filas
        int preemp = preemptask;
                
        while (totsize>0 && duration<maxduration){
            for(int i = 1; i <= numtask; i++){
                if (!queues[i].isEmpty()) {
                          
                    if (preemp == 0 || queues[i].size() < preemp){
                            preemp = queues[i].size();
                        }
                    else{
                        preemp = preemptask;
                        }
                    allocatethread(queues[i],preemp);
                }    
            } 
            
            totsize = 0;
            
            for(int j = 1; j <= numtask; j++){
                totsize =  totsize + queues[j].size();
            } 
            
            tasksrem = totsize;
            duration = System.nanoTime() - start;    
        }    
    }
}

