package juego.equipo.categoria;

public class Aficionado extends Categoria{
    static final int MULTIPLICADOR = 4;
    
    @Override
    public int obtenerMultiplicador() {
        return MULTIPLICADOR;
    }
}
