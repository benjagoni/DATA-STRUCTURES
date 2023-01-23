/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatosavanzadas;

import java.util.ArrayList;
import java.util.Iterator;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author benjagoni
 */
public class ArbolBinarioBusqueda<T extends Comparable <T>> implements BinaryTreeADT <T>{
    
    NodoBB<T> raiz ;
    int cont;
        
    public ArbolBinarioBusqueda(){
        raiz=null;
        cont=0;
    } 
    
    public ArbolBinarioBusqueda(T elem){
        raiz=new NodoBB<T>(elem);
        cont=1;
    }

//////

    public boolean isEmpty(){
        return cont==0;
    }
  
    public int size(){
        return cont;
    }
  
  public Iterator<T> iteratorPreOrden(){
    ArrayList<T> lista=new ArrayList<T>();
    preOrden(raiz,lista);
    return lista.iterator();

  }
  private void preOrden(NodoBB<T> actual,ArrayList<T> lista){
      if(actual==null)
          return;
      lista.add(actual.getElem());//esto fue visitar
      preOrden(actual.getIzq(),lista);
      preOrden(actual.getDer(),lista);

  }
    public Iterator<T> iteratorInOrden(){
    ArrayList<T> lista=new ArrayList<T>();
    inOrden(raiz,lista);      

    return lista.iterator();

  }
    private void inOrden(NodoBB<T> actual,ArrayList<T> lista){
      if(actual==null)
          return;
      inOrden(actual.getIzq(),lista);
      lista.add(actual.getElem());//esto fue visitar
      inOrden(actual.getDer(),lista);
  }

public Iterator<T> iteratorPostOrden(){
    ArrayList<T> lista=new ArrayList<T>();
    postOrden(raiz,lista);
    return lista.iterator();

  }
  private void postOrden(NodoBB<T> actual,ArrayList<T> lista){
      if(actual==null)
          return;
      postOrden(actual.getIzq(),lista);
      postOrden(actual.getDer(),lista);
      lista.add(actual.getElem());//esto fue visitar

      
  }



///////  
public boolean contains(T elem){
      return busca(raiz, elem)!=null;
}

public NodoBB<T> busca(NodoBB<T> arbol, T elem){
    if(arbol == null)
        return arbol;
    
    if(arbol.getElem().compareTo(elem)<0)
        return busca(arbol.getDer(), elem);
    
    if(arbol.getElem().compareTo(elem)>0)
        return busca(arbol.getIzq(), elem);
    
    return arbol;
}

public NodoBB<T> search(NodoBB<T> tree, T element){
        if(tree == null)
            return null;
        
        NodoBB<T> aux;
        if(tree.getElem().compareTo(element) == 0){
            return tree;
        } else {
            if(tree.getElem().compareTo(element) > 0){
                aux = search(tree.getIzq(), element);
                return aux;
            } else {
                aux = search(tree.getDer(), element);
                return aux;
            }
        }
    }
 public void inserta(T elem){
   NodoBB<T> actual=raiz,anterior=raiz;
   if(raiz==null){
     raiz=new NodoBB<T>(elem);
     cont++;
     return;
   }

  while(actual!=null){
    anterior=actual;
    
    if(elem.compareTo(actual.getElem())<=0)
      actual=actual.getIzq();
    else 
      actual=actual.getDer();
    }
  
    anterior.cuelga(new NodoBB<T>(elem));
    cont++;
   
 }  
    
    public int alturaArbol() {// probar 
        if(raiz == null) {
            return 0;
        }
        return Math.max(alturaArbol(raiz.izq) , alturaArbol(raiz.der));
    }
    
    private int alturaArbol(NodoBB<T> actual) { // ver que aumente el conteo
        if(actual.izq == null && actual.der == null) {
            return cont + 1;
        } else {
            if(actual.izq != null) {
                if(actual.der != null) {
                    return Math.max(alturaArbol(actual.izq), alturaArbol(actual.der));
                } else {
                    return alturaArbol(actual.izq);
                }
            } else {
                return alturaArbol(actual.der);
            }
        }
        
    }
    
    public <T> void borra(T elemento) {
        NodoBB <T> actual = busca(raiz, elemento); // revisar metodo busca para ver porque pide castear elemento.
        if(actual == null) {
            return;
        }
        
        if(actual.getIzq() == null && actual.getDer()== null) {//hoja
            if(actual == raiz) {
                raiz = null;
            } else {
                if(actual == actual.papa.getIzq()) {
                    actual.papa.setIzq(null); 
                } else {
                    actual.papa.setDer(null);
                }
                
            }
            
            cont--;
        } else {
            if(actual.getIzq() == null || actual.getDer() == null) {
                if(actual.getIzq() != null) {
                    actual.hijo = actual.getIzq();
                } else {
                    hijo = actual.getDer();
                }
                
                if(raiz == actual) {
                    raiz = hijo;
                } else {
                    actual.papa.cuelga(hijo);
                }
                
                cont--;
            }
        }
    }
    
    public NodoBB<T> antecesorComunMinimaProx(NodoBB<T> nodo1, NodoBB<T> nodo2) {
        NodoBB actual = raiz;
        if(contains(nodo1.elem) && contains(nodo2.elem)) {
            if(nodo1 == raiz || nodo2 == raiz) {
                return null;
            } else {
                boolean found = false;
                if(nodo1.elem.compareTo(nodo2.elem) > 0) {
                    while(!found) {
                        if(actual.elem.compareTo(nodo2.elem) > 0 && actual.elem.compareTo(nodo1.elem) < 0) {
                            found = true;
                        } else {
                            if(actual.elem.compareTo(nodo1) < 0) {
                               actual = actual.der;//revisar relacion menores y mayores
                            } else {
                               actual = actual.izq;
                            }
                        }
                    }
                } else {
                    while(!found) {
                        if(actual.elem.compareTo(nodo2.elem) < 0 && actual.elem.compareTo(nodo1.elem) > 0) {
                            found = true;
                        } else {
                            if(actual.elem.compareTo(nodo1) > 0) {
                                actual = actual.der;
                            } else {
                                actual = actual.izq;
                            }
                        }
                    }
                }
            }
        } else {
            throw new ExcepcionColeccionVacia("Al menos uno de los elementos no esta contenido");
        }
        
        return actual;
    }
    
    public void porNivel(NodoAVL <T> ini) {
        ArrayList <NodoAVL<T>> cola = new ArrayList();
        
        cola.add(ini);
        
        while(!cola.isEmpty()) {
            actual = cola.getFirst(); // buscar funcionlidad de ArrayList como cola
        }
    }
    
    public static void main(String[] args) {
        
    }

}
