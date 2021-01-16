package estructuras.tests;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import estructuras.lineales.dinamicas.Pila;

public class testPila {
    public static void main(String[] args) {
        Pila pila;
        Pila pila2;
        BufferedReader entradaDatos;
        try {
            entradaDatos = new BufferedReader(new FileReader("D:\\Documentos\\Facultad\\2°Año\\1°Semestre\\Estructura de Datos\\Códigos\\TP_Final\\TPO\\src\\estructuras\\tests\\datos.txt"));
            String cad = entradaDatos.readLine();
            System.out.println("\n"+cad.toUpperCase());
            cad = entradaDatos.readLine();
            System.out.println("\n"+cad);
            entradaDatos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
