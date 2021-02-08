package juego.jugador.categoria;

public class Profesional extends Categoria{
    static final int MULTIPLICADOR = 5;
    @Override
    public int obtenerMultiplicador() {
        return MULTIPLICADOR;
    }
}
