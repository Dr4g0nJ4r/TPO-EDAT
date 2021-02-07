import java.util.Scanner;

public class App {
    private static Scanner scanner;
    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);

        Character opcion;
        System.out.println();
        System.out.println("BIENVENIDO A 'DUNGEONS & STRUCTURES - THE LORD OF THE RINGS' EXPANSION");
        System.out.println();
        do{
            opcion = Menu.menuPrincipal();
            switch (opcion) {
                case 'A':
                    //ABM Jugador -> Submenu
                    opcion = Menu.subMenuJugador();
                    switch (opcion) {
                        case '1':
                            //Alta de Jugador
                            break;
                        case '2':
                            //Modificación de Jugador
                            break;
                        case '3':
                            //Baja de Jugador
                            break;
                        default:
                            break;
                    }
                    break;
            
                case 'B':
                    //ABM Items -> Submenu
                    opcion = Menu.subMenuItem();
                    switch (opcion) {
                        case '1':
                            //Alta de Item
                            break;
                        case '2':
                            //Modificación de Item
                            break;
                        case '3':
                            //Baja de Item
                            break;
                        default:
                            break;
                    }
                    break;
                case 'C':
                    //ABM Locación -> Submenu
                    opcion = Menu.subMenuLocacion();
                    switch (opcion) {
                        case '1':
                            //Alta de Locación
                            break;
                        case '2':
                            //Modificación de Locación
                            break;
                        case '3':
                            //Baja de Locación
                            break;
                        default:
                            break;
                    }
                    break;
                    
                case 'D':
                    //Alta de un Jugador a un equipo
                    break;
                    
                case 'E':
                    //Creación automática de equipo
                    break;
                case 'F':
                    //Paso a paso de una batalla
                    break;
            
                case 'G':
                    //Consulta sobre equipos
                    break;
                case 'H':
                    //Consulta sobre items -> submenu consultaItem
                    opcion = Menu.consultaItem();
                    switch (opcion) {
                        case '1':
                            //Mostrar los items que puede comprar el jugador
                            break;
                        case '2':
                            //Mostrar los items en un rango de precios
                            break;
                        case '3':
                            //Mostrar propiedades del item
                            break;
                        default:
                            break;
                    }
                    break;
                    
                case 'I':
                    //Consulta sobre jugador -> submenu consultaJugador
                    opcion = Menu.consultaJugador();
                    switch (opcion) {
                        case '1':
                            //Mostrar los datos de un jugador
                            break;
                        case '2':
                            //Mostrar los jugadores que empiezan con 'xxx...' siendo x cualquier carácter
                            break;
                        default:
                            break;
                    }
                    break;
                    
                case 'J':
                    //Consulta sobre locaciones -> submenu consultaLocacion
                    opcion = Menu.consultaLocacion();
                    switch (opcion) {
                        case '1':
                            //Mostrar las locaciones a las que se puede mover un equipo
                            break;
                        case '2':
                            //Mostrar el camino de A a B más corto en km
                            break;
                        case '3':
                            //Mostrar el camino de A a B más corto en locaciones
                            break;
                        case '4':
                            //Mostrar los caminos de A a B posibles con menos de X km
                            break;
                        case '5':
                            //Mostrar el camino de A a B más corto en locaciones y que no pase por C
                            break;
                        default:
                            break;
                    }
                    break;
                case 'K':
                    //Consultas generales -> submenu consultaGeneral
                    opcion = Menu.consultaGeneral();
                    switch (opcion) {
                        case '1':
                            //Ranking de jugadores con más individuales ganadas
                            break;
                        case '2':
                            //Mostrar los items con solo un elemento disponible
                            break;
                        default:
                            break;
                    }
                    break;
                    
                case 'L':
                    //Mostrar sistema
                    break;

                default:
                System.out.println("¡¡ Ingrese una opción válida !!");
                    break;
            }
        }while(opcion != 'M');
    }
}
