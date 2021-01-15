package estructuras.lineales.dinamicas;

/**Elemento básico para la creación de las estructuras lineales dinámicas. Contiene dos datos: el elemento y el enlace a otro Nodo */
public class Nodo {
    private Object elem;
    private Nodo enlace;

    /**Método constructor. Retorna una instancia de Nodo*/
    public Nodo (Object elem, Nodo enlace){
		this.elem = elem;
        this.enlace = enlace;
    }
    /**Devuelve el elemento del nodo */
    public Object getElem() {
        return this.elem;
    }
    /**Actualiza el elemento del nodo por el elemento ingresado por parámetro*/
    public void setElem(Object elem) {
        this.elem = elem;
    }
    /**Devuelve la instancia de Nodo referida por el enlace. Si la referencia de enlace es null, entonces no se encuentra referenciado con otra instancia de Nodo */
    public Nodo getEnlace() {
        return this.enlace;
    }
    /**Actualiza la referencia del enlace a la instancia Nodo ingresada por parámetro */
    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

}
