package juego.jugador.tipo;


public class Guerrero extends Tipo{
    static final int ATAQUE = 100;
    static final int DEFENSA = 50;

    @Override
    int obtenerAtaqueBase() {
        return ATAQUE;
    }

    @Override
    int obtenerDefensaBase() {
        return DEFENSA;
    }
}
