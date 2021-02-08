package juego.jugador.categoria;

public class Novato extends Categoria{
    static final int MULTIPLICADOR = 3;

    @Override
    public int obtenerMultiplicador() {
        return MULTIPLICADOR;
    }
    
}
