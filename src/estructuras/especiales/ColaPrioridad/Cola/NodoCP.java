package estructuras.especiales.ColaPrioridad.Cola;

import estructuras.lineales.dinamicas.Cola;

public class NodoCP {
    private int prioridad;
    private Cola items;

    public NodoCP(Object elem, int prioridad){
        this.prioridad = prioridad;
        this.items = new Cola();
    }
    public int getPrioridad() {
        return this.prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Cola getItems() {
        return this.items;
    }

    public void setItems(Cola items) {
        this.items = items;
    }

}
