/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Banana Bread
 */
public class Nodo {
    private int valor;
    private Nodo sig;
    private Nodo previo;

    public Nodo() {
        sig = null;
        previo = null;
    }

    public Nodo(int valor) {
        this.valor = valor;
        sig = null;
        previo = null;
    }

    public int getDato() {
        return valor;
    }

    public void setDato(int valor) {
        this.valor = valor;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getPrevio() {
        return previo;
    }

    public void setPrevio(Nodo previo) {
        this.previo = previo;
    }
    
    
    
    
}
