package estructuras.jerarquicas.estaticas;

/**Estructura auxiliar a ArbolBin(implementación estática) que contiene un elemento, la posición de los nodos hijos y una variable de estado */
public class CeldaBin {
    private Object elem;
    private int izquierdo;
    private int derecho;
    private boolean enUso;

    /**Crea una instancia de CeldaBin vacía y la retorna */
    public CeldaBin(){
        this.derecho = -1;
        this.izquierdo = -1;
        this.enUso = false;
        this.elem = null;
    }

    public CeldaBin(Object elemento)
    {
        this.elem = elemento;
        this.enUso = true;
        this.derecho = -1;
        this.izquierdo = -1;
    }

    public Object getElem() {
        return this.elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
        if(this.elem != null)
        {
            this.setEnUso(true);
        }
        
    }

    public int getIzquierdo() {
        return this.izquierdo;
    }

    public void setIzquierdo(int izquierdo) {
        this.izquierdo = izquierdo;
    }

    public int getDerecho() {
        return this.derecho;
    }

    public void setDerecho(int derecho) {
        this.derecho = derecho;
    }

    public boolean isEnUso() {
        return this.enUso;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }

    



}
