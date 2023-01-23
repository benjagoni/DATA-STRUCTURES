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
public interface ColaADT <T>{
    public void agrega(T nuevo);
    public T quita();
    public T consultaPrimero();
    public boolean estaVacia();
    // Ejercicio 36
    public int cuentaElementos();
    public T consultaUltimo();
    public ArrayList<T> multiQuita(int n);
    
}
