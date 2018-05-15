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
public class Node<T> {
    private T dato;
    private Node<T> link;
    
    public Node(){
        link=null;
    }
    public Node(T dato){
        this();
        this.dato=dato;
    }

    public T getDato() {
        return dato;
    }
    public void setDato(T dato) {
        this.dato = dato;
    }
    public Node<T> getLink() {
        return link;
    }
    public void setLink(Node<T> link) {
        this.link = link;
    }
    
    @Override
    public String toString(){
        return dato.toString();
    }
}
