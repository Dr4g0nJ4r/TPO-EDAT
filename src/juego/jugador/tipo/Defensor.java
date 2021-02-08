package juego.jugador.tipo;


public class Defensor extends Tipo{
    static final int ATAQUE = 25;
    static final int DEFENSA = 90;

    @Override
    int obtenerAtaqueBase() {
        return ATAQUE;
    }

    @Override
    int obtenerDefensaBase() {
        return DEFENSA;
    }
}
