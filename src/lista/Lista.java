/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import auxiliares.IteratorEE;
import auxiliares.Node;
import java.util.Iterator;

/**
 *
 * @author robot
 */
public abstract class Lista<T> implements ListaADT<T> {
    protected Node<T> start;
    
    public Lista(){
        start=null;
    }
    
    @Override
    public Iterator<T> iterator(){
        return new IteratorEE(start);
    }
    @Override
    public boolean isEmpty(){
        return start==null;
    }
    @Override
    public T removeFirst(){
        T res=null;
                
        if(start!=null){
            Node<T> aux=start;
            
            res=start.getDato();
            start=start.getLink();
            aux.setLink(null);
            aux=null;
        }
        return res;
    }
    @Override
    public T removeLast(){
        T res=null;
                
        if(start!=null){
            if(start.getLink()!=null){
                Node<T> ap=start.getLink(),temp=start;
                
                while(ap.getLink()!=null){
                    temp=ap;
                    ap=ap.getLink();
                }
                res=ap.getDato();
                temp.setLink(null);
            }else{
                res=start.getDato();
                start=null;
            }
        }
        return res;
    }
    @Override
    public T remove(T dato){
        T res=null;
        
        if(dato!=null && start!=null){
            if(start.getDato().equals(dato)){
                res=start.getDato();
                start=start.getLink();
            }else{
                Node<T> ap=start.getLink(),temp=start;
                
                while(ap!=null && !ap.getDato().equals(dato)){
                    temp=ap;
                    ap=ap.getLink();
                }
                if(ap!=null){
                    res=ap.getDato();
                    temp.setLink(ap.getLink());
                }
            }
        }
        return res;
    }
    @Override
    public String toString(){
        StringBuilder cad=new StringBuilder();
        Node<T> ap=start;
        
        while(ap!=null){
            cad.append(ap.getDato().toString());
            ap=ap.getLink();
        }
        return cad.toString();
    }
    @Override
    public boolean contains(T dato){
        boolean res=false;
        Node<T> ap=start;
        
        while(!res && ap!=null){
            res=ap.getDato().equals(dato);
            ap=ap.getLink();
        }
        return res;
    }
    @Override
    public int size(){
        int cont=0;
        Node<T> ap=start;
        
        while(ap!=null){
            cont++;
            ap=ap.getLink();
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
            Node<T> ap=start;
            
            while(ap.getLink()!=null)
                ap=ap.getLink();
            return ap.getDato();
        }
        throw new EmptyListException("Lista vacía");
    }
}
