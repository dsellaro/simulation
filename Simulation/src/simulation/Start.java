package simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import static simulation.Fifo.fifo;
import static simulation.RoundRobin.roundrobin;
import static simulation.GravarArquivo.GravarArquivo;
import static simulation.ProfileIntegrationProcess.NumTasks;

/**
 *
 * @author DANI simula execucao de processo de integracao com politica fifo,
 * round robin e round robin com preempcao
 */
public class Start {

    public static boolean execrandom = false;//true para aleatorio / false para processo de integracao do profile
    public static int numtask = NumTasks;
    public static int numinstance = 1000;
    public static int texec = 1;
    public static int preemptask = 0;
    public static double maxduration = 12E10;
    public static double makespan = 0;
    public static Random gerador = new Random();
    public static double start;
    public static double end;
    public static double duration;
    public static double totmakespan = 0;
    public static double avgmakespan = 0;
    public static int messproc = 0;
    public static int tasksrem = 0;
    public static int tottask = numinstance;

//    public static String policy = "FIFO";// usa Fifo
    public static String policy = "RR";//usa RR
//    public static String policy = "RRp";//usa RR com preempcao

    public static final Queue<Integer>[] queues = new Queue[numtask + 1];

    static StringBuilder simulationText = new StringBuilder();
    

    public static void main(String args[]) throws InterruptedException {

        String simulationFile = "Simulation.txt";

        int cont = 0;

        //Executa 25 simulacoes       
        while (cont < 25) {

            //Criando uma fila por tarefa
            for (int i = 0; i <= numtask; i++) {
                queues[i] = new LinkedList<>();
            }

            System.out.println("\n*Input tasks...");
            

            //Adiciona "numinstance" tarefas 1 to queues[0] (queuefifo) e queues[1] (queueRR1)
            for (int i = 0; i < numinstance; i++) {
                //Adiciona "numinstance" tarefas 1 para queues[0] (queuefifo) 
                if ("FIFO".equals(policy)) {
                    queues[0].add(1);
                } //Adiciona "numinstance" tarefas 1 para queues[1] (queueRR1)
                else {
                    queues[1].add(1);
                }
            }
            
            System.out.println("\n*Start Simulation " + policy + " " + (cont + 1) + " ...");
            start = System.nanoTime();
            
            switch (policy) {
                case "FIFO": {
                    simulationFile = "SimulationFIFO.txt";
                    fifo();
                    break;
                }
                case "RR": {
                    simulationFile = "SimulationRR.txt";
                    roundrobin();
                    break;
                }
                case "RRp": {
                    simulationFile = "SimulationRRpreemp.txt";
                    preemptask = 1000;
                    roundrobin();
                    break;
                }
            }

            cont++;

            System.out.println("\n*End Simulation*\n");

            if (messproc > 0) {
                avgmakespan = totmakespan / messproc;
            }

            
            System.out.println("Total message processed = " + messproc);
            System.out.println("Total remaining tasks = " + tasksrem);
            System.out.println("makespan(s) = " + avgmakespan);

            simulationText.append(messproc).append(" ").append(tasksrem).append(" ").append(totmakespan).append("\n");    
            GravarArquivo(simulationFile, simulationText.toString());
            
            avgmakespan = 0; totmakespan = 0; messproc = 0; tasksrem = 0; duration = 0;
        }
    }
}
