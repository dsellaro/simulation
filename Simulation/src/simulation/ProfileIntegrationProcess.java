package simulation;

/**
 *
 * @author DANI
 * Guarda as regras do processo de execucao usado na simulacao
 */

public class ProfileIntegrationProcess {
//    public static void profile    { 
        // Para Coffee Shop Integration Process 
        
        //identificacao das tarefas do processo de integracao
        public static int VectorIdTask [] = {1,2,3,4,5,6,4,8,9,10,11,12,13,14,15,16};
        //identificacao da PROXIMA tarefa de cada tarefa do processo de integracao
        public static int VetorNextTask [][] = {{2},{3},{4,12},{5,7},{6},{7},{8},{9},{10},{11},{},{13,15},{14},{15},{16},{9}};
        //identificacao do intervalo de variacao do tempo de execucao de cada tarefa do processo de integracao
        public static int VetorTimeExec [][] = {{1,2},{2,3},{2,3},{2,3},{1,2},{1,2},{3,4},{1,2},{3,4},{1,2},{1,2},{2,3},{1,2},{1,2},{3,4},{1,2}};  
        //identificacao do tipo de cada tarefa do processo de integracao : {} 1:1, {"and"/"or"} 1:n
        public static String VetorOper[][] = {{},{},{"and","or"},{"and"},{},{},{},{},{},{},{},{"and"},{},{},{},{}};
        //identificacao do tarefas paralelas do processo de integracao
        public static int VetorParallelTask [] = {0,0,0,0,0,0,0,0,0,0,0,4,5,6,7,8};
        public static int NumTasks = VectorIdTask.length;
        //identificacao das tarefas «end» do processo de integracao
        public static int LastTask [] = {11};
        
//    }
  
}
