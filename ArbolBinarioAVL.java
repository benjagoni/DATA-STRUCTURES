/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatosavanzadas;

import static javafx.scene.input.KeyCode.T;
import estructurasdedatosavanzadas.ColaA;

/**
 *
 * @author benjagoni
 */
public class ArbolBinarioAVL <T extends Comparable <T>> implements BinaryTreeADT{
    NodoAVL<T> raiz;
    int cont;
    
    public ArbolBinarioAVL() {
        raiz = null;
        cont = 0;
    }

    public void insertaAVL(T dato) {
        if(busca(dato) == null) { // debe ser igual pues muestra que no lo contiene antes de la insercion
            NodoAVL <T> actual = inserta(dato); // inserta que regresa nodo
            while(actual != raiz && actual.fe != 0 && Math.abs(actual.fe) == 2) {
                if(actual.papa.elem.compareTo(actual.elem) > 0) {
                    actual.papa.fe--;
                } else {
                    actual.papa.fe++;
                }
                
                actual = actual.papa;
                actual.h++;
            }
            
            if(Math.abs(actual.fe) == 2){
                rota(actual); 
            }          
        }
    }
    
    public NodoAVL<T> inserta(T elem){
        NodoAVL<T> actual=raiz,anterior=raiz;
        if(raiz==null){
            raiz=new NodoAVL<T>(elem);
            cont++;
            return raiz;
        }    

        while(actual!=null){
            anterior=actual;
            if(elem.compareTo(actual.getElem())<=0){
                actual=actual.getIzq();
            }else {
                actual=actual.getDer();
            }
        }
        
        NodoAVL<T> nuevo = new NodoAVL<T>(elem);
        anterior.cuelga(nuevo);
        cont++;
        
        return nuevo;
   
    }  
    
    public <T extends Comparable <T>> NodoAVL<T> busca(T elem) {
        NodoAVL<T> actual = (NodoAVL<T>) raiz ;
        boolean indicador = false;
        
        while(actual != null && !indicador) {
            if(actual.elem == elem) {
                indicador = true;
            } else {
                if(actual.elem.compareTo(elem) > 0) {
                    actual = actual.izq;
                } else {
                    actual = actual.der;
                }
            }
        }
        
        return actual;
    }
    
    public <T extends Comparable <T>> void borra(T elemento) {
        NodoAVL<T> actual = busca(elemento);
        
        if(actual == null) {
            return ;
        }
        
        if(actual.izq == null) {
            if(actual.der == null) {
                actual = null;
            } else {
                actual.der.papa = actual.papa;
            }
        } else {
            if(actual.der == null) {
                actual.izq.papa = actual.papa;
            } else{
                NodoAVL<T> buscaSucesor = actual.der;
                while(actual != null) {
                    buscaSucesor = buscaSucesor.izq;
                }
                
                actual.cuelga(buscaSucesor);       
            }
        }
        
    }
    
    public void rota(NodoAVL<T> actual) {
        if(actual.fe == -2 && actual.izq.fe == -1) {
            rotaDerDer(actual);
        } else if(actual.fe == -2 && actual.izq.fe == 1) {
            rotaIzqDer(actual);
        } else if(actual.fe == 2 && actual.der.fe == -1) {
            rotaDerIzq(actual);
        } else {
            rotaIzqIzq(actual);
        } 
    }
    
    private NodoAVL<T> rotaDerDer(NodoAVL<T> actual) {
        NodoAVL<T> alfa = actual;
        NodoAVL<T> A = alfa.izq;
        NodoAVL<T> beta = alfa.der;
        NodoAVL<T> B = beta.izq;
        NodoAVL<T> gamma = beta.der;
        NodoAVL<T> C = gamma.izq;
        NodoAVL<T> D = gamma.der;
            
        if (A != null)
            alfa.cuelga(A);
        else
            alfa.izq = null;
        if (B != null)
            alfa.cuelga(B);
        else
            alfa.der = null;
        if (C != null)
            gamma.cuelga(C);
        else
            gamma.izq = null;
        if (D != null)
            gamma.cuelga(D);
        else
            gamma.der = null;
        beta.cuelga(alfa);
        beta.cuelga(gamma);
        if (actual.papa != null)
            actual.papa.cuelga(beta);
        else
            raiz = beta;
        beta.papa= actual.papa;

        alfa.actualizaAltura();
        alfa.actualizarFE();
        beta.actualizaAltura();
        beta.actualizarFE();
        gamma.actualizaAltura();
        gamma.actualizarFE();

        return beta;
    }
    
