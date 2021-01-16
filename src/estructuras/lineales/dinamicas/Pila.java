package estructuras.lineales.dinamicas;

/**Implementación dinámica del TDA Pila 
 *  - Estructura lineal de tipo LIFO (Last In, First Out)
 *  - Acceso solo al tope
*/
public class Pila{
    private Nodo tope; 
    
    /**Constructor de la clase Pila. Devuelve una Pila vacía */
    public Pila ()
    {
        this.tope = null;
    }

    /**Apila el elemento pasado por parámetro y lo referencia como el tope de la Pila. Retorna true si el elemento se pudo apilar, false en caso contrario */
    public boolean apilar(Object nuevoElem){
        boolean res = true;
        Nodo nuevoNodo = new Nodo(nuevoElem, this.tope);
        this.tope = nuevoNodo;
        return res;
    }
    /**Desapila el elemento situado en el tope de la Pila. Si la Pila no está vacía, el siguiente elemento pasa a ser el nuevo tope. Retorna true si el elemento se desapilo, false en caso contrario */
    public boolean desapilar(){
        boolean res = true;
        if(this.esVacia())
        {
            res = false;
        }else{
            this.tope = this.tope.getEnlace();
        }
        return res;
    }
    /**Devuelve el elemento contenido en la Tope de la Pila. Precondición: la Pila no es vacía*/
    public Object obtenerTope()
    {
        return this.tope.getElem();
    }
    /**Devuelve true si la Pila no contiene elementos, false en caso de tener uno o más elementos */
    public boolean esVacia()
    {
        boolean res = false;
        if(this.tope == null)
        {
            res = true;
        }
        return res;
    }
    /**Vacía la Pila de todos sus elementos. Retorna void. */
    public void vaciar()
    {
        while(!this.esVacia())
        {
            this.tope = this.tope.getEnlace();
        }
    }
    /**Clona la Pila invocada. Retorna una instancia Pila con los mismos elementos y orden de la Pila que invoca al método. */
    @Override
    public Pila clone()
    {
        Pila nuevaPila = new Pila();
        if(!this.esVacia())
        {
            this.recorrerRecursivamente(nuevaPila, this.tope);
        }
        return nuevaPila;
    }
    /**Retorna un String con los elementos presentes en la Pila */
    @Override
    public String toString()
    {
        String pilaString = "";
        if(this.esVacia())
        {
            pilaString += "La Pila está vacía"; 
        }else{
            Nodo nodoIterable = this.tope;
            while(nodoIterable != null){
                if(nodoIterable == this.tope)
                {
                    pilaString += "\n | " + nodoIterable.getElem().toString() + " |<-- TOPE";
                }else{
                    pilaString += "\n" + nodoIterable.getElem().toString();
                }
                nodoIterable = nodoIterable.getEnlace();
            }
            pilaString += "|_____________________________| <-- Base de la Pila";
        }
        return pilaString;
    }
    /**Recorre la Pila de forma recursiva, desde el tope de la Pila hasta alcanzar el primer elemento ingresado en la Pila (caso base). Desde el caso base, y en el retorno de la recursividad, se van agregando los elementos a la instancia Pila pasada por parámetros. Se utiliza en el método público clone() */
    private void recorrerRecursivamente(Pila pila, Nodo nodo)
    {
        //caso base
        if(nodo.getEnlace() == null)
        {
            pila.apilar(nodo.getElem());
        }
        //caso iterativo
        else
        {
            this.recorrerRecursivamente(pila, nodo.getEnlace());
            pila.apilar(nodo.getElem());
        }
    }
}

