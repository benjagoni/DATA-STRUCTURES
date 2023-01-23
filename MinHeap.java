/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatosavanzadas;

import static javafx.scene.input.KeyCode.T;
/**
 *
 * @author benjagoni
 */
public class MinHeap <T extends Comparable<T>> {
    T[] datos;
    int cont;
    
    public MinHeap() {
        this.cont = 0;
    }
    
    public MinHeap(T elem) {
        this.datos[1] = elem;
        cont = 1;
    } 
    
    public void imprimePorNivel() {
        int nivel = 1;
        int i;
        for(i = 1; i <= cont; i++) {
            while(i < Math.pow(2, nivel)) {
                System.out.println(datos[i] + "  ");
            }
            nivel++;
            System.out.println("\n");
        }
    }
    
    public void inserta(T elem) {
        datos[cont] = elem;
        boolean indicador = false;
        T aux;
        while(!indicador && datos[1] != elem) {
            if(datos[cont].compareTo(datos[cont/2]) < 0) {
                aux = (T) datos[cont];
                datos[cont] = datos[cont/2];
                datos[cont/2] = aux;
            } else {
                indicador = true;
            }
        }
    }
    
    public T buscaMin() {
        T resp = null;
        
        if(cont > 0) {
            resp = datos[1];
        }
        
        return resp;
    }
    
    public void borraMin() {
        if(buscaMin() == null) {
            
        } else if(datos[2] == null) {
            datos[1] = null;
        } else {
            
        }
    }
       
}
