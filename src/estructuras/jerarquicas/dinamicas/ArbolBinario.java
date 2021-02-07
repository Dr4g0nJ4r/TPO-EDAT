package estructuras.jerarquicas.dinamicas;

import estructuras.lineales.dinamicas.Cola;
import estructuras.lineales.dinamicas.Lista;

/**
 * Árbol binario Estructura que permite organizar un conunto de datos de forma
 * jerárquica. La particularidad de este árbol es que cada nodo puede tener como
 * máximo 2 hijos.
 */
public class ArbolBinario {
    private NodoBin raiz;
    /**Crea un árbol binario vacío */
    public ArbolBinario(){
        this.raiz = null;
    }

    /**Dado un elemento elemNuevo y un elemento elemPadre, inserta elemNuevo como hijo izquierdo o derecho de la primer aparición de elemPadre, según lo indique el parámetro posicion. Para que la operación termine con éxito debe existir un nodo en el árbol con elemento = elemPadre y ese nodo debe tener libre su hijo posición. Si se puede realizar la inserción devuelve true, en caso contrario devuelve false */
    public boolean insertar(Object elemNuevo, Object elemPadre, char posicion)
    {
        boolean exito = true;
        if(this.esVacio())
        {
            this.raiz = new NodoBin(elemNuevo);
        }
        else
        {
            NodoBin padre = this.obtenerNodo(this.raiz, elemPadre);
            if(padre != null)
            {
                if(posicion == 'I' && padre.getHijoIzquierdo() == null)
                {
                    padre.setHijoIzquierdo(new NodoBin(elemNuevo));
                }
                else if(posicion == 'D' && padre.getHijoDerecho() == null)
                {
                    padre.setHijoDerecho(new NodoBin(elemNuevo));
                }
                else
                {
                    exito = false;
                }
            }
            else
            {
                exito = false;
            }
        }
        return exito;
    }

    /**Devuelve false si hay al menos un elemento cargado en el árbol y verdadero en caso contrario */
    public boolean esVacio(){
        boolean resultado = false;
        if(this.raiz == null)
        {
            resultado = true;
        }
        return resultado;
    }

    /**Devuelve la altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja (un árbol vacío tiene nivel -1) */
    public int altura(){
        return this.alturaRecursivo(this.raiz);
    }
    /**Método auxiliar de altura. Recorre el árbol y retorna su altura.*/
    private int alturaRecursivo(NodoBin nodo)
    {
        int altura = -1;
        if(nodo != null)
        {
            int alturaIzq = 1 + alturaRecursivo(nodo.getHijoIzquierdo());
            int alturaDer = 1 + alturaRecursivo(nodo.getHijoDerecho());
            if(alturaIzq > alturaDer)
            {
                altura = alturaIzq;
            }
            else{
                altura = alturaDer;
            }
        }
        return altura;
    }
    
    /**Devuelve el nivel de un elemento en el árbol. Si el elemento no existe en el árbol, retorna -1 */
    public int nivel(Object elemento)
    {
        int resultado = nivelRecursivo(this.raiz, elemento, 0);
        return resultado;
    }
    
    /**Método privado que retorna el nivel de un elemento dado */
    private int nivelRecursivo(NodoBin nodo, Object elemento, int nivel)
    {
        int tempo = -1;
        //Caso base
        if(nodo != null)
        {
            if(nodo.getElemento().equals(elemento))
            {
                tempo = nivel;
            }else{
                tempo = nivelRecursivo(nodo.getHijoIzquierdo(), elemento, nivel+1);
                tempo = nivelRecursivo(nodo.getHijoDerecho(), elemento, nivel+1);
            }
        }
        return tempo;
    }

    /**Dado un elemento devuelve el valor almacenado en su nodo padre (busca la primer aparición de elemento) */
    public Object padre(Object elemento)
    {
        return this.padreAux(this.raiz, elemento);
    }

    //Método auxiliar que retorna el elemento del nodo padre del elemento buscado.
    private Object padreAux(NodoBin nodo, Object elemento)
    {
        Object padre = null;
        //Caso base nodo = null
        if(nodo != null)
        {
            if(nodo.getHijoDerecho() != null && nodo.getHijoDerecho().getElemento().equals(elemento) || nodo.getHijoIzquierdo() != null && nodo.getHijoIzquierdo().getElemento().equals(elemento))
            {
                padre = nodo.getElemento();
            }
            else
            {
                padre = padreAux(nodo.getHijoIzquierdo(), elemento);
                if(padre == null)
                {
                    padre = padreAux(nodo.getHijoDerecho(), elemento);
                }
            }
        }
        return padre;
    }
    
    /**Devuelve una lista con los elementos del árbol binario en el recorrido en preorden */
    public Lista listarPreorden()
    {
        Lista lista = new Lista();
        this.listarPreordenAux(this.raiz, lista);
        return lista;
    } 
    //Método auxiliar recursivo para listar Preorden
    private void listarPreordenAux(NodoBin nodo, Lista lista)
    {
        //Caso base nodo = null
        if(nodo != null)
        {
            lista.insertar(nodo.getElemento(), lista.longitud()+1);
            listarPreordenAux(nodo.getHijoIzquierdo(), lista);
            listarPreordenAux(nodo.getHijoDerecho(), lista);
        }
    }

