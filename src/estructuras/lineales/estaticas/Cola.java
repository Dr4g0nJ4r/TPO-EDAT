package estructuras.lineales.estaticas;

/**
 * TDA COLA
 * Características:
 *  - Estructura FIFO
 *  - Acceso al frente de la cola
 *  - Coloca los objetos a lo último de la cola (final)  
 */
public class Cola {
    private static int TAM = 6;
    private Object[] arreglo;
    private int frente;
    private int posterior; //En el TDA Cola es final, pero es palabra reservada de Java

    /**Constructor Cola. Retorna una instancia Cola vacía */
    public Cola(){
        arreglo = new Object[TAM];
        this.frente = -1;
        this.posterior = -1;
    }

    /**Coloca, si es posible, un elemento al final de la Cola. Si se coloca exitosamente, retorna true, sino false */
    public boolean poner(Object elem)
    {
        boolean res;
        if(this.estaLlena())
        {
            res = false; 
        }else{
            this.arreglo[this.posterior] = elem;
            this.posterior++;
            this.posterior%=TAM;
            res = true;
        }
        return res;
    }

    /**Retira el elemento situado al frente de la Cola. Retorna true si se retiró el elemento, false sino */
    public boolean sacar()
    {
        boolean res = false;
        if(!this.esVacia())
        {
            this.arreglo[this.frente] = null;
            this.frente++;
            this.frente%=TAM;
            res = true;
        }
        return res;
    }

    /**Retorna el elemento situado al frente de la Cola. Precondicion: la Cola no está vacía*/
    public Object obtenerFrente()
    {
        return this.arreglo[this.frente];       
    }

    /**Comprueba que la Cola esté vacía. Si lo está, retorna true, sino false */
    public boolean esVacia(){
        boolean res = false;
        if(this.frente == this.posterior)
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
        int iter = this.frente;
        while(iter != this.posterior)
        {
            colaClonada.poner(arreglo[iter]);
            iter++;
            iter%=TAM;
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
            res = " (Frente) ->  ";
            int iter = this.frente;
            while(iter != this.posterior)
            {
                res += this.arreglo[iter].toString() + "    ";
            }
            res+= "     <- (Final)";
        }
        return res;
    }


    /**Comprueba si la Cola está llena o no. True si está llena, false sino */
    private boolean estaLlena()
    {
        boolean res = false;
        if(this.frente == ((this.posterior+1) % TAM))
        {
            res = true;
        }
        return res;
    }
}
