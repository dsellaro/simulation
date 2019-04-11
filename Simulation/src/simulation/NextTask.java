package simulation;

import java.util.Random;
import static simulation.ProfileIntegrationProcess.VetorNextTask;
import static simulation.ProfileIntegrationProcess.VetorOper;
import static simulation.QueueAdd.queueadd;
import static simulation.ScheduledInputTask.scheduledinputtask;
import static simulation.Start.execrandom;
import static simulation.Start.numtask;

/**
 *
 * @author DANI
 * gera tarefa para a fila de prox nivel de tarefa(maior que nivel atual)
 * o nivel corresponde a quantidade de tarefas no maior caminho de tarefas predecessoras
 */
public class NextTask {
    public static void nexttask(int task) {  
        
        Random r = new Random();
        int nexttask; //proxima tarefa a ser executada
        
        //gera indicação da prox tarefa aleatoriamente
        if (execrandom){
            int range;
            int maximum = numtask;
            int minimum; 
            
            minimum = task + 1;
            range = maximum - minimum + 1;
            nexttask = r.nextInt(range) + minimum; 
            scheduledinputtask(nexttask);
        }
        //gera indicação da prox tarefa conforme profile configurado para o processo de integracao 
        else{

            int rad;
            rad = 1;
            String oper_rad;
            int operleng;
            int t;
            
            t = task -1;
            operleng = VetorOper[t].length;

            switch (operleng){
                case 0 : // tarefa simples
                {
                    nexttask = VetorNextTask[t][0];
                    queueadd(nexttask);
                    scheduledinputtask(nexttask);
                    break;
                }
                case 1: case 2 : // tarefa fork que pode ser {{"and"},{"or"},{"and","or"}}
                {
                    if (operleng == 2){// tarefa fork ={"and","or"}
                        rad = r.nextInt(1);
                        oper_rad = VetorOper[t][rad];// sorteia um dos valores: "and" ou "or"
                    }
                    else {
                        oper_rad = VetorOper[t][0];// pode apenas um dos valores: "and" ou "or"
                    }
                    if ("or".equals(oper_rad)) {// tarefa fork ={"or"}

                        nexttask = r.nextInt(VetorNextTask[t].length);
                        queueadd(nexttask);
                        scheduledinputtask(nexttask);
                    } 
                    else {
                        if ("and".equals(oper_rad)) {// tarefa fork ={"and"}
                            for (int i = 1; i < VetorNextTask[t].length; i++){
                                nexttask = VetorNextTask[t][i];
                                queueadd(nexttask);
                                scheduledinputtask(nexttask);
                            }    
                        } 
                    }
                    break; 
                }    
            }
        }
    }
}