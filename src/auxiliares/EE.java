/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import auxiliares.ConjuntoA;
import java.util.Iterator;

/**
 *
 * @author robot
 */
public class EE<T> implements Iterable<T> {
    private Node<T> start;
    private Node<T> end;
    
    public EE(){
        start=null;
        end=null;
    }
    
    public T getDato(int pos){
        Node<T> ap=start;
        int cont=0;
        
        while(ap!=null && cont<pos){
            ap=ap.getLink();
            cont++;
        }
        if(ap!=null)
            return ap.getDato();
        throw new NullPointerException();
    }
    public boolean isEmpty(){
        return start==null;
    }
    public void addFirst(T dato){
        Node<T> nuevo=new Node(dato);
        
        nuevo.setLink(start);
        start=nuevo;
        if(end==null)
            end=nuevo;
    }
    public void addLast(T dato){
        Node<T> nuevo=new Node(dato);
        
        if(end==null)
            start=nuevo;
        else
            end.setLink(nuevo);
        end=nuevo;
    }
    public boolean addAfter(T dato, T ant){
        boolean res=false;
        Node<T> aux=searchNode(ant),nuevo;
        
        if(aux!=null){
            nuevo=new Node<T>(dato);
            nuevo.setLink(aux.getLink());
            aux.setLink(nuevo);
            res=true;
            if(aux==end)
                end=nuevo;
        }
        return res;
    }
    public boolean addBefore(T dato, T sig){
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
    public T removeFirst(){
        T res=null;
                
        if(start!=null){
            Node<T> aux=start;
            
            res=start.getDato();
            if(start==end)  //hay un solo nodo
                end=null;
            start=start.getLink();
            aux.setLink(null);
            aux=null;
        }
        return res;
    }
    public T removeLast(){
        T res=null;
        Node<T> temp=start;
        
        if(!isEmpty()){
            res=end.getDato();
            if(start!=end){
                while(temp.getLink()!=end)
                    temp=temp.getLink();
                temp.setLink(null);
                end=temp;
            }
            else{
                end=null;
                start=null;
            }
        }
        return res;
    }
    public T removeBefore(T sig){
        T res=null;
        
        if(sig!=null && !isEmpty() && start!=end && !start.getDato().equals(sig)){
            if(start.getLink().getDato().equals(sig))
                res=removeFirst();
            else{
                Node<T> ap=start;
                while(ap.getLink().getLink()!=null && !ap.getLink().getLink().getDato().equals(sig))
                    ap=ap.getLink();
                if(ap.getLink().getLink()!=null){
                    Node<T> temp=ap.getLink();
                    
                    ap.setLink(temp.getLink());
                    temp.setLink(null);
                    res=temp.getDato();
                }
            }
        }
        return res;
    }
    public T remove(T dato){
        T res=null;
        
        if(dato!=null && !isEmpty()){
            if(start==end && start.getDato().equals(dato)){
                res=start.getDato();
                start=null;
                end=null;
            }else{
                Node<T> ap=start;
                while(ap.getLink()!=null && !ap.getLink().getDato().equals(dato))
                    ap=ap.getLink();
                if(ap.getLink()!=null){
                    Node<T> temp=ap.getLink();
                    
                    ap.setLink(temp.getLink());
                    temp.setLink(null);
                    res=temp.getDato();
                }
            }
        }
        return res;
    }
    
    public int removeAllDuplicatesR(){
        int res=0;
        Node<T> nodo;
        if(!isEmpty()){
            nodo=start;
            while(nodo.getLink()!=null){
                res=remDup(nodo,nodo.getDato(),res);
                nodo=nodo.getLink();
            }
        }
        return res;
    }
    private int remDup(Node<T> nodo,T dato,int res){
        if(nodo.getLink()!=null){
            if(nodo.getLink().getDato().equals(dato)){
                nodo.setLink(nodo.getLink().getLink());
                res++;
            }
            return remDup(nodo.getLink(),dato,res);
        }
        return res;
    }
    
    public int removeAllDuplicates(){
        ConjuntoA<T> bin;
        int cont=0;
        Node<T> ap;
        
        if(!isEmpty() && start!=end){
            ap=start;
            bin=new ConjuntoA();
            bin.agrega(start.getDato());
            
            while(ap.getLink()!=null){
                if(!bin.agrega(ap.getLink().getDato())){
                    Node<T> temp=ap.getLink();
                    
                    ap.setLink(temp.getLink());
                    temp.setLink(null);
                    cont++;
                }else
                    ap=ap.getLink();
            }
        }
        return cont;
    }
    
    public EE<T> merge(EE<T> otro){
        if(otro!=null && !otro.isEmpty() && !isEmpty()){
            Node<T> ap1=start,ap2=otro.start,temp=new Node();
            int ref=0;
            
            while(ap1!=null && ap2!=null){
                if(ref%2==0){
                    temp=ap1;
                    ap1=ap1.getLink();
                    temp.setLink(ap2);
                }else{
                    temp=ap2;
                    ap2=ap2.getLink();
                    temp.setLink(ap1);
                }
                ref++;
            }
            if(ap1==null)
                this.end=otro.end;
            return this;
        }
        throw new NullPointerException();
    }
    
    public T search(T dato){
        Iterator<T> it=iterator();
        T temp,res=null;
        boolean aux=false;
        
        while(!aux && it.hasNext()){
            temp=it.next();
            if(temp.equals(dato)){
                aux=true;
                res=temp;
            }
        }
        return res;
    }
    
    public T searchR(T dato){
        T res=null;
        
        if(dato!=null && !isEmpty()){
            if(dato.equals(start.getDato()))
                res=start.getDato();
            else if(dato.equals(end.getDato()))
                res=end.getDato();
            else
                res=searchR(dato,start.getLink());
        }
        return res;
    }
    private T searchR(T dato, Node nodo){
        if(dato.equals(nodo.getDato()))
            return (T) nodo.getDato();
        else if(nodo.getLink()!=null)
            return searchR(dato,nodo.getLink());
        else
            return null;
    }
    
    private Node searchNode(T dato){
        Node res=null;
        
        if(dato!=null && !isEmpty()){
            if(dato.equals(start.getDato()))
                res=start;
            else if(dato.equals(end.getDato()))
                res=end;
            else
                res=searchNode(dato,start.getLink());
        }
        return res;
    }
    private Node searchNode(T dato, Node nodo){
        if(dato.equals(nodo.getDato()))
            return nodo;
        else if(nodo.getLink()!=null)
            return searchNode(dato,nodo.getLink());
        else
            return null;
    }
    
    @Override
    public Iterator<T> iterator(){
        return new IteratorEE(start);
    }
    
    @Override
    public String toString(){
        StringBuilder cad=new StringBuilder();
        Node<T> ap=start;
        
        return toString(ap,cad);
    }
    private String toString(Node<T> ap,StringBuilder cad){
        if(ap==null)
            return cad.toString();
        else{
            cad.append(ap.getDato()+"\t");
            return toString(ap.getLink(),cad);
        }
    }
/*  Versión no recursiva pero ilustrativa del uso de nodos
    @Override
    public String toString(){
        StringBuilder cad=new StringBuilder();
        Node<T> ap=start;
        
        while(ap!=null){
            cad.append(ap.getDato());
            ap=ap.getLink();
        }
        return cad.toString();
    }
*/
}
