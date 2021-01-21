package estructuras.lineales.dinamicas;

/**TDA LISTA
 * 
 * Secuencia de elementos, que constituyen una estructura flexible
 * Se puede operar con todos los elementos
 */
public class Lista {
    private Nodo cabecera;
    /**Constructor vacío. Retorna una instancia Lista */
    public Lista(){
        this.cabecera = null;
    }
    /**Agrega el elemento pasado por parámetro en la posición indicada por parámetro. La pos indicada debe ser menor al tamaño de la Lista, excepto si es el primer elemento que se ingresa (pos = tamaño Lista = 0 ). Retorna true si se insertó, false sino. */
    public boolean insertar(Object elem, int pos){
        boolean res = true;
        if(pos > 0 && pos <= this.longitud()+1)
        {
            if(pos == 1)
            {
                this.cabecera = new Nodo(elem, this.cabecera);
            }else{
                Nodo nodoAux = this.cabecera;
                int iter = 1;
                while(iter < (pos-1))
                {
                    nodoAux = nodoAux.getEnlace();
                    iter++;
                }
                Nodo nuevoElem = new Nodo(elem, nodoAux.getEnlace());
                nodoAux.setEnlace(nuevoElem);
            }
        }else{
            res = false;
        }
        return res;
    }
    /**Elimina el elemento de la posición pasada por parámetro. True si lo eliminó, false sino */
    public boolean eliminar(int pos){
        boolean exito = true;
        if(this.esVacia() || pos < 1 || pos > this.longitud())
        {
            exito = false;
        }
        else
        {
            Nodo nodoAux = this.cabecera;
            int iter = 1;
            while(iter < (pos-1))
            {
                iter++;
                nodoAux = nodoAux.getEnlace();
            }
            //El elemento a eliminar es el último de la Lista
            if(nodoAux.getEnlace() == null)
            {
                nodoAux.setEnlace(null);
            }
            else
            {
                nodoAux.setEnlace(nodoAux.getEnlace().getEnlace());
            }
        }
        return exito;
    }
    /**Devuelve el elemento situado en la posición indicada. Precondición: la posición es menor al tamaño de la Lista */
    public Object recuperar(int pos){
        Object elem = null;
        if(pos > 0 && pos <= this.longitud() + 1)
        {
            int iter = 1;
            Nodo nodoAux = this.cabecera;
            while(iter < pos)
            {
                iter++;
                nodoAux = nodoAux.getEnlace();
            }
            elem = nodoAux.getElem();
        }
        return elem;
    }
    /**Busca en la Lista el elemento pasado por parámetro y retorna la posición. Si no se encuentra el elemento en la Lista, retorna -1. Si hay más de un elemento, retorna la posición del primero*/
    public int localizar(Object elem){
        int pos = 1;
        Nodo nodoAux = this.cabecera;
        while(nodoAux != null && pos <= this.longitud()+1)
        {
            if(elem.equals(nodoAux.getElem()))
            {
                nodoAux = null;
            }
            else
            {
                nodoAux = nodoAux.getEnlace();
                pos++;
            }     
        }
        if(pos == this.longitud())
        {
            pos = -1;
        }
        return pos;
    }
    /**Retorna la cantidad de elementos en la Lista */
    public int longitud(){
        int longitud=0;
        if(!this.esVacia())
        {
            Nodo iter = this.cabecera;
            while(iter != null)
            {
                longitud++;
                iter = iter.getEnlace();
            }
        }
        return longitud;
    }
    /**Verifica si la Lista está vacía. Si está vacía, retorna True, sino false. */
    public boolean esVacia(){
        boolean res = false;
        if(this.cabecera == null)
        {
            res = true;
        }
        return res;
    }
    /**Vacía la Lista. Retorna void */
    public void vaciar(){
        this.cabecera = null;
    }
    /**Crea una instancia nueva de Lista, y clona los elementos de la Lista que invoca el método. Retorna la instancia Lista clonada */
    @Override
    public Lista clone(){
        Lista listaClonada = new Lista();
        if(!this.esVacia())
        {
            Nodo nodoAux = this.cabecera;
            while(nodoAux != null)
            {
                listaClonada.insertar(nodoAux.getElem(), listaClonada.longitud()+1);
                nodoAux = nodoAux.getEnlace();
            }
        }
        return listaClonada;
    }
    /**Retorna una instancia String, con el detalle de los elementos que componen la Lista */
    @Override
    public String toString(){
        String listaString;
        if(this.esVacia())
        {
            listaString = "La Lista está vacía";
        }
        else
        {
            listaString = "(Cabecera) -> ";
            Nodo nodoAux = this.cabecera;
            int iter = 1;
            while(nodoAux != null)
            {
                listaString += "[" + iter + " : " + nodoAux.getElem().toString() + " ] ";
                nodoAux = nodoAux.getEnlace();
                iter++;
            }
            listaString += " <- (Fin de la Fila)";
        }
        return listaString;
    }
}
