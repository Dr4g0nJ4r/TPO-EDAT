package juego.jugador;

import estructuras.lineales.dinamicas.Lista;
import juego.jugador.categoria.*;
import juego.jugador.tipo.*;

public class Jugador {
    private String nombreUsuario;
    private int dineroRecolectado;
    private Lista listaItem;
    private int salud;
    private int cantDerrotas;
    private int cantVictorias;
	private int multiplicador;
    private Categoria categoria;
    private Tipo tipoJugador;

    public Jugador()
    {
        
    }
}
