/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import auxiliares.Node;

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
            Node<T> nuev=new Node(dato);
            
            if(start==null){
                start=nuev;
                res=true;
            }else if(start.getDato().compareTo(dato)>0){
                nuev.setLink(start);
                start=nuev;
                res=true;
            }else{
                Node<T> ap=start;
                
                while(ap.getLink()!=null && ap.getLink().getDato().compareTo(dato)<0)
                    ap=ap.getLink();
                if(ap.getLink()!=null && !ap.getLink().getDato().equals(dato)){
                    nuev.setLink(ap.getLink());
                    ap.setLink(ap);
                    res=true;
                }
            }
        }
        return res;
    }
    @Override
    public T remove(T dato){
        if(dato!=null && start!=null){
            if(start.getDato().equals(dato))
                return removeFirst();
            else{
                Node<T> ap=start,temp;
                T res=null;
                
                while(ap.getLink()!=null && ap.getLink().getDato().compareTo(dato)<0)
                    ap=ap.getLink();
                if(ap.getLink()!=null && ap.getLink().getDato().equals(dato)){
                    temp=ap.getLink();
                    res=temp.getDato();
                    ap.setLink(temp.getLink());
                    temp.setLink(null);
                }
                return res;
            }
        }
        throw new NullPointerException();
    }
    @Override
    public boolean contains(T dato){
        if(dato!=null){
            if(start!=null){
                Node<T> ap=start;
            
                while(ap!=null && ap.getDato().compareTo(dato)<0)
                    ap=ap.getLink();
                return ap!=null && ap.getDato().equals(dato);
            }else
                return false;
        }
        throw new NullPointerException();
    }
}
