/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatosavanzadas;

import java.util.Random;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author benjagoni
 */
public class SkipList <T extends Comparable<T>>{
    NodoSkip<T> cabeza, cola;
    int cont, numListas;
    Random rand;
    
    public SkipList() {
        this.cabeza = new NodoSkip();
        this.cola = new NodoSkip();
        
        cabeza.der = cola;
        cola.izq = cabeza;
        cont = 0;
        numListas = 1;
        this.rand = new Random();
        
    }
    
    public SkipList (T elem) {
        NodoSkip<T> nuevo = new NodoSkip(elem);
        this.cabeza = new NodoSkip();
        this.cola = new NodoSkip();
        this.rand = new Random();
        
        cabeza.der = nuevo;
        cola.izq = nuevo;
        nuevo.izq = cabeza;
        nuevo.der = cola;
        cont = 1;
        numListas = 1;
    }
    
    private void ligaIzqDer(NodoSkip<T> izquierdo, NodoSkip<T> derecho) {
        if(izquierdo == null || derecho == null) {
            return;
        }
        
        izquierdo.der = derecho;
        derecho.izq = izquierdo;
    }
    
    public <T> void inserta(T elem) {
        NodoSkip<T> actual = busca(elem);
        NodoSkip<T> nuevo = new NodoSkip(elem);
        
        nuevo.setDerecha(actual.der);
        nuevo.setIzquierda(actual);
        nuevo.der.setIzquierda(nuevo);
        actual.setDerecha(nuevo);
        cont++;
        
        Random rand = new Random();
        boolean valor = rand.nextBoolean();
        int limite = (int) (Math.log(cont)/Math.log(2)) + 1;
        int volados = 1;
        
        while(volados <= limite && valor == true) {
            valor = rand.nextBoolean();
            while(actual.) {
                
            }
        }
    }
    
    private void expande() {
        
    }    
    
    private void ligaAbajoArriba(NodoSkip<T> abajo, NodoSkip<T> arriba){
        if(abajo == null || arriba == null) {
            return
        }
        
        abajo.arriba = arriba;
        arriba.abajo = abajo;
        
    }  
    
    public <T> void borra(T elemento) {
      
        NodoSkip<T> actual = buscaCLASE(elemento);
        
        if(actual.elem == elemento) {
            while(actual != null) {
                ligaIzqDer(actual.abajo.izq, actual.abajo.der);
                actual = actual.arriba;
            }
        }
        
        if(numListas > 1 && numListas>(int)(Math.log(cont)/Math.log(2))) {
            cabeza= cabeza.abajo;
            cola = cola.abajo;
            actual = (NodoSkip<T>) cabeza;
            
            while(actual != null) {
                actual.arriba = null;
                actual = actual.der;
            }
            
            numListas--;///// no esta terminado todavia
        }
        
    }
        
        
            
            
    
    public <T> void insertaCLASE(T elem){
        NodoSkip<T> actual=buscaCLASE(elem);
        NodoSkip<T> nuevo=new NodoSkip<T>(elem);
        int volados=1;
        cont++;
        insertaHorizontal(actual,nuevo);
        while((volados<=1+Math.log(cont)/Math.log(2))&& rand.nextBoolean()) {
            if(numListas<volados) {
                expande();
              
            }

              
            while(actual.arriba==null)
            
                actual=actual.izq;
            }
              
            actual=actual.arriba;
            NodoSkip<T> nuevo2 =new NodoSkip<T>(elem);
            ligaHorizontal(actual,nuevo2);
            ligaAbajoArriba(nuevo,nuevo2);
            nuevo=nuevo2;
            volados++;
        }
    }
    
    private <T extends Comparable <T>> NodoSkip<T> busca(T elem) {
        NodoSkip actual = cabeza.der;
        boolean indicador = false;
        while(actual.elem != elem && actual != cola && actual != cabeza && !indicador) {
            if(actual.elem.)
        }
        
        if(actual.elem == elem) {
            return actual;
        } else {
            return actual.izq;
        }
    }
    
    private <T extends Comparable<T>> NodoSkip<T> buscaCLASE(T elem) {
        NodoSkip<T> actual = (NodoSkip<T>) cabeza; 
        boolean termine = false;
        while(!termine) {
            while(actual.der.elem != null && actual.der.elem.compareTo(elem) <= 0) {
                actual = actual.der;
            }
            
            if(actual.abajo != null) {
                actual = actual.abajo;
                
            } else {
                termine = true;

            }
            
        }
        
        return actual;
    }
}
