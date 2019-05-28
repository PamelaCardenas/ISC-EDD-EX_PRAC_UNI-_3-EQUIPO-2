/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author escritorio
 */
public class Nodo {
    
    //Atributos datos
    private int dato;
    
    //Atributo para crear la lista (Referencias)
    private Nodo sig;

    public Nodo() {
        sig=null;
        
    }

    
    public Nodo(int dato) {
        this.dato = dato;
        sig=null;
    }


    
    
    

    public int getDato() {
        return dato;
    } 
    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
