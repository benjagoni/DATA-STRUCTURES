/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author marcos
 */
public class Pilas {

    /**
     * @param pila
     * @param args the command line arguments
     * @return 
     */
    
    public static String invierte(ArrayStack<Integer>pila){
        ArrayStack<Integer>nueva= new ArrayStack<Integer>();
        while(!pila.isEmpty())
            nueva.push(pila.pop());
       String res= null;
       while(!nueva.isEmpty())
           res=nueva.pop()+"-";
       return res;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayStack<Integer>pila= new ArrayStack<Integer>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        System.out.println(invierte(pila));
    }
    
}
