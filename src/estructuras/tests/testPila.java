package estructuras.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//import estructuras.lineales.dinamicas.Pila;
import estructuras.lineales.estaticas.Pila;
public class testPila {
    /**Método main de la clase TestPila. Levanta por defecto un lote de prueba y genera el menú */
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Pila pila = new Pila();
        Pila pila2 = new Pila();
        preCargarDatos(pila);
        preCargarDatos(pila2);
        ArrayList<Pila> arrayPilas = new ArrayList<>();
        arrayPilas.add(pila);
        arrayPilas.add(pila2); 
        System.out.println(pila.toString());
        System.out.println(pila2.toString());
        int opcionElegida;
        int indexPilaActual = 0;
        do{
            opcionElegida = menu();
            switch (opcionElegida) {
                case 1:
                //agrega un elemento a la Pila
                    System.out.print("Ingrese un nuevo nombre y apellido: ");
                    String nuevoElem = scanner.nextLine();
                    System.out.println("Se apiló el elemento? -> " + arrayPilas.get(indexPilaActual).apilar(nuevoElem));
                    break;
                case 2:
                //Obtiene el elemento tope de la pila.
                    if(arrayPilas.get(indexPilaActual).esVacia())
                    {
                        System.out.println("La pila está vacía");
                    }else{
                        System.out.println("El elemento tope es " + arrayPilas.get(indexPilaActual).obtenerTope());
                    }
                    break;
                case 3:
                //retira el elemento tope de la pila
                    if(!arrayPilas.get(indexPilaActual).esVacia())
                    {
                        System.out.println("Se retiró el elemento? -> " + arrayPilas.get(indexPilaActual).desapilar());
                    }
                    break;
                case 4:
                //Consulta si la pila está vacia. True si, false no
                    System.out.println("La pila está vacía? : " + arrayPilas.get(indexPilaActual).esVacia());
                    break;
                case 5:
                //Clona la pila y crea una nueva. La almacena en arrayPila
                    arrayPilas.add(arrayPilas.get(indexPilaActual).clone());
                    System.out.println("Pila Clonada con éxito");
                    break;
                case 6:
                //Visualizar la pila
                    System.out.println(arrayPilas.get(indexPilaActual).toString());
                    break;
                case 7:
                //Cambiar de pila en arrayPila
                    indexPilaActual = (indexPilaActual + 1) % arrayPilas.size();
                    System.out.println("Posición actual -> " + indexPilaActual);
                    break;
                case 8:
                //Vacía la Pila
                    arrayPilas.get(indexPilaActual).vaciar();
                    break;
                case 0:
                //Cierre del programa
                    System.out.println("Fin del Programa");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    opcionElegida = -1;
                    break;
            }
        }while(opcionElegida != 0);
        scanner.close();
    }

    // Método con ingreso del dato de la opción del menú
    private static int menu(){
        int opcion;
        String opciones = "MENÚ \n";
        opciones += "1. Agregar elemento a la Pila \n";
        opciones += "2. Obtener elemento de la Pila \n";
        opciones += "3. Sacar tope \n";
        opciones += "4. Pila está vacia? \n";
        opciones += "5. Clonar pila \n";
        opciones += "6. Ver Pila \n";
        opciones += "7. Cambiar de Pila \n";
        opciones += "8. Vaciar pila\n";
        opciones += "0. Cerrar programa \n";
        System.out.println(opciones);
        opcion = (int) scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    /**Precarga de datos desde archivo .txt externo */
    private static void preCargarDatos(Pila pila) {
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
