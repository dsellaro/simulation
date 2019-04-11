package simulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DANI
 * grava arquivo txt com makespan da simulacao
 */

public class GravarArquivo {
        public static void GravarArquivo(String nameFile, String texto) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(nameFile))) {
            out.write(texto);
        } catch (IOException e) {
            System.out.println("erro: " + e);
        }
    }
    
}