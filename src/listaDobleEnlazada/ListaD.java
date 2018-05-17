/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaDobleEnlazada;

import auxiliares.DNode;
import auxiliares.IteratorDEE;
import java.util.Iterator;
import lista.ListaADT;

/**
 *
 * @author robot
 */
public abstract class ListaD<T> implements ListaADT<T> {
    protected DNode<T> start;
    protected DNode<T> end;
    
    public ListaD(){
        start=null;
        end=null;
    }
    
    @Override
    public Iterator<T> iterator(){
        return new IteratorDEE(start);
    }
    @Override
    public boolean isEmpty(){
        return start==null;
    }
    @Override
    public T removeFirst(){
        T res=null;
                
        if(start!=null){          
            res=start.getDato();
            if(start!=end){
                DNode<T> aux=start;
                
                start=start.getNext();
                start.setPrev(null);
                aux.setNext(null);
                aux=null;
            }else{
                start=null;
                end=null;
            }
        }
        return res;
    }
    @Override
    public T removeLast(){
        T res=null;
                
        if(start!=null){
            res=end.getDato();
            if(start!=end){
                DNode<T> aux=end.getPrev();
                
                end.setPrev(null);
                aux.setNext(null);
                end=aux;
            }else{
                start=null;
                end=null;
            }
        }
        return res;
    }
    @Override
    public T remove(T dato){
        T res=null;
        
        if(dato!=null && start!=null){
            if(start.getDato().equals(dato)){
                res=removeFirst();
            }else{
                DNode<T> ap=start.getNext();
                
                while(ap!=end && !ap.getDato().equals(dato))
                    ap=ap.getNext();
                if(ap.getDato().equals(dato)){
                    res=ap.getDato();
                    if(start==end){
                        start=null;
                        end=null;
                    }else if(ap!=end){
                        ap.getNext().setPrev(ap.getPrev());
                        ap.getPrev().setNext(ap.getNext());
                        ap.setNext(null);
                        ap.setPrev(null);
                    }else{
                        end=ap.getPrev();
                        end.setNext(null);
                        ap.setPrev(null);
                    }
                    ap=null;
                }
            }
        }
        return res;
    }
    @Override
    public String toString(){
        String res="";
        
        if(start!=null){
            StringBuilder cad=new StringBuilder();
            DNode<T> ap=start.getNext();
            
            cad.append(start.getDato().toString());
            toString(ap,cad);
            res=cad.toString();
        }
        return res;
    }
    private void toString(DNode<T> ap,StringBuilder cad){
        if(ap!=null){
            cad.append(ap.getDato().toString());
            toString(ap.getNext(),cad);
        }
    }
    @Override
    public boolean contains(T dato){
        boolean res=false;
        DNode<T> ap=start;
        
        if(start!=null){
            res=start.getDato().equals(dato) || end.getDato().equals(dato);
            while(!res && ap!=null){
                res=ap.getDato().equals(dato);
                ap=ap.getNext();
            }
        }
        return res;
    }
    @Override
    public int size(){
        int cont=0;
        DNode<T> ap=start;
        
        while(ap!=null){
            cont++;
            ap=ap.getNext();
        }
        return cont;
    }
    @Override
    public T getFirst(){
        if(start!=null)
            return start.getDato();
        throw new EmptyListException("Lista vacía");
    }
    @Override
    public T getLast(){
        if(start!=null){
            return end.getDato();
        }
        throw new EmptyListException("Lista vacía");
    }
}
