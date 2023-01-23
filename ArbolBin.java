/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatosavanzadas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author benjagoni
 */
public class ArbolBin <T> implements BinaryTreeADT <T> {
    
    NodoBin <T> raiz;
    int cont;
   
    public boolean isEmpty() {
        return cont == 0;
    }

    public int size() {
        return cont;
    }

    public boolean contains(T element) {
        
        if(!isEmpty()) {
            ExcepcionColeccionVacia e = new ExcepcionColeccionVacia("Esta vacia");
        }
        
        return contains(element, raiz);
    }
    
    private boolean contains(T element, NodoBin<T> actual) {
        if(actual.elem == element) {
            return true;
        }
        
        if(actual.izq != null) {
            return contains(element, actual.izq);
        }
        
        if(actual.der != null) {
            return contains(element, actual.der);
        }
        
        return false;
    }
    
    public void agregaPreOrden() {
        ArrayList <T> lista = new ArrayList();
        
        if(!isEmpty() && raiz != null) {
            agregaPreOrden(raiz, lista);
        } else {
            ExcepcionColeccionVacia e = new ExcepcionColeccionVacia("Esta vacia");
        }
    }
    
    private void agregaPreOrden(NodoBin <T> nodo, ArrayList <T> lista) {
        lista.add(nodo.elem);
        if(nodo.izq != null) {
            agregaPreOrden(nodo.izq, lista); 
        }
        
        if(nodo.der != null) {
            agregaPreOrden(nodo.der, lista);
        }
    }
    
    public void agregaPreOrdenESPONDA() {
        ArrayList <T> lista = new ArrayList();
        
        if(!isEmpty()) {
            agregaPreOrdenESPONDA(raiz, lista);
        } else {
            ExcepcionColeccionVacia e = new ExcepcionColeccionVacia("Esta vacia");
        }
    }
    
    public Iterator<T> agregaPreOrdenIterativo() {
        ArrayList<T> lista = new ArrayList<T>();
        Stack<NodoBin<T>> pila = new Stack<NodoBin<T>>();
        
        pila.push(raiz);
        
        while(!pila.isEmpty()) {
            NodoBin <T> actual = pila.pop();
            lista.add(actual.elem);
            
            if(actual.der != null) {
                pila.push(actual.der);
            }
            
            if(actual.izq != null) {
                pila.push(actual.izq);
            }
        }
        
        return lista.iterator();
    }   
    
    
    
    private void agregaPreOrdenESPONDA(NodoBin<T> nodo, ArrayList <T> lista) {
        if(nodo == null) { //"factorizas" los ifs
            return;
        }
        
        lista.add(nodo.elem);
        agregaPreOrdenESPONDA(nodo.izq, lista);
        agregaPreOrdenESPONDA(nodo.der, lista);
    }
    
    public void agregaPostOrden() {
        ArrayList <T>
    }
    
    public void inOrden() {
        
    }
    
    public void porNivel() { //
        
    }
    
    public NodoBin<T> busca(T dato) {
        
        
    }
    
    private <NodoBin<T> extends Comparable T> busca(Nodo<T> actual, T dato) {
        if(actual == null) {
            return
        } 
        
        
    }
    
}
