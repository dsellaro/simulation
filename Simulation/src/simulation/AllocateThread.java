package simulation;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static simulation.NextTask.nexttask;
import static simulation.ProfileIntegrationProcess.LastTask;
import static simulation.Start.makespan;
import static simulation.Start.totmakespan;
import static simulation.Start.end;
import static simulation.Start.messproc;
import static simulation.Start.preemptask;
import static simulation.Start.start;

/**
 *
 * @author DANI
 * Executa tarefa da fila e gera a prox tarefa
 */
public class AllocateThread {
    
    public static int ptask; 
    
    public static void allocatethread(Queue<Integer> q, int preemp){
    
        ExecutorService executor = Executors.newCachedThreadPool(new MyThreadFactory());
        
        int task ; 
        int lasttask;
      
        for(int i = 1; i <= preemp; i++){
//            System.out.println("INI resta:"+queues[0].size());

            if (q.peek() != null){
                task = q.peek();
                ptask = task;//enviada para Operation

                Runnable runnable = () -> {
                    executor.submit(new Operation());
                    };     
            
                for(int j = 0; j < LastTask.length; j++){//ate a ultima tarefa do processo de integracao

                    lasttask = LastTask[j];

                    if (task != lasttask){  //se nao for a ultima tarefa, gera indicação da prox tarefa
//                        System.out.println(q);
                        nexttask(task);
                        } 
                    else{
                        messproc = messproc + 1;  //mensagens processaadas
                        end = System.nanoTime();
                        makespan = end - start;
                        totmakespan = totmakespan + makespan;
//                        System.out.println("procs:" + messproc + " "+ "resta:"+queues[0].size());
                        }  
                }   
                
                task = q.remove();     
                
                executor.shutdownNow();
            }  
            if (preemptask == 0 || q.size() < preemp){
                preemp = q.size();
                }
            else{
                preemp = preemptask;
                }
        }    
    }
}    
