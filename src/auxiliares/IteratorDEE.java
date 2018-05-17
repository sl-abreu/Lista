/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author robot
 */
public class IteratorDEE<T> implements Iterator<T> {
    private DNode<T> actual;
    
    public IteratorDEE(DNode<T> node) {
        this.actual=node;
    }
    
    @Override
    public boolean hasNext(){
        return actual!=null;
    }
    @Override
    public T next(){
        if(hasNext()){
            T res=actual.getDato();
            actual=actual.getNext();
            return res;
        }
        throw new NoSuchElementException();
    }
}
