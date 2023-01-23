/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatosavanzadas;

/**
 *
 * @author benjagoni
 */
public class MaxHeap <T extends Comparable<T>>{
    T[] datos;
    int cont;
    
    public MaxHeap() {
        this.cont = 0;
    }
    
    public MaxHeap(T elem) {
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
    
    public void inserta(T elem) {// como adaptar de min a max
        datos[cont] = elem;
        boolean indicador = false;
        T aux;
        while(!indicador && datos[1] != elem) {
            if(datos[cont].compareTo(datos[cont/2]) >= 0) {// probar si con solo cambiar a mayor o igual es efectivo insertar
                aux = (T) datos[cont];
                datos[cont] = datos[cont/2];
                datos[cont/2] = aux;
            } else {
                indicador = true;
            }
        }
    }
    
    public T buscaMax() {// estar conciente de que pasa si no lo encuentra al usar metodo, es decir, ser conciente de que regresa null
        T resp = null;
        
        if(cont > 0) {
            resp = datos[1];
        }
        
        return resp;
    }
    
    public void borraMax() {// 
        if(buscaMax() == null) {
            
        } else if(datos[2] == null) {
            datos[1] = null;
        } else {
            
        }
    }
}
