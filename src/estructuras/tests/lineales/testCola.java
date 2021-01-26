package estructuras.tests.lineales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//import estructuras.lineales.dinamicas.Cola;
import estructuras.lineales.estaticas.Cola;
public class testCola {
    private static Scanner scanner;
    public static void main(String[] args)
    {
        ArrayList<Cola> arrayCola = new ArrayList<>();
        Cola cola = new Cola();
        Cola cola2 = new Cola();
        preCargarDatos(cola);
        preCargarDatos(cola2);
        arrayCola.add(cola);
        arrayCola.add(cola2);
        scanner = new Scanner(System.in);
        int opcionElegida;
        int indexCola = 0;
        do{
            opcionElegida = menu();
            switch (opcionElegida) {
                case 1:
                //Agrega un elemento al final de la Cola
                    System.out.print("Ingrese un nuevo nombre y apellido: ");
                    String nuevoElem = scanner.nextLine();
                    System.out.println("Se agregó el elemento? -> " + arrayCola.get(indexCola).poner(nuevoElem));
                    break;
                case 2:
                //Obtiene el elemento situado enfrente de la Cola.
                    if(arrayCola.get(indexCola).esVacia())
                    {
                        System.out.println("La Cola está vacía");
                    }else{
                        System.out.println("El elemento frente es " + arrayCola.get(indexCola).obtenerFrente());
                    }
                    break;
                case 3:
                //Retira el elemento del frente de la Cola
                    if(!arrayCola.get(indexCola).esVacia())
                    {
                        System.out.println("Se retiró el elemento? -> " + arrayCola.get(indexCola).sacar());
                    }
                    break;
                case 4:
                //Consulta si la Cola está vacia. True si, false no
                    System.out.println("La Cola está vacía? : " + arrayCola.get(indexCola).esVacia());
                    break;
                case 5:
                //Clona la Cola y crea una nueva. La almacena en arrayCola
                    arrayCola.add(arrayCola.get(indexCola).clone());
                    System.out.println("Cola Clonada con éxito");
                    break;
                case 6:
                //Visualizar la Cola
                    System.out.println(arrayCola.get(indexCola).toString());
                    break;
                case 7:
                //Cambiar de Cola en arrayCola
                    indexCola = (indexCola + 1) % arrayCola.size();
                    System.out.println("Posición actual -> " + indexCola);
                    break;
                case 8:
                //Vacía la Cola
                    arrayCola.get(indexCola).vaciar();
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
        opciones += "1. Agregar elemento a la Cola \n";
        opciones += "2. Obtener elemento de la Cola \n";
        opciones += "3. Sacar elemento \n";
        opciones += "4. Cola está vacia? \n";
        opciones += "5. Clonar Cola \n";
        opciones += "6. Ver Cola \n";
        opciones += "7. Cambiar de Cola \n";
        opciones += "8. Vaciar Cola\n";
        opciones += "0. Cerrar programa \n";
        System.out.println(opciones);
        opcion = (int) scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    /**Precarga de datos desde archivo .txt externo */
    private static void preCargarDatos(Cola cola) {
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
            cola.poner(nombres.get(pos));
            nombres.remove(pos);
        }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
