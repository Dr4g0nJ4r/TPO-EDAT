package estructuras.lineales.dinamicas;
    /**
 * TDA COLA
 * Características:
 *  - Estructura FIFO
 *  - Acceso al frente de la cola
 *  - Coloca los objetos a lo último de la cola (final)  
 */
public class Cola {
    private Nodo frente;
    private Nodo posterior; //En el TDA Cola es final, pero es palabra reservada de Java

    /**Constructor Cola. Retorna una instancia Cola vacía */
    public Cola(){
        this.frente = null;
        this.posterior = null; 
    }

    /**Coloca, si es posible, un elemento al final de la Cola. Si se coloca exitosamente, retorna true, sino false */
    public boolean poner(Object elem)
    {
        Nodo nuevoElemento;
        if(this.esVacia())
        {
            nuevoElemento = new Nodo(elem, null);
            this.frente = nuevoElemento;
            this.posterior = nuevoElemento;
        }else{
            nuevoElemento = new Nodo(elem, null);
            this.posterior.setEnlace(nuevoElemento);
            this.posterior = nuevoElemento;
        }
        return true;
    }

    /**Retira el elemento situado al frente de la Cola. Retorna true si se retiró el elemento, false sino */
    public boolean sacar()
    {
        boolean res = false;
        if(!this.esVacia())
        {
            this.frente = this.frente.getEnlace();
            res = true;
            //Si está vacia, posterior = null
            if(this.frente == null)
            {
                this.posterior = null;
            }
        }
        return res;
    }

    /**Retorna el elemento situado al frente de la Cola. Precondicion: la Cola no está vacía*/
    public Object obtenerFrente()
    {
        return this.frente.getElem();       
    }

    /**Comprueba que la Cola esté vacía. Si lo está, retorna true, sino false */
    public boolean esVacia(){
        boolean res = false;
        if(this.frente == null && this.posterior == null)
        {
            res = true;
        }
        return res;
    }
    
    /**Vacía la Cola. Retorna void*/
    public void vaciar()
    {
        while(!this.esVacia())
        {
            this.sacar();
        }
    }
    /**Retorna una instancia Cola, con los elementos clonados de la Cola que llama al método */
    @Override
    public Cola clone()
    {
        Cola colaClonada = new Cola();
        if(!this.esVacia())
        {
            Nodo iter = this.frente;
            while(iter != null)
            {
                colaClonada.poner(iter.getElem());
                iter = iter.getEnlace();
            }
        }
        return colaClonada;
    }

    /**Retorna una instancia String con los datos y la estructura de la Cola */
    @Override
    public String toString(){
        String res;
        if(this.esVacia()){
            res = "La Cola está vacía";
        }else{
            res = " (Frente)    ->  ";
            Nodo iter = this.frente;
            while(iter != null)
            {
                res += iter.getElem().toString() + " / ";
                iter = iter.getEnlace();
            }
            res += "    <-  (Final)";
        }
        return res;
    }
}
