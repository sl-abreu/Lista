/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author robot
 */
public interface ListaDesordenadaADT<T> extends ListaADT<T> {
    public void addFirst(T dato);
    public void addLast(T dato);
    public boolean addBefore(T sig,T dato);
    public boolean addAfter(T ant,T dato);
}
