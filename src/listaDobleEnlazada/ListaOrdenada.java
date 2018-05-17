/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaDobleEnlazada;

import auxiliares.DNode;
import java.util.Iterator;

/**
 *
 * @author robot
 */
public class ListaOrdenada<T extends Comparable<T>> extends Lista<T> implements ListaOrdenadaADT<T> {
    public ListaOrdenada(){
        super();
    }
    
    @Override
    public boolean add(T dato){
        boolean res=false;
        
        if(dato!=null){
            DNode<T> nuev=new DNode(dato);
                
            if(start==null){
                res=true;
                start=nuev;
                end=nuev;
            }else if(dato.compareTo(end.getDato())>0){
                res=true;
                end.setNext(nuev);
                nuev.setPrev(end);
                end=nuev;
            }else if(dato.compareTo(start.getDato())<0){
                res=true;
                nuev.setNext(start);
                start.setPrev(nuev);
                start=nuev;
            }else
                res=add(dato,start);
        }
        return res;
    }
    private boolean add(T dato,DNode<T> ap){
        if(dato.equals(ap.getDato()))
            return false;
        if(dato.compareTo(ap.getDato())>0)
            return add(dato,ap.getNext());
        DNode<T> nuev=new DNode(dato);
        
        ap.getNext().setPrev(nuev);
        nuev.setNext(ap.getNext());
        nuev.setPrev(ap);
        ap.setNext(nuev);
        return true;
    }
    @Override
    public T remove(T dato){
        if(dato!=null && start!=null)
            if(dato.compareTo(start.getDato())>=0 && dato.compareTo(end.getDato())<=0)
                if(dato.equals(start.getDato()))
                    return removeFirst();
                else if(dato.equals(end.getDato()))
                    return removeLast();
                else{
                    return remove(dato,start.getNext());
                }
        return null;
    }
    private T remove(T dato,DNode<T> ap){
        if(dato.compareTo(ap.getDato())>0)
            return remove(dato,ap.getNext());
        if(ap.getDato().equals(dato)){
            ap.getPrev().setNext(ap.getNext());
            ap.getNext().setPrev(ap.getPrev());
            ap.setNext(null);
            ap.setPrev(null);
            return ap.getDato();
        }
        return null;
    }
    @Override
    public boolean contains(T dato){
        if(dato==null || start==null || end.getDato().compareTo(dato)<0)
            return false;
        return contains(dato,iterator());
    }
    private boolean contains(T dato,Iterator<T> it){
        T temp=it.next();
            
        if(temp.equals(dato))
            return true;
        else if(temp.compareTo(dato)<0)
            return contains(dato,it);
        return false;
    }
}
