package simulation;

import java.util.Random;
import static simulation.ProfileIntegrationProcess.VetorTimeExec;
import static simulation.Start.execrandom;
import static simulation.Start.texec;
import static simulation.AllocateThread.ptask;

/**
 *
 * @author DANI
 * simula a operacao da tarefa, esperando o tempo de execucao variavel
 */

public class Operation implements Runnable {
    
    private static int time;

    public Operation() {
        int t;
        Random rad = new Random(); //Simula execução da tarefa com tempo de execução variavel
         
        t = ptask -1;
         
        if (execrandom){ //execucao randomica
        //gera tempo de execução da tarefa aleatoriamente          
            time = rad.nextInt(texec) + 1;
            //t = 1;
        }
        //gera tempo de execução da tarefa conforme profile
        else{
            time = rad.nextInt(VetorTimeExec[t].length);
        }
    }

    public void run() {
        //simula a execução que dura t
        try {
            sleep(time);
            }
            catch (Exception e) {
            }
    }
        
    private void sleep(int time) {
       
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}