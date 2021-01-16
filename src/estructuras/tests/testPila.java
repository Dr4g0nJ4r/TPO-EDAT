package estructuras.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import estructuras.lineales.dinamicas.Pila;

public class testPila {
    public static void main(String[] args) {
        Pila pila = new Pila();
        Pila pila2 = new Pila();
        preCargarDatos(pila);
        preCargarDatos(pila2);
        System.out.println(pila.toString());
        System.out.println(pila2.toString());

    }

    public static void preCargarDatos(Pila pila) {
        ArrayList<String> nombres = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("D:\\Documentos\\Facultad\\2°Año\\1°Semestre\\Estructura de Datos\\Códigos\\TP_Final\\TPO\\src\\estructuras\\tests\\nombres.txt"));
            String nombre = reader.readLine();
        while(nombre != null)
        {
            nombres.add(nombre);
            nombre = reader.readLine();
        }
        Random numeroAleatorio = new Random();
        int pos;
        while(nombres.size() > 0)
        {
            pos =numeroAleatorio.nextInt(nombres.size());
            pila.apilar(nombres.get(pos));
            nombres.remove(pos);
        }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
