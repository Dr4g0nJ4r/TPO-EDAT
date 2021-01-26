package estructuras.tests;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import estructuras.lineales.dinamicas.Lista;


public class testFila {
    private static Scanner scanner;
    public static void main(String[] args)
    {
        scanner = new Scanner(System.in);
        ArrayList<Lista> arrayLista = new ArrayList();
        Lista lista = new Lista();
        Lista lista2 = new Lista();
        preCargarDatos(lista);
        preCargarDatos(lista2);
        arrayLista.add(lista);
        arrayLista.add(lista2);
        int opcionElegida;
        int indexLista = 0;
        int pos;
        do{
            opcionElegida = menu();
            switch (opcionElegida) {
                case 1:
                //Insertar un elemento nuevo en la posición indicada
                    System.out.println("Ingrese un nuevo nombre y apellido: ");
                    String nuevoElem = scanner.nextLine();
                    System.out.print("Ingrese la posición: ");
                    pos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Se agregó el elemento? -> " + arrayLista.get(indexLista).insertar(nuevoElem,pos));
                    break;
                case 2:
                //Recupera el elemento de la posición indicada
                    if(arrayLista.get(indexLista).esVacia())
                    {
                        System.out.println("La Lista está vacía");
                    }else{
                        System.out.print("Ingrese una posición: ");
                        pos = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("El elemento en la posición es " + arrayLista.get(indexLista).recuperar(pos));
                    }
                    break;
                case 3:
                //Retira el elemento de la posición indicada
                    if(!arrayLista.get(indexLista).esVacia())
                    {
                        System.out.print("Ingrese una posición: ");
                        pos = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Se retiró el elemento? -> " + arrayLista.get(indexLista).eliminar(pos));
                    }
                    break;
                case 4:
                //Consulta si la Lista está vacia. True si, false no
                    System.out.println("La Lista está vacía? : " + arrayLista.get(indexLista).esVacia());
                    break;
                case 5:
                //Clona la Lista y crea una nueva. La almacena en arrayLista
                    arrayLista.add(arrayLista.get(indexLista).clone());
                    System.out.println("Lista Clonada con éxito");
                    break;
                case 6:
                //Visualizar la Lista
                    System.out.println(arrayLista.get(indexLista).toString());
                    break;
                case 7:
                //Cambiar de Lista en arrayLista
                    indexLista = (indexLista + 1) % arrayLista.size();
                    System.out.println("Posición actual -> " + indexLista);
                    break;
                case 8:
                //Vacía la Lista
                    arrayLista.get(indexLista).vaciar();
                    break;
                case 9:
                //Localiza el elemento ingresado. Retorna la posición
                    if(!arrayLista.get(indexLista).esVacia())
                    {
                        System.out.print("Ingrese el elemento a buscar: ");
                        String elem = scanner.nextLine();
                        System.out.println("Posición del elemento " + arrayLista.get(indexLista).localizar(elem));
                    }
                    else
                    {
                        System.out.println("Lista vacía");
                    }
                    break;
                case 10:
                //Retorna el largo de la Lista
                    System.out.println("Longitud de la Lista -> " + arrayLista.get(indexLista).longitud() + " elementos");
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
        opciones += "1. Insertar elemento a la Lista \n";
        opciones += "2. Recuperar elemento de la Lista \n";
        opciones += "3. Eliminar elemento \n";
        opciones += "4. Lista está vacia? \n";
        opciones += "5. Clonar Lista \n";
        opciones += "6. Ver Lista \n";
        opciones += "7. Cambiar de Lista \n";
        opciones += "8. Vaciar Lista\n";
        opciones += "9. Localizar elemento \n";
        opciones += "10.Longitud de la Lista\n";
        opciones += "0. Cerrar programa \n";
        System.out.println(opciones);
        opcion = (int) scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    /**Precarga de datos desde archivo .txt externo */
    private static void preCargarDatos(Lista lista) {
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
            lista.insertar(nombres.get(pos), lista.longitud()+1);
            nombres.remove(pos);
        }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
