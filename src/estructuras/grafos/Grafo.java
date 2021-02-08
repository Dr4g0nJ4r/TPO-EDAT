package estructuras.grafos;

import estructuras.lineales.dinamicas.Lista;

public class Grafo {
    private NodoVertice inicio;

    public Grafo(){
        this.inicio = null;
    }

    public boolean insertarVertice(Object vertice)
    {
        boolean exito = false;

        return exito;
    }

    public boolean eliminarVertice(Object vertice)
    {
        boolean exito = false;

        return exito;
    }

    public boolean insertarArco(Object origen, Object destino){
        boolean exito = false;

        return exito;
    }

    public boolean eliminarArco(Object origen, Object destino)
    {
        boolean exito = false;

        return exito;
    }

    public boolean existeVertice(Object vertice)
    {
        boolean exito = false;

        return exito;
    }

    public boolean existeArco(Object origen, Object destino)
    {
        boolean exito = false;

        return exito;
    }

    public boolean existeCamino(Object origen, Object destino)
    {
        boolean exito = false;

        return exito;
    }

    public Lista caminoMasCorto(Object origen, Object destino)
    {
        Lista lista = new Lista();

        return lista;
    }

    public Lista caminoMasLargo(Object origen, Object destino)
    {
        Lista lista = new Lista();

        return lista;
    }

    public Lista listarEnProfundidad()
    {
        Lista lista = new Lista();

        return lista;
    }

    public Lista listarEnAnchura()
    {
        Lista lista = new Lista();

        return lista;
    }

    public boolean esVacio()
    {
        boolean res = false;
        if(this.inicio == null)
        {
            res = true;
        }
        return res;
    }

    @Override
    public Grafo clone()
    {
        Grafo clon = new Grafo();

        return clon;
    }

    @Override
    public String toString()
    {
        String res = "";

        return res;
    }
}
