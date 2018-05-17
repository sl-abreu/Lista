/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaDobleEnlazada;

import auxiliares.DNode;

/**
 *
 * @author robot
 */
public class ListaDesordenada<T> extends Lista<T> implements ListaDesordenadaADT<T> {
    public ListaDesordenada(){
        super();
    }
    
    @Override
    public void addFirst(T dato){
        if(dato!=null){
            DNode<T> nuev=new DNode(dato);
        
            if(start!=null){
                nuev.setNext(start);
                start.setPrev(nuev);
            }else
                end=nuev;
            start=nuev;
        }
    }
    @Override
    public void addLast(T dato){
        if(dato!=null){
            DNode<T> nuev=new DNode(dato);
            
            if(start!=null){
                end.setNext(nuev);
                nuev.setPrev(end);
            }else
                start=nuev;
            end=nuev; 
        }
    }
    @Override
    public boolean addBefore(T sig, T dato){
        boolean res=false;
                
        if(dato!=null && sig!=null && !isEmpty()){
            if(start.getDato().equals(sig)){
                addFirst(dato);
                res=true;
            }else if(end.getDato().equals(sig)){
                DNode<T> nuev=new DNode(dato);
                
                end.getPrev().setNext(nuev);
                nuev.setPrev(end.getPrev());
                end.setPrev(nuev);
                nuev.setNext(end);
                res=true;
            }else{
                DNode<T> ap=start;
                
                while(ap!=end && !ap.getNext().getDato().equals(dato)){
                    ap=ap.getNext();
                }
                if(ap!=end){
                    DNode<T> nuev=new DNode(dato);
                    
                    nuev.setNext(ap.getNext());
                    nuev.setPrev(ap);
                    ap.getNext().setPrev(nuev);
                    ap.setNext(nuev);
                    res=true;
                }
            }
        }
        return res;
    }
    @Override
    public boolean addAfter(T ant,T dato){
        boolean res=false;
        
        if(ant!=null && dato!=null && !isEmpty()){
            if(end.getDato().equals(dato)){
                addLast(dato);
                res=true;
            }else if(start.getDato().equals(dato)){
                DNode<T> nuev=new DNode(dato);
                
                nuev.setNext(start.getNext());
                nuev.setPrev(start);
                start.getNext().setPrev(nuev);
                start.setNext(nuev);
            }else{
                DNode<T> ap=start;
                
                while(ap!=end && !ap.getDato().equals(dato)){
                    ap=ap.getNext();
                }
                if(ap!=end){
                    DNode<T> nuev=new DNode(dato);
                    
                    nuev.setNext(ap.getNext());
                    nuev.setPrev(ap);
                    ap.getNext().setPrev(nuev);
                    ap.setNext(nuev);
                    res=true;
                }
            }
        }
        return res;
    }
}