    /**Devuelve una lista con los elementos del árbol binario en el recorrido en inorden */
    public Lista listarInorden()
    {
        Lista lista = new Lista();
        this.listarInordenAux(this.raiz, lista);
        return lista;
    }

    //Método auxiliar recursivo de listarInorden
    private void listarInordenAux(NodoBin nodo, Lista lista)
    {
        //Caso base
        if(nodo != null)
        {
            listarInordenAux(nodo.getHijoIzquierdo(), lista);
            lista.insertar(nodo.getElemento(), lista.longitud() + 1);
            listarInordenAux(nodo.getHijoDerecho(), lista);
        }
    }

    /**Devuelve una lista con los elementos del árbol binario en el recorrido en posorden */
    public Lista listarPosorden(){

        Lista lista = new Lista();
        listarPosordenAux(this.raiz, lista);
        return lista;
    }

    //Método auxiliar recursivo de listar Posorden
    private void listarPosordenAux(NodoBin nodo, Lista lista)
    {
        //Caso base
        if(nodo != null)
        {
            listarPosordenAux(nodo.getHijoIzquierdo(), lista);
            listarPosordenAux(nodo.getHijoDerecho(), lista);
            lista.insertar(nodo.getElemento(), lista.longitud()+1);
        }
    } 

    /**Devuelve una lista con los elementos del árbol binario en el recorrido por niveles */
    public Lista listarNiveles(){
        Lista lista = new Lista();
        Cola cola = new Cola();
        if(!this.esVacio())
        {
            NodoBin nodo = this.raiz;
            cola.poner(nodo);
            while(!cola.esVacia())
            {
                nodo = (NodoBin) cola.obtenerFrente();
                lista.insertar(nodo.getElemento(), lista.longitud()+1);
                if(nodo.getHijoIzquierdo() != null)
                {
                    cola.poner(nodo.getHijoIzquierdo());
                }
                if(nodo.getHijoDerecho() != null){
                    cola.poner(nodo.getHijoDerecho());
                }
                cola.sacar();
            }
        }
        return lista;
    }

    
    /**Genera y devuelve un árbol binario que es equivalente al árbol que invoca el método */
    @Override
    public ArbolBinario clone(){
        ArbolBinario clon = new ArbolBinario();
        if(!this.esVacio())
        {
            clon.insertar(this.raiz.getElemento(), this.raiz, 'D');
            this.cloneAux(this.raiz, clon);
        }
        return clon;
    }

    //Método auxiliar recursivo para clonar árbol
    private void cloneAux(NodoBin nodo, ArbolBinario arbolClon)
    {
        //Caso base
        if(nodo != null)
        {
            if(nodo.getHijoIzquierdo() != null)
            {
                arbolClon.insertar(nodo.getHijoIzquierdo().getElemento(), nodo.getElemento(), 'I');
            }
            if(nodo.getHijoDerecho() != null)
            {
                arbolClon.insertar(nodo.getHijoDerecho().getElemento(), nodo.getElemento(), 'D');
            }
            this.cloneAux(nodo.getHijoIzquierdo(), arbolClon);
            this.cloneAux(nodo.getHijoDerecho(), arbolClon);
        }
    }

    /**Quita todos los elementos <de la estructura */
    public void vaciar()
    {
        this.raiz = null;
    }

    /**Genera y devuelve una cadena de caracteres que indica cuál es la raíz del nodo y quienes son los hijos de cada nodo */
    @Override
    public String toString(){
        String res;
        if(this.esVacio())
        {
            res = "El árbol está vacío";
        }else{
            res = this.toStringAux(this.raiz);
        }
        return res;
    }
    //Método auxiliar recursivo que retorna un String con el contenido del árbol
    private String toStringAux(NodoBin nodo)
    {
        String res = "";
        //Caso base -> Nodo == null
        if(nodo != null)
        {
            res += "Nodo " + nodo.getElemento().toString()+ " ";
            res += "(";
            if(nodo.getHijoIzquierdo() != null)
            {
                res += nodo.getHijoIzquierdo().getElemento().toString() + "";
            }
            res += "/";
            if(nodo.getHijoDerecho() != null)
            {
                res += nodo.getHijoDerecho().getElemento().toString() + " ";
            }
            res += ")\n";
            res += this.toStringAux(nodo.getHijoIzquierdo());
            res += this.toStringAux(nodo.getHijoDerecho());
        }
        return res;
    } 

    /**Método que busca el nodo que contiene el elemento pasado por parámetro. Si lo encuentra, retorna la instancia del nodo. Sino, retorna null*/
    private NodoBin obtenerNodo(NodoBin nodo, Object elem)
    {
        NodoBin resultado = null;
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
                    resultado = obtenerNodo(nodo.getHijoDerecho(), elem);
                }
            }
        }
        return resultado;
    } 
}
