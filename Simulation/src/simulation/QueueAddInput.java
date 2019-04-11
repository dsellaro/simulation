 package simulation;

import java.util.Random;
import static simulation.Start.tottask;
 import static simulation.Start.policy;
import static simulation.Start.queues;

/**
 *
 * @author DANI
 * simula a entrada de novas tarefas
 */ 

public class QueueAddInput implements Runnable {
    
    private static int numinputtask;
    
    public QueueAddInput() {
     
        Random rad = new Random(); 
//        numinputtask = rad.nextInt(numinstance) + 1;
        numinputtask = 10;
        tottask = tottask + numinputtask;
        
    }

    public void run() {

        try {
            for (int i = 0; i < numinputtask; i++) {
                //Adiciona "numinstance" tarefas 1 para queues[0] (queuefifo) 
                if ("FIFO".equals(policy)){
                    queues[0].add(1);
                    }
                //Adiciona "numinstance" tarefas 1 para queues[1] (queueRR1)
                else{  
                    queues[1].add(1);   
                    }
            }
        }    
        catch (Exception e) {
    }
    }      
}