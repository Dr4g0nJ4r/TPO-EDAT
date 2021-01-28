package estructuras.jerarquicas.estaticas;
import estructuras.lineales.dinamicas.Lista;
import estructuras.lineales.dinamicas.Cola;
/**Árbol binario
 * Estructura que permite organizar un conunto de datos de forma jerárquica.
 * La particularidad de este árbol es que cada nodo puede tener como máximo 2 hijos.
 */
public class ArbolBinario {
    private static int TAM = 5;
    private CeldaBin[] arbol;
    private int raiz;

    /**Crea un árbol binario vacío */
    public ArbolBinario(){
        this.arbol = new CeldaBin[TAM];
        this.raiz = -1;
    }

    /**Dado un elemento elemNuevo y un elemento elemPadre, inserta elemNuevo como hijo izquierdo o derecho de la primer aparición de elemPadre, según lo indique el parámetro posicion. Para que la operación termine con éxito debe existir un nodo en el árbol con elemento = elemPadre y ese nodo debe tener libre su hijo posición. Si se puede realizar la inserción devuelve true, en caso contrario devuelve false */
    public boolean insertar(Object elemNuevo, Object elemPadre, char posicion)
    {
        boolean res = true;
        //Si el árbol está vació, lo inserta como raíz. Sino, busca al Padre para insertarlo
        if(this.esVacio())
        {
            this.raiz = 0;
            this.arbol[0].setElem(elemNuevo);
        }else{
            int posicionPadre = this.raiz;
            Cola celdas = new Cola();
            celdas.poner(arbol[this.raiz]);
            boolean seEncontro = false;
            while(res && !seEncontro && !celdas.esVacia())
            {
                CeldaBin celda = (CeldaBin) celdas.obtenerFrente();
                if(celda.getElem().equals(elemPadre))
                {
                    if(posicion == 'I')
                    {
                        if(this.arbol[celda.getIzquierdo()].isEnUso())
                        {
                            res = false;
                        }else{
                            seEncontro = true;
                            this.arbol[celda.getIzquierdo()].setElem(elemNuevo);
                            celda.setIzquierdo(celda.getIzquierdo());
                        }
                    }else{
                        if(posicion == 'D')
                        {
                            if(this.arbol[celda.getDerecho()].isEnUso())
                        {
                            res = false;
                        }else{
                            seEncontro = true;
                            this.arbol[celda.getDerecho()].setElem(elemNuevo);
                            celda.setDerecho(celda.getDerecho());
                        }
                        }
                    }
                }else{
                    if(celda.getIzquierdo() > 0)
                    {
                        celdas.poner(this.arbol[celda.getIzquierdo()]);
                    }
                    if(celda.getDerecho() > 0)
                    {
                        celdas.poner(this.arbol[celda.getDerecho()]);
                    }
                }
                celdas.sacar();
            }
        }
    }

    /**Devuelve false si hay al menos un elemento cargado en el árbol y verdadero en caso contrario */
    public boolean esVacio(){
        boolean res = false;
        if(this.raiz == -1)
        {
            res = true;
        }
        return res;
    }

    /**Devuelve la altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja (un árbol vacío tiene nivel -1) */
    public int altura(){
        int altura;
        if(this.esVacio())
        {
            altura = -1;
        }else{
            altura = this.alturaAuxRecursivo(this.arbol[this.raiz]);
        }
        return altura;
    }

    //Método privado que recorre recursivamente el arreglo.
    private int alturaAuxRecursivo(CeldaBin celda){
        int alt = 0;
        //caso base
        if(celda.getDerecho() == -1 || celda.getIzquierdo() == -1)
        {
            alt = 0;
        }
        else
        {
            int alturaDerecha = 0; 
            int alturaIzquierda = 0;
            if(celda.getDerecho() != -1)
            {
                alturaDerecha = 1 + alturaAuxRecursivo(this.arbol[celda.getDerecho()]);
            }
            if(celda.getIzquierdo() != -1)
            {
                alturaIzquierda = 1 + alturaAuxRecursivo(this.arbol[celda.getIzquierdo()]);
            }
            if(alturaDerecha > alturaIzquierda)
            {
                alt = alturaDerecha;
            }else{
                alt = alturaIzquierda;
            }
        }
        return alt;
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

    /**
     * Busca la próxima posición libre dentro del arreglo del árbol
     * @return Int con la próxima posición libre. Si el arreglo está lleno, retorna -1 
     * */
    private int posicionLibre(){
        int libre = -1;
        int iter = 0;
        while(libre != -1 && iter < this.arbol.length)
        {
            if(!this.arbol[iter].isEnUso())
            {
                libre = iter;
            }else{
                iter++;
            }
            
        }
        return libre;
    }

    /**Comprueba que el arreglo árbol esté lleno. True si es así, false sino */
    private boolean estaLlena(){
        boolean lleno = true;
        int iter = 0;
        while(lleno && iter < this.arbol.length)
        {
            if(!this.arbol[iter].isEnUso())
            {
                lleno = false;
            }else{
                iter++;
            }
            
        }
        return lleno;
    }
}
