package estructuras.grafos.etiquetado;

import estructuras.grafos.NodoVertice;

public class NodoAdyacente {
    private NodoVertice vertice;
    private NodoAdyacente siguienteAdyacente;
    private int etiqueta;

    public NodoAdyacente(NodoVertice vertice, int etiqueta)
    {
        this.vertice = vertice;
        this.etiqueta = etiqueta;
        this.siguienteAdyacente = null;
    }
    public NodoVertice getVertice() {
        return this.vertice;
    }

    public void setVertice(NodoVertice vertice) {
        this.vertice = vertice;
    }

    public NodoAdyacente getSiguienteAdyacente() {
        return this.siguienteAdyacente;
    }

    public void setSiguienteAdyacente(NodoAdyacente siguienteAdyacente) {
        this.siguienteAdyacente = siguienteAdyacente;
    }

    public int getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }

}
