package estructuras.tests.jerarquicas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import estructuras.jerarquicas.dinamicas.ArbolBinario;
import estructuras.lineales.dinamicas.Lista;

//**Clase Testing de Árbol Binario */
public class testArbolBin {
    private static Scanner scanner;
    private static String[] nombresTest = {"Luis", "Carlos", "Juana", "Felipe", "Candela", "Jorge", "Luz"};
    private static Integer[] numerosTest = {1,30,10,28,19,33,100,99,56,83,91,4,7};
    public static void main(String[] args)
    {
        scanner = new Scanner(System.in);
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
        arbol2.insertar(numeros.get(pos), null, 'D');
        numerosCargados.add(numeros.get(pos));
        numeros.remove(pos);
        while(numeros.size()>0)
        {
            pos = aleatorio.nextInt(numeros.size());
            arbol2.insertar(numeros.get(pos), numerosCargados.get(aleatorio.nextInt(numerosCargados.size())), posicionHijo[aleatorio.nextInt(2)]);
            numerosCargados.add(numeros.get(pos));
            numeros.remove(pos);
        }
        ArrayList<ArbolBinario> arboles = new ArrayList<ArbolBinario>();
        arboles.add(arbol1);
        arboles.add(arbol2);
        //Menú
        int opcionElegida = 0;
        int posicionArbol = 0;
        Object elem;
        Object elemPadre;
        Lista lista;
        do{
            opcionElegida = menu();
            switch (opcionElegida) {
                case 1:
                //Crear un árbol vacío
                    arboles.add(new ArbolBinario());
                    System.out.println("Se creó un árbol vacío");
                    break;
                case 2:
                //Se inserta un elemento en el árbol
                    System.out.println("Ingrese el elemento a insertar: ");
                    elem= scanner.nextLine();
                    System.out.println("Ingrese el padre del elemento a insertar: ");
                    elemPadre= scanner.nextLine();
                    System.out.println("Ingrese la posición del hijo <'I'zquierda / 'D'erecha>: ");
                    char posHijo = scanner.nextLine().charAt(0);
                    System.out.println("Estado de la operación: " + arboles.get(posicionArbol).insertar(elem, elemPadre, posHijo));
                    break;
                case 3:
                //Consulta si el árbol está vacío
                    System.out.println("El árbol está vacío? = " + arboles.get(posicionArbol).esVacio());
                    break;
                case 4:
                //Consulta la altura del árbol
                    System.out.println("Altura del árbol : " + arboles.get(posicionArbol).altura());
                    break;
                case 5:
                //Consulta el nivel de un elemento
                    System.out.println("Ingrese el elemento a determinar su nivel : ");
                    elem = scanner.nextLine();
                    System.out.println("El nivel del elemento es: " + arboles.get(posicionArbol).nivel(elem));
                    break;
                case 6:
                // Retorna el padre del elemento ingresado
                    System.out.println("Ingrese el elemento hijo del elemento buscado");
                    elem = scanner.nextLine();
                    System.out.println("El elemento padre es: " + arboles.get(posicionArbol).padre(elem));
                    break;
                case 7:
                //Cambiar de árbol en arrayArboles
                    posicionArbol = (posicionArbol+1) % arboles.size();
                    System.out.println("Posición actual -> " + posicionArbol);
                    break;
                case 8:
                //Vacía el árbol
                    arboles.get(posicionArbol).vaciar();
                    break;
                case 9:
                //Lista en PreOrden
                    System.out.println("PreOrden");
                    lista = arboles.get(posicionArbol).listarPreorden();
                    while(!lista.esVacia())
                    {
                        System.out.print(lista.recuperar(1).toString() + " ");
                        lista.eliminar(1);
                    }
                    System.out.println("");
                    break;
                case 10:
                //Lista en InOrden
                    System.out.println("InOrden");
                    lista = arboles.get(posicionArbol).listarInorden();
                    while(!lista.esVacia())
                    {
                        System.out.print(lista.recuperar(1).toString() + " ");
                        lista.eliminar(1);
                    }
                    System.out.println("");
                    break;
                case 11:
                //Lista en PosOrden
                    System.out.println("PosOrden");
                    lista = arboles.get(posicionArbol).listarPosorden();
                    while(!lista.esVacia())
                    {
                        System.out.print(lista.recuperar(1).toString() + " ");
                        lista.eliminar(1);
                    }
                    System.out.println("");
                    break;
                case 12:
                //Listar en niveles
                    System.out.println("Por niveles");
                    lista = arboles.get(posicionArbol).listarNiveles();
                    while(!lista.esVacia())
                    {
                        System.out.print(lista.recuperar(1).toString() + " ");
                        lista.eliminar(1);
                    }
                    System.out.println("");
                    break;
                case 13:
                //Clonar árbol
                    System.out.println("Árbol clonado");
                    arboles.add(arboles.get(posicionArbol).clone());
                    break;
                case 14:
                //toString
                    System.out.println("Contenido del árbol");
                    System.out.println(arboles.get(posicionArbol).toString());
                    break;
                case 0:
                //Cierre del programa
                    System.out.println("Fin del Programa Árbol Binario");
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
        opciones += "1. Crear árbol nuevo \n";
        opciones += "2. Insertar elemento \n";
        opciones += "3. Está vacío? \n";
        opciones += "4. Altura del árbol \n";
        opciones += "5. Nivel de un elemento \n";
        opciones += "6. Padre de un elemento \n";
        opciones += "7. Cambiar de Árbol \n";
        opciones += "8. Vaciar Árbol\n";
        opciones += "9. Listar Preorden \n";
        opciones += "10. Listar Inorden\n";
        opciones += "11. Listar Posorden \n";
        opciones += "12. Listar por niveles\n";
        opciones += "13. Clonar árbol \n";
        opciones += "14. toString()\n";
        opciones += "0. Cerrar programa \n";
        System.out.println(opciones);
        opcion = (int) scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
}

