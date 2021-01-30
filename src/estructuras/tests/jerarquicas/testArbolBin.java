package estructuras.tests.jerarquicas;


import java.util.ArrayList;
import java.util.Random;

import estructuras.jerarquicas.dinamicas.ArbolBinario;

//**Clase Testing de Árbol Binario */
public class testArbolBin {
    private static String[] nombresTest = {"Luis", "Carlos", "Juana", "Felipe", "Candela", "Jorge", "Luz"};
    private static Integer[] numerosTest = {1,30,10,28,19,33,100,99,56,83,91,4,7};
    public static void main(String[] args)
    {
        Random aleatorio = new Random();
        Character[] posicionHijo = {'I','D'};
        
        //Árbol 1 con nombres
        ArrayList<String> nombres = new ArrayList<String>();
        ArrayList<String> nombresCargados = new ArrayList<String>();
        for (String nombre : nombresTest) {
            nombres.add(nombre);
        }
        ArbolBinario arbol1 = new ArbolBinario();
        //Insertar raiz
        int pos = aleatorio.nextInt(nombres.size());
        arbol1.insertar(nombres.get(pos), null, 'D');
        nombresCargados.add(nombres.get(pos));
        nombres.remove(pos);
        while(nombres.size()>0)
        {
            pos = aleatorio.nextInt(nombres.size());
            arbol1.insertar(nombres.get(pos), nombresCargados.get(aleatorio.nextInt(nombresCargados.size())), posicionHijo[aleatorio.nextInt(2)]);
            nombresCargados.add(nombres.get(pos));
            nombres.remove(pos);
        }
        
        //Árbol 2 con números
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        ArrayList<Integer> numerosCargados = new ArrayList<Integer>();
        for (Integer numero : numerosTest) {
            numeros.add(numero);
        }
        ArbolBinario arbol2 = new ArbolBinario();
        //Insertar raiz
        pos = aleatorio.nextInt(numeros.size());
        arbol1.insertar(numeros.get(pos), null, 'D');
        numerosCargados.add(numeros.get(pos));
        numeros.remove(pos);
        while(numeros.size()>0)
        {
            pos = aleatorio.nextInt(numeros.size());
            arbol2.insertar(numeros.get(pos), numerosCargados.get(aleatorio.nextInt(numerosCargados.size())), posicionHijo[aleatorio.nextInt(2)]);
            numerosCargados.add(numeros.get(pos));
            numeros.remove(pos);
        }
    }
}

