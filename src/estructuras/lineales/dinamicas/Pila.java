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

    public Object obtenerTope()
    {
    }

    public boolean esVacia()
    {

    }

    public void vaciar()
    {

    }
    @Override
    public Pila clone()
    {

    }

    @Override
    public String toString()
    {

    }
}

