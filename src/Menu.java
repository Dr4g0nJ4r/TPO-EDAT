import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    public static Character menuPrincipal()
    {
        System.out.println("MENU PRINCIPAL");
        System.out.println();
        System.out.println("A) ABM de jugadores");
        System.out.println("B) ABM de items");
        System.out.println("C) ABM de locaciones");
        System.out.println("D) Alta de un jugador en la cola de espera por un equipo");
        System.out.println("E) Creación automática de equipo");
        System.out.println("F) Paso a paso de una batalla entre equipos");
        System.out.println("G) Consulta sobre equipos");
        System.out.println("H) Consulta sobre items");
        System.out.println("I) Consulta sobre jugadores");
        System.out.println("J) Consulta sobre locaciones");
        System.out.println("K) Consultas generales");
        System.out.println("L) Mostrar sistema");
        System.out.println("M) Salir del juego");
        System.out.println();
        System.out.print("Ingrese una opción:");
        Character opcion = scanner.nextLine().charAt(0);
        System.out.println();
        return opcion;
    }

    public static Character subMenuJugador()
    {
        System.out.println("Menú Jugador");
        System.out.println();
        System.out.println("1) Alta de jugador");
        System.out.println("2) Modificación de jugador");
        System.out.println("3) Baja de jugador");
        System.out.println("X) Volver al menú principal");
        System.out.println();
        System.out.print("Ingrese una opción:");
        Character opcion = scanner.nextLine().charAt(0);
        return opcion;
    }
    public static Character subMenuItem()
    {
        System.out.println("Menú Item");
        System.out.println();
        System.out.println("1) Alta de ítem");
        System.out.println("2) Modificación de ítem");
        System.out.println("3) Baja de ítem");
        System.out.println("X) Volver al menú principal");
        System.out.println();
        System.out.print("Ingrese una opción:");
        Character opcion = scanner.nextLine().charAt(0);
        return opcion;
    }

    public static Character subMenuLocacion()
    {
        System.out.println("Menú Locación");
        System.out.println();
        System.out.println("1) Alta de locación");
        System.out.println("2) Modificación de locación");
        System.out.println("3) Baja de locación");
        System.out.println("X) Volver al menú principal");
        System.out.println();
        System.out.print("Ingrese una opción:");
        Character opcion = scanner.nextLine().charAt(0);
        return opcion;
    }

    public static Character consultaItem()
    {
        System.out.println("Menú Consulta Item");
        System.out.println();
        System.out.println("1) Mostrar los items que puede comprar el jugador");
        System.out.println("2) Mostrar los items entre un rango de precios");
        System.out.println("3) Mostrar propiedades del ítem");
        System.out.println("X) Volver al menú principal");
        System.out.println();
        System.out.print("Ingrese una opción:");
        Character opcion = scanner.nextLine().charAt(0);
        return opcion;
    }

    public static Character consultaJugador()
    {
        System.out.println("Menú Consulta Jugador");
        System.out.println();
        System.out.println("1) Mostrar los datos de un jugador");
        System.out.println("2) Mostrar los jugadores que empiezan con '<texto>'");
        System.out.println("X) Volver al menú principal");
        System.out.println();
        System.out.print("Ingrese una opción:");
        Character opcion = scanner.nextLine().charAt(0);
        return opcion;
    }

    public static Character consultaLocacion()
    {
        System.out.println("Menú Consulta Locación");
        System.out.println();
        System.out.println("1) Mostrar las locaciones a las que se puede mover un equipo");
        System.out.println("X) Dado dos locaciones A y B");
        System.out.println("   2) Obtener el camino más corto de A a B en km");
        System.out.println("   3) Obtener el camino de A a B que pasa por la menor cantidad de locaciones");
        System.out.println("   4) Obtener todos los caminos para llegar de A a B con menos de una cantidad N de km");
        System.out.println("   5) Obtener el camino de A a B que pase por la menor cantidad de locaciones y no pase por la locación C");
        System.out.println("X) Volver al menú principal");
        System.out.println();
        System.out.print("Ingrese una opción:");
        Character opcion = scanner.nextLine().charAt(0);
        return opcion;
    }

    public static Character consultaGeneral()
    {
        System.out.println("Menú Consulta General");
        System.out.println();
        System.out.println("1) Ranking de jugadores con más batallas individuales ganadas");
        System.out.println("2) Mostrar los items con solo un elemento disponible");
        System.out.println("X) Volver al menú principal");
        System.out.println();
        System.out.print("Ingrese una opción:");
        Character opcion = scanner.nextLine().charAt(0);
        return opcion;
    }
}
