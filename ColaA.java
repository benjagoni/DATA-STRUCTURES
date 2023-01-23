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
public class ColaA <T> implements ColaADT <T>{
    private T[] datos;
    private int fin;
    private int frente;
    private final int MAX = 20;
    
    public ColaA(){
        datos = (T[]) new Object[MAX];
        frente = -1;
        fin = -1;
    }
    
    public ColaA(int maximo){
        datos = (T[]) new Object[maximo];
        frente = -1;
        fin = -1;
    }
    
    public boolean estaVacia() {
        return frente == -1;
    }
    
    public T consultaPrimero() {
        if(estaVacia()) {
            throw new ExcepcionColeccionVacia("Cola sin elementos");
        }
        
        return datos[frente];
    }
   
    private void expandeCapacidad() {
        T[] nuevo = (T[])new Object[datos.length + 20];
        
        if(frente < fin) {
            for(int i = frente; i <= fin; i++) {
                nuevo[i] = datos[i];
            }
        } else {
            int j = 0;
            
            for(int i = frente; i < datos.length; i++) {
                nuevo[j] = datos[i];
                j++;
            }
            
            for(int i = 0; i <= fin; i++) {
                nuevo[j] = datos[i];
                j++;
            }
            frente = 0;
            fin = datos.length - 1;
        }
        
        datos = nuevo;
    }
    
    public void agrega(T nuevo) {
        if(frente == 0 && fin == datos.length - 1 || (fin + 1) == fin)
            expandeCapacidad();
        fin = (fin + 1) % datos.length;
        datos[fin] = nuevo;
        if(frente == -1)
            frente = 0;
    }
    
    public T quita() {
        if(estaVacia()) 
            throw new ExcepcionColeccionVacia("Cola sin elementos");
        
        T resultado = datos[frente];
        
        if(frente == fin) {
            frente = -1;
            fin = -1;
        }
        else {
            frente = (frente + 1) % datos.length;
        }
        
        return resultado;
    }
    
    // Ejercicio 36
    
    public T consultaUltimo() {
        if(estaVacia()) {
            throw new ExcepcionColeccionVacia();
        }
        
        return datos[fin];
    }
    
    public int cuentaElementos() {
        int total;
        
        if(estaVacia()) {
            total = 0;
        } else {
            
            if(fin >= frente) {
                total = fin - frente;
            } else {
                total = datos.length - frente + fin + 1;
            }
            
        }
        
        return total;
    }
    
//    public ArrayList <T> multiQuita(int n) {
//        ArrayList <T> resultado = new ArrayList();
//        
//        if(n <= cuentaElementos()) {
//            for(int i = 1; i <= n; i++)
//        }
//    }

    @Override
    public ArrayList<T> multiQuita(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


