package estructuras.especiales.ColaPrioridad.Cola;

import estructuras.lineales.dinamicas.Cola;

public class ColaPrioridad {
    private NodoCP inicio;

    public ColaPrioridad()
    {
        this.inicio = null;
    }

    public boolean insertar(Object elemento, int prioridad)
    {
        boolean exito = false;
        
        return exito;
    }

    public boolean eliminarFrente()
    {
        boolean exito = false;

        return exito;
    }

    public Object obtenerFrente()
    {
        Object res = null;
        if(!this.esVacia())
        {
            Cola items = this.inicio.getItems();
        }
        return res;
    }

    public boolean esVacia()
    {
        boolean res = false;
        if(this.inicio == null)
        {
            res = true;
        }
        return res;
    }

}
