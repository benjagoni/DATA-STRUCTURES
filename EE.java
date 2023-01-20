/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;
import Listas.IteratorEE;
import Listas.Nodo;
import java.util.Iterator;
import Temas_I.PilaADT;
import Temas_I.PilaA;
/**
 *
 * @author jerusa
 */
public class EE <T> implements Iterable<T> {
    private Nodo<T> first;
    private Nodo<T> last;
    
    public EE(){
        first=null;
        last=null;
    }
    
    public T getFirst(){
        return first.getDato();
    }
    
    public T getLast(){
        return last.getDato();
    }
    
    public boolean isEmpty(){
        return first==null;
    }
//    
//    public void addB(T dato){
//
//    }
    
//    public void addE(T dato){
//
//    }
    

    
    public Iterator<T> iterator(){
        return new IteratorEE(first);
    }
    
//    public T removeFirst(){
//
//    }

    
//    public String toString(){
//
//    }
    
    
//    public String toStringR(){
//
//    }

    

    
//    public T buscaR(T dato){
//
//    }
    
//    private T buscaR(T d, Nodo<T> a){
//
//        
//    }
    
//    public T removeLast(){
//
//    }

   
    
    
}
    

