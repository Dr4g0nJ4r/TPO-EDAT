package estructuras.jerarquicas.dinamicas;
import estructuras.lineales.dinamicas.Lista;
import estructuras.lineales.dinamicas.Pila;
/**ArbolGenerico*/
public class ArbolGenerico {
    private NodoGen raiz;

    /**Crea un árbol genérico vacío */
    public ArbolGenerico()
    {
        this.raiz = null;
    }

    /** Dado un elemento elemento y un elemento elemPadre, agrega elemento como hijo de la primera aparición de elemPadre. Para que la operación termine con éxito debe existir un nodo en el árbol con elemento = elemPadre. No se establece ninguna preferencia respecto a la posición del hijo respecto a sus posibles hermanos*/
    public boolean insertar(Object elemento, Object elemPadre)
    {
        boolean exito = true;
        if(this.esVacio())
        {
            this.raiz = new NodoGen(elemento);
        }
        else
        {
            NodoGen nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if(nodoPadre == null)
            {
                exito = false;
            }
            else
            {
                NodoGen nodoAux = nodoPadre.getHijoIzquierdo();
               if(nodoAux == null)
               {
                   nodoPadre.setHijoIzquierdo(new NodoGen(elemento));
               }
               else
               {
                    while(nodoAux.getHermano() != null)
                    {
                        nodoAux = nodoAux.getHermano();
                    }
                    nodoAux.setHermano(new NodoGen(elemento));
               }
            }   
        }
        return exito;
    }

    /**Devuelve verdadero si el elemento pasado por parámetro está en el árbol y falso en caso contrario */
    public boolean pertenece(Object elemento)
    {
        boolean res = true;
        NodoGen nodoAux = obtenerNodo(this.raiz, elemento);
        if(nodoAux == null)
        {
            res = false;
        }
        return res;
    }

    /**Devuelve falso si hay al menos un elemento cargado en el árbol y verdadero en caso contrario */
    public boolean esVacio()
    {
        boolean res = false;
        if(this.raiz == null)
        {
            res = true;
        }
        return res;
    }

    /**Dado un elemento devuelve el valor almacenado en su nodo padre(busca la primera aparición de elemento) */
    public Object padre(Object elemento)
    {
        return padreAux(this.raiz, elemento);
    }
    
    //Método auxiliar que retorna el elemento del nodo padre del elemento buscado.
    private Object padreAux(NodoGen nodo, Object elemento)
    {
        Object padre = null;
        //Caso base nodo = null
        if(nodo != null)
        {
            NodoGen nodoHijo = nodo.getHijoIzquierdo();
            if(nodoHijo != null)
            {
                if(nodoHijo.equals(elemento))
                {
                    padre = nodoHijo.getElemento();
                }else{
                    while(nodoHijo.getHermano() != null && padre != null)
                    {
                        if(nodoHijo.equals(elemento))
                        {
                            padre = nodo.getElemento();
                        }else{
                            nodoHijo = nodoHijo.getHermano();
                        } 
                    }
                }
                
            }
        }
        return padre;
    }

    /**Devuelve la altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja (la altura de un árbol vacío es -1, la altura de una hoja es 0) */
    public int altura()
    {
        return alturaRecursivo(this.raiz);
    }

    /**Método auxiliar de altura. Recorre el árbol y retorna su altura.*/
    private int alturaRecursivo(NodoGen nodo)
    {
        int altura = -1;
        if(nodo != null)
        {
            if(nodo.getHijoIzquierdo() != null)
            {
                NodoGen nodoAux = nodo.getHijoIzquierdo();
                int altura_aux;
                int altura_mayor = 0;
                while(nodoAux != null)
                {
                    altura_aux = 1 + alturaRecursivo(nodo.getHijoIzquierdo());
                    if(altura_aux > altura_mayor)
                    {
                        altura_mayor = altura_aux;
                    }
                    nodoAux = nodoAux.getHermano();
                }
                altura = altura_mayor;
            }
        }
        return altura;
    }

