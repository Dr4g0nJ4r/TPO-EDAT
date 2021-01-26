package estructuras.jerarquicas.dinamicas;
/**Árbol binario
 * Estructura que permite organizar un conunto de datos de forma jerárquica.
 * La particularidad de este árbol es que cada nodo puede tener como máximo 2 hijos.
 */
public class ArbolBinario {
    /**Crea un árbol binario vacío */
    public ArbolBinario(){

    }

    /**Dado un elemento elemNuevo y un elemento elemPadre, inserta elemNuevo como hijo izquierdo o derecho de la primer aparición de elemPadre, según lo indique el parámetro posicion. Para que la operación termine con éxito debe existir un nodo en el árbol con elemento = elemPadre y ese nodo debe tener libre su hijo posición. Si se puede realizar la inserción devuelve true, en caso contrario devuelve false */
    public insertar(Object elemNuevo, Object elemPadre, char posicion)
    {

    }

    /**Devuelve false si hay al menos un elemento cargado en el árbol y verdadero en caso contrario */
    public boolean esVacio(){

    }

    /**Devuelve la altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja (un árbol vacío tiene nivel -1) */
    public int altura(){

    }

    /**Devuelve el nivel de un elemento en el árbol. Si el elemento no existe en el árbol, retorna -1 */
    public int nivel(Object elemento)
    {

    }

    /**Dado un elemento devuelve el valor almacenado en su nodo padre (busca la primer aparición de elemento) */
    public Object padre(Object elemento)
    {

    }

    /**Devuelve una lista con los elementos del árbol binario en el recorrido en preorden */
    public Lista listarPreorden()
    {

    } 

    /**Devuelve una lista con los elementos del árbol binario en el recorrido en inorden */
    public Lista listarInorden()
    {

    }

    /**Devuelve una lista con los elementos del árbol binario en el recorrido en posorden */
    public Lista listarPosorden(){

    }

    /**Devuelve una lista con los elementos del árbol binario en el recorrido por niveles */
    public Lista listarNiveles(){

    }

    
    /**Genera y devuelve un árbol binario que es equivalente al árbol que invoca el método */
    @Override
    public ArbolBinario clone(){

    }

    /**Quita todos los elementos de la estructura */
    public void vaciar()
    {
    }

    /**Genera y devuelve una cadena de caracteres que indica cuál es la raíz del nodo y quienes son los hijos de cada nodo */
    @Override
    public String toString(){

    }
}
