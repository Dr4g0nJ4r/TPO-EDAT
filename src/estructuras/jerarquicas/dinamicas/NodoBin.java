package estructuras.jerarquicas.dinamicas;

/**Estructura interna del ÁrbolBinario. Cada Nodo almacena:
 *  - un elemento
 *  - una referencia a cada hijo (izquierdo - derecho)
 * @author Luis Keller
 */

 public class NodoBin {
     private Object elemento;
     private NodoBin hijoIzquierdo;
     private NodoBin hijoDerecho;

     /** Constructor de la clase NodoBin. Retorna un NodoBin con el elemento pasado por parámetro y dos hijos en null */
    public NodoBin(Object elem)
    {
        this.elemento = elem;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

     public Object getElemento() {
         return this.elemento;
     }

     public void setElemento(Object elemento) {
         this.elemento = elemento;
     }

     public NodoBin getHijoIzquierdo() {
         return this.hijoIzquierdo;
     }

     public void setHijoIzquierdo(NodoBin hijoIzquierdo) {
         this.hijoIzquierdo = hijoIzquierdo;
     }

     public NodoBin getHijoDerecho() {
         return this.hijoDerecho;
     }

     public void setHijoDerecho(NodoBin hijoDerecho) {
         this.hijoDerecho = hijoDerecho;
     }

}