    /**Devuelve el nivel de un elemento en el árbol. Si el elemento no existe en el árbol devuelve -1 */
    public int nivel(Object elemento)
    {
        return nivelRecursivo(this.raiz, elemento, 0);    
    }

    /**Método privado que retorna el nivel de un elemento dado */
    private int nivelRecursivo(NodoGen nodo, Object elemento, int nivel)
    {
        int tempo = -1;
        //Caso base
        if(nodo != null)
        {
            if(nodo.getElemento().equals(elemento))
            {
                tempo = nivel;
            }else{
                NodoGen nodoAux = nodo.getHijoIzquierdo();
                while(nodoAux != null && tempo == -1)
                {
                    tempo = nivelRecursivo(nodoAux, elemento, nivel+1);
                    nodoAux = nodoAux.getHermano();
                }
            }
        }
        return tempo;
    }

    /**Si el elemento se encuentra en el árbol, devuelve una lista con el camino desde la raiz hasta dicho elemento (es decir, con los ancestros del elemento). Si el elemento no está en el árbol devuelve la lista vacía */
    public Lista ancestros(Object elemento)
    {
        Lista listaAncestros = new Lista();
        Pila pilaAncestros = new Pila();
        ancestroRecursivo(this.raiz, elemento, pilaAncestros); 
        while(!pilaAncestros.esVacia())
        {
            listaAncestros.insertar(pilaAncestros.obtenerTope(), listaAncestros.longitud()+1);
            pilaAncestros.desapilar();
        }
        return listaAncestros;
    }

    /**Método privado recursivo. Busca un elemento y agrega a la Pila los elementos padres */
    private boolean ancestroRecursivo(NodoGen nodo, Object elemento, Pila pila)
    {
        boolean encontrado = false;
        if(nodo != null)
        {
            if(nodo.getElemento().equals(elemento))
            {
                encontrado = true;
                pila.apilar(nodo.getElemento());
            }
            else{
                if(nodo.getHijoIzquierdo() != null)
                {
                    NodoGen nodoAux = nodo.getHijoIzquierdo();
                    while(!encontrado && nodoAux != null)
                    {
                        encontrado = ancestroRecursivo(nodo.getHijoIzquierdo(), elemento, pila);
                        encontrado = ancestroRecursivo(nodo.getHermano(), elemento, pila);
                        if(encontrado)
                        {
                            pila.apilar(nodo.getElemento());
                        }
                        nodoAux = nodoAux.getHermano();
                    }
                }
            }
        }
        return encontrado;
    }

    /**Genera y devuelve un árbol genérico que es equivalente que el árbol original*/
    @Override
    public ArbolGenerico clone()
    {
        ArbolGenerico clon = new ArbolGenerico();
        if(!this.esVacio())
        {
            clon.insertar(this.raiz, null);
            cloneRecursivo(this.raiz, clon);
        }
        return clon;
    }

    /**Método privado que recorre recursivamente un árbol y copia tal cual los nodos en el nuevo arbol */
    private void cloneRecursivo(NodoGen nodo, ArbolGenerico arbol)
    {
        if(nodo != null)
        {
            if(nodo.getHijoIzquierdo() != null)
            {
                NodoGen nodoAux = nodo.getHijoIzquierdo();
                while(nodoAux != null)
                {
                    arbol.insertar(nodoAux.getElemento(), nodo.getElemento());
                    nodoAux.getHermano();
                }
            }
        }
    }

    /**Quita todos los elementos de la estructura */
    public void vaciar()
    {
        this.raiz = null;
    }

    /**Devuelve una lista con los elementos del árbol en el recorrido preorden*/
    public Lista listarPreorden()
    {
        Lista listado = new Lista();
        listarPreordenAux(this.raiz, listado);
        return listado;
    }

    /**Método privado que agrega a la lista los elementos del árbol en el recorrido en preorden */
    private void listarPreordenAux(NodoGen nodo, Lista lista)
    {
        if(nodo != null)
        {
            lista.insertar(nodo.getElemento(), lista.longitud()+1);
            NodoGen nodoAux = nodo.getHijoIzquierdo();
            while(nodoAux != null)
            {
                listarPreordenAux(nodoAux, lista);
                nodoAux = nodoAux.getHermano();
            }
        }
    }