    private NodoAVL <T> rotaIzqDer(NodoAVL<T> actual) {
        NodoAVL<T> alfa = actual;
        NodoAVL<T> beta = alfa.izq;
        NodoAVL<T> D = alfa.der;
        NodoAVL<T> A = beta.izq;
        NodoAVL<T> gamma = beta.der;
        NodoAVL<T> B = gamma.izq;
        NodoAVL<T> C = gamma.der;

        if (A != null)
            beta.cuelga(A);
        else
            beta.izq = null;
        if (B != null)
            beta.cuelga(B);
        else
            beta.der = null;
        if (C != null)
            alfa.cuelga(C);
        else
            alfa.izq = null;
        if (D != null)
            alfa.cuelga(D);
        else
            alfa.der = null;
        gamma.cuelga(beta);
        gamma.cuelga(alfa);
        if (actual.papa != null)
            actual.papa.cuelga(gamma);
        else
            raiz = gamma;
        gamma.papa = actual.papa;

        alfa.actualizaAltura();
        alfa.actualizarFE();
        beta.actualizaAltura();
        beta.actualizarFE();
        gamma.actualizaAltura();
        gamma.actualizarFE();

        return gamma;
    }
    
    private NodoAVL<T> rotaIzqIzq(NodoAVL<T> actual) {
        NodoAVL<T> alfa = actual;
        NodoAVL<T> beta = alfa.izq;
        NodoAVL<T> D = alfa.der;
        NodoAVL<T> gamma = beta.izq;
        NodoAVL<T> C = beta.der;
        NodoAVL<T> A = gamma.izq;
        NodoAVL<T> B = gamma.der;
        if (A != null)
            gamma.cuelga(A);
        else
            gamma.izq = null;
        if (B != null)
            gamma.cuelga(B);
        else
            gamma.der = null;
        if (C != null)
            alfa.cuelga(C);
        else
            alfa.izq = null;
        if (D != null)
            alfa.cuelga(D);
        else
            alfa.der = null;
            
        beta.cuelga(alfa);
        beta.cuelga(gamma);
        if (actual.papa!=null)
            actual.papa.cuelga(beta);
        else
            raiz = beta;
        beta.papa= actual.papa;
        gamma.actualizaAltura();
        gamma.actualizarFE();
        alfa.actualizaAltura();
        alfa.actualizarFE();
        beta.actualizaAltura();
        beta.actualizarFE();
            
        return beta;
    }
    
    private NodoAVL<T> rotaDerIzq(NodoAVL<T> actual) {
        NodoAVL<T> alpha = actual;
        NodoAVL<T> beta = alpha.izq;
        NodoAVL<T> D = alpha.der;
        NodoAVL<T> gamma = beta.izq;
        NodoAVL<T> C = beta.der;
        NodoAVL<T> A = alpha.izq;
        NodoAVL<T> B = gamma.der;
                        
        if(A!=null) {
            alpha.cuelga(A);
        } else {
            alpha.izq = null;
        }
        
        if(B != null) {
            alpha.cuelga(B);
            
        } else{
            gamma.der = null;
        }
        
        if(C != null) {
            alpha.cuelga(C);
        } else {
            alpha.izq = null;
        }
        
        if(D != null) {
            alpha.cuelga(D);
        } else {
            alpha.der = null;
        }
        
        beta.cuelga(alpha);
        beta.cuelga(gamma);
        actual.papa.cuelga(beta);
        
        gamma.actualizaAltura();
        gamma.actualizarFE();
        alpha.actualizaAltura();
        alpha.actualizarFE();
        beta.actualizaAltura();
        beta.actualizarFE();
        
        return beta;
    }
    
    public void imprimePorNivel() {
        ColaADT<NodoAVL> cola = new ColaA();
        cola.agrega(raiz);
        int nivel; // para imprimir chido
        
        while(!cola.estaVacia()) {
            if(cola.consultaPrimero() != null) {
                System.out.print(cola.consultaPrimero().elem.toString());
                cola.agrega(cola.consultaPrimero().izq);
                cola.agrega(cola.consultaPrimero().der);
            }
            
            cola.quita();
        }
    }

    @Override
    public boolean isEmpty() {
        return cont == 0;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean contains(T element) {
        NodoAVL<T> actual = busca(element);
        boolean resp = true;
        if(actual == null) {
            resp = false;
        }
        
        return resp;
    }
    
    private NodoAVL<T> rota2(NodoAVL<T> actual) {
        NodoAVL papa;
        NodoAVL alfa;
        NodoAVL beta;
        NodoAVL gamma;
        NodoAVL A;
        NodoAVL B;
        NodoAVL C;
        NodoAVL D;
        
        if(actual.fe == -2 && actual.izq.fe == 1) { //izq-der
            papa = actual.papa;
            alfa = actual;
            beta = alfa.izq;
            gamma = beta.der;
            A = beta.izq;
            B = gamma.izq;
            C = gamma.der;
            D = alfa.der;
        }
    }

    @Override
    public boolean contains(Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        ArbolBinarioAVL prueba = new ArbolBinarioAVL();
        
        prueba.insertaAVL(1);
        prueba.insertaAVL(-1);
        prueba.insertaAVL(2);
        prueba.insertaAVL(-2);
        prueba.insertaAVL(3);
        
        prueba.imprimePorNivel();
        
    }
    
}
