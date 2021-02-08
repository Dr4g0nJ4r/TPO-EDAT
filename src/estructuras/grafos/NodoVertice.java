package estructuras.grafos;

import estructuras.grafos.etiquetado.NodoAdyacente;

public class NodoVertice {
    private Object elem;
    private NodoVertice siguienteVertice;
    private NodoAdyacente primerAdyacente;

    public NodoVertice(Object elem)
    {
        this.elem = elem;
        this.siguienteVertice = null;
        this.primerAdyacente = null;
    }

    public Object getElem() {
        return this.elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public NodoVertice getSiguienteVertice() {
        return this.siguienteVertice;
    }

    public void setSiguienteVertice(NodoVertice siguienteVertice) {
        this.siguienteVertice = siguienteVertice;
    }

    public NodoAdyacente getPrimerAdyacente() {
        return this.primerAdyacente;
    }

    public void setPrimerAdyacente(NodoAdyacente primerAdyacente) {
        this.primerAdyacente = primerAdyacente;
    }
    
}
