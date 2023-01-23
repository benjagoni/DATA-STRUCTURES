/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatosavanzadas;

import java.util.ArrayList;

/**
 *
 * @author benjagoni
 */
public class ColaE <T> implements ColaADT<T>{
    private Nodo<T> frente;
    private Nodo<T> fin;
    
    public ColaE() {
        frente = null;
        fin = null;
    }

    @Override
    public void agrega(T dato) {
        Nodo<T> nuevo = new Nodo(dato);
        
        if(estaVacia()) {
            frente = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        
        fin = nuevo;
        
    }

    @Override
    public T quita() {
        if(estaVacia()) {
            throw new ExcepcionColeccionVacia("No hay datos");
        }
        
        Nodo<T> aux = frente;
        
        frente = frente.getSiguiente();
        aux.setSiguiente(null);
        
        if(frente == null) {
            fin = null;
        }
        
        return aux.getDato();
    }

    @Override
    public T consultaPrimero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estaVacia() {
        return frente == null;
    }

    @Override
    public int cuentaElementos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T consultaUltimo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<T> multiQuita(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