    /**Devuelve una lista con los elementos del árbol en el recorrido inorden */
    public Lista listarInorden()
    {
        Lista listado = new Lista();
        listarInordenAux(this.raiz, listado);
        return listado;
    }

    /** */
    private void listarInordenAux(NodoGen nodo, Lista lista)
    {
        if(nodo != null)
        {
            NodoGen nodoAux = nodo.getHijoIzquierdo();
            if(nodoAux != null)
            {
                listarInordenAux(nodoAux,lista);
                nodoAux = nodoAux.getHermano();
            }
            lista.insertar(nodo.getElemento(), lista.longitud()+1);
            while(nodoAux != null)
            {
                listarInordenAux(nodoAux, lista);
                nodoAux = nodoAux.getHermano();
            }
        }
    }

    /**Devuelve una lista con los elementos del árbol en el recorrido posorden */
    public Lista listarPosorden()
    {
        Lista listado = new Lista();
        listarPosordenAux(this.raiz, listado);
        return listado;
    }

    /**Método privado que recorren en posorden los elementos del árbol y los agrega a la Lista */
    private void listarPosordenAux(NodoGen nodo, Lista lista)
    {
        if(nodo != null)
        {
            NodoGen nodoAux = nodo.getHijoIzquierdo();
            while(nodoAux != null)
            {
                listarPosordenAux(nodoAux, lista);
                nodoAux = nodoAux.getHermano();
            }
            lista.insertar(nodo.getElemento(), lista.longitud() +1);
        }
    }

    /**Devuelve una lista con los elementos del árbol en el recorrido por niveles */
    public Lista listarPorNiveles()
    {
        Lista listado = new Lista();
        listarPorNivelesAux(this.raiz, listado);
        return listado;
    }

    /**Método privado que recorre los elementos del árbol por niveles y lo agrega a la Lista */
    private void listarPorNivelesAux(NodoGen nodo, Lista lista)
    {
        if(nodo != null)
        {
            NodoGen nodoAux = nodo;
            while(nodoAux != null)
            {
                lista.insertar(nodo.getElemento(), lista.longitud()+1);
                nodoAux = nodoAux.getHermano();
            }
            listarPorNivelesAux(nodo.getHijoIzquierdo(), lista);
        }
    }

    /**Genera y devuelve una cadena de carácteres que indica cuál es la raíz del árbol y quienes son los hijos de cada nodo */
    @Override
    public String toString()
    {
        String res = "";
        if(this.esVacio())
        {
            res = "El árbol está vacío";
        }else{
            res = this.toStringAux(this.raiz);
        }
        return res;
    }

    /**Método privado que recorre los elementos del árbol y devuelve la descripción del Nodo */
    private String toStringAux(NodoGen nodo)
    {
        String res = "";
        if(nodo != null)
        {
            res += "Nodo -> " + nodo.getElemento().toString();
            res += " - Hijos (";
            NodoGen nodoHijo = nodo.getHijoIzquierdo();
            while(nodoHijo != null)
            {
                res += nodoHijo.getElemento().toString() + " / ";
                nodoHijo = nodoHijo.getHermano();
            }
            res += ")\n";
            NodoGen nodoAux = nodo.getHermano();
            while(nodoAux != null)
            {
                toStringAux(nodoAux);
                nodoAux = nodoAux.getHermano();
            }
        }
        return res;
    }

    /**Método que busca el nodo que contiene el elemento pasado por parámetro. Si lo encuentra, retorna la instancia del nodo. Sino, retorna null*/
    private NodoGen obtenerNodo(NodoGen nodo, Object elem)
    {
        NodoGen resultado = null;
        //Caso Recursivo. (caso base si nodo == null)
        if(nodo != null)
        {
            if(nodo.getElemento().equals(elem))
            {
                resultado = nodo;
            }else{
                resultado = obtenerNodo(nodo.getHijoIzquierdo(), elem);
                if(resultado == null)
                {
                    resultado = obtenerNodo(nodo.getHermano(), elem);
                }
            }
        }
        return resultado;
    } 
}
