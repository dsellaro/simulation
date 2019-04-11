package simulation;

import static simulation.ProfileIntegrationProcess.VetorParallelTask;
import static simulation.Start.policy;
import static simulation.Start.queues;

/**
 *
 * @author DANI
 * Adiciona tarefas nas filas
*/

public class QueueAdd  {
    
    private static int p;
    private static int t;
    
    public static void queueadd(int task) {      
        t = task;


        if ("FIFO".equals(policy)){
              queues[0].add(t);
                }
        //Adiciona "numinstance" tarefas para queues[1] (queueRR1)
        else{    
            //Verifica se a tarefa eh paralela
            if (VetorParallelTask[t-1] != 0){
                p = VetorParallelTask[t-1];
                queues[p].add(t);
                }
            else{
                queues[t].add(t);   
            }
        }    
    }  
}
