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
public class ListaDesordenada<T> extends Lista<T> implements ListaDesordenadaADT<T> {
    public ListaDesordenada(){
        super();
    }
    
    @Override
    public void addFirst(T dato){
        if(dato!=null){
            Node<T> nuev=new Node(dato);
        
            nuev.setLink(start);
            start=nuev;
        }
    }
    @Override
    public void addLast(T dato){
        if(dato!=null){
            Node<T> nuev=new Node(dato);
            
            if(start!=null){
                Node<T> ap=start;
            
                while(ap.getLink()!=null)
                    ap=ap.getLink();
                ap.setLink(nuev);
            }else
                start=nuev;
        }
    }
    @Override
    public boolean addBefore(T sig, T dato){
        boolean res=false;
                
        if(dato!=null && sig!=null && !isEmpty()){
            Node<T> nuevo;
            if(start.getDato().equals(sig)){
                res=true;
                nuevo=new Node(dato);
                nuevo.setLink(start);
                start=nuevo;
            }else{
                Node<T> ant=start,act=start.getLink();
                while(act!=null && !act.getDato().equals(sig)){
                    ant=act;
                    act=act.getLink();
                }
                if(act!=null){
                    res=true;
                    nuevo=new Node(dato);
                    ant.setLink(nuevo);
                    nuevo.setLink(act);
                }
            }
        }
        return res;
    }
    @Override
    public boolean addAfter(T ant,T dato){
        boolean res=false;
        
        if(ant!=null && dato!=null && !isEmpty()){
            Node<T> ap=start,nuev;
            
            while(ap!=null && !ap.getDato().equals(ant))
                ap=ap.getLink();
            if(ap!=null){
                nuev=new Node(dato);
                ap.setLink(nuev);
                res=true;
            }
        }
        return res;
    }
}
