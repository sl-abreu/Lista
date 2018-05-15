/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import java.util.Iterator;

/**
 *
 * @author robot
 */
public interface ListaADT<T> extends Iterable {
    public boolean isEmpty();
    public T removeFirst();
    public T removeLast();
    public T remove(T datum);
    @Override
    public String toString();
    public boolean contains(T datum);
    public int size();
    public T getFirst();
    public T getLast();
}
