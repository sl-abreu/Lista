/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

/**
 *
 * @author robot
 */
public class DNode<T> {
    private T dato;
    private DNode<T> next;
    private DNode<T> prev;
    
    public DNode(){
        next=null;
        prev=null;
    }
    public DNode(T dato){
        this();
        this.dato=dato;
    }

    public T getDato() {
        return dato;
    }
    public void setDato(T dato) {
        this.dato = dato;
    }
    public DNode<T> getNext() {
        return next;
    }
    public void setNext(DNode<T> next) {
        this.next = next;
    }
    public DNode<T> getPrev() {
        return prev;
    }
    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }
    
    @Override
    public String toString(){
        return dato.toString();
    }
}
