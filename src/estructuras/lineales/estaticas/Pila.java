package estructuras.lineales.estaticas;

/**Implementación dinámica del TDA Pila 
 *  - Estructura lineal de tipo LIFO (Last In, First Out)
 *  - Acceso solo al tope
*/
public class Pila {
    private static int TAM = 6;
    private Object[] arreglo;
    private int tope;
    /**Constructor de la Clase Pila. Retorna una Pila vacía */
    public Pila()
    {
        this.tope = -1;
        arreglo = new Object[TAM];
    }
    
    /**Apila, si es posible, el elemento pasado por parámetro en la Pila y lo coloca en el Tope. True si es posible, false caso contrario */
    public boolean apilar(Object elem)
    {
        boolean res;
        if((this.tope + 1) == TAM)
        {
            res = false;
        }else{
            this.tope++;
            arreglo[this.tope] = elem;
            res = true;
        }
        return res;
    }
    /**Desapila, si es posible, el elemento situado en el tope de la Pila. Retorna true si se desapiló, false caso contrario */
    public boolean desapilar()
    {
        boolean res;
        if(this.esVacia())
        {
            res = false;
        }else
        {
            arreglo[this.tope] = null;
            this.tope--;
            res = true;
        }
        return res;
    }

    /**Método que retorna el elemento situado en el tope de la Pila. Precondición: la Pila no está vacía */
    public Object obtenerTope(){
        return arreglo[this.tope];
    }

    /**Comprueba si la Pila está vacía. Retorna true si está vacía, false sino */
    public boolean esVacia(){
        boolean res = false;
        if(this.tope < 0)
        {
            res = true;
        }
        return res;
    }

    /**Vacía la Pila. Retorna void */
    public void vaciar(){
        while(!this.esVacia())
        {
            this.desapilar();
        }
    }

    /**Retorna una instancia Pila, con los elementos clonados de la Pila que llama al método */
    @Override
    public Pila clone()
    {
        Pila pilaClonada = new Pila();
        if(!this.esVacia())
        {
            int iter = 0;
            while(iter <= this.tope)
            {
                pilaClonada.apilar(this.arreglo[iter]);
                iter++;
            }
        }
        return pilaClonada;
    }
    //**Retorna una instancia String con la composición actual de la Pila, con todos sus elementos */
    @Override
    public String toString(){
        String pilaString = "";
        int anchoLinea = 30;
        int stringMasLargo = 0;
        if(this.esVacia())
        {
            pilaString += "La Pila está vacía"; 
        }else{
            int iter = this.tope;
            while(iter >= 0){
                if(iter == this.tope)
                {
                    pilaString += "\n |" + arreglo[iter].toString() + " ".repeat(anchoLinea - arreglo[iter].toString().length())+"|<-- TOPE";
                }else{
                    pilaString += "\n |" + arreglo[iter].toString() + " ".repeat(anchoLinea - arreglo[iter].toString().length()) + "|";
                }
                if(arreglo[iter].toString().length() > stringMasLargo)
                {
                    stringMasLargo = arreglo[iter].toString().toString().length();
                }
                iter--;
            }
            pilaString += "<-- Base de la Pila";
        }
        return pilaString;
    }
}
