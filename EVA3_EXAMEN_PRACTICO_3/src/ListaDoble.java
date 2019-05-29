/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Banana Bread
 */

public class ListaDoble {
    public Nodo inicio;
    private Nodo fin;
    private int iContNodos;

    public ListaDoble() {
        inicio = null;
        fin = null;
        iContNodos = 0;
    }
    
    public void estaVacia(){
        if(inicio == null){
            System.out.println("La lista esta vacia");
        } else {
            System.out.println("La lista tiene nodos");
        }
    }
    
    // AGREGAR AL FINAL DE LA LISTA
    public void agregarNodo(Nodo nNuevo){
        // LISTA VACIA
        if(inicio == null){
            inicio = nNuevo;
            fin = nNuevo;
            iContNodos++;
        }else{ // HAY ELEMENTOS
            // CONECTAR 
            fin.setSig(nNuevo);
            nNuevo.setPrevio(fin);
            fin = nNuevo;
            iContNodos++;
        }
    }
    
    public void agregarInicio(Nodo nNuevo){
        if(inicio==null){
            inicio =nNuevo;
            fin = nNuevo;
            iContNodos++;
        }
        else{
            nNuevo.setSig(inicio);
            inicio.setPrevio(nNuevo);
            inicio = nNuevo;
            iContNodos++;
        }   
    }
    
    // EFICIENCIA O(N)
    public void agregarEn(int iPos, Nodo nNuevo){
        Nodo nTemp = inicio;
        if(inicio != null){
            if(iPos == 0){
                agregarInicio(nNuevo);
            }
            else{
                for (int i = 0; i < iPos; i++) {
                    nTemp = nTemp.getSig();
                }
                nNuevo.setSig(nTemp);
                nTemp = nTemp.getPrevio();
                nTemp.setSig(nNuevo);
                nNuevo.setPrevio(nTemp);
                nTemp = nNuevo.getSig();
                nTemp.setPrevio(nNuevo);
                iContNodos++;
            }
        }
        else{
            agregarInicio(nNuevo);
        }
    }
    
    // EFICIENCIA O(N)
    public void imprimir(){
        Nodo nTemp = inicio;
        while(nTemp!=null){
            System.out.print("["+nTemp.getDato()+"]");
            nTemp = nTemp.getSig();
        }
        System.out.println("");
    }
    
    // EFICIENCIA O(1)
    public int longitud(){
        return iContNodos;
    }
    
    // EFICIENCIA O(1)
    public void vaciar(){
        inicio = null;
        fin = null;
        iContNodos = 0;
    }
    
    public void borrarNodo(int iPos){
        Nodo nTemp = inicio;
        Nodo nTemp2;
        for (int i = 0; i < iPos - 1; i++) {
            nTemp = nTemp.getSig();
        }
        nTemp2 = nTemp.getSig().getSig();
        nTemp2.setPrevio(nTemp);
        nTemp.getSig().getSig();
        nTemp.getSig().setPrevio(null);
        nTemp.setSig(nTemp2);
        iContNodos--;
    }
    
    public void buscarValor(int iValor){
        Nodo nTemp = inicio;
        int iCont = 0;
        do {            
            nTemp = nTemp.getSig();
            iCont++;
            if(nTemp.getSig() == null){
                break;
            }    
        } while (nTemp.getDato() != iValor);
        if((nTemp.getSig() == null)&&(nTemp != fin)){
            System.out.println("Ese valor no se encuentra en la lista");
        } else{
            System.out.println("Posicion de " + iValor +" es: " + iCont);
        }
    }
    
    public void buscarPos(int iPos){
        Nodo nTemp = inicio;
        int iCont = 0;
        if(iPos > iContNodos){
            System.out.println("El valor introducido excede la dimension de la lista");
        }else{
            do {            
                nTemp = nTemp.getSig();
                iCont++;
            } while (iCont != iPos);
            System.out.println("El valor en la posicion " + iCont + " es: " + nTemp.getDato());
        }
    }
    
    /*public void quickSort(ListaDoble aiDatos, Nodo low, Nodo high){
        low = inicio;
        high = fin;
        if(low.getDato() < high.getDato()){
            Nodo pi = null; //partition(aiDatos, low, high);
            pi.setDato(partition(aiDatos, low, high));
            quickSort(aiDatos, low, pi.getPrevio());
            quickSort(aiDatos, pi.getSig(), high);
        }
    }
    
    private int partition(ListaDoble aiDatos, Nodo low, Nodo high){
        Nodo pivot = null;
        pivot.setDato(high.getDato());
        Nodo i = null;
        Nodo j = null;
        i.setDato(low.getPrevio().getDato());
        for ( j.setDato(low.getDato()); i.getDato() <= high.getPrevio().getDato(); j.getSig()) {
            if(j.getDato() <= pivot.getDato()){
                i.getSig();
                Nodo nTemp = null;
                nTemp.setDato(i.getDato());
                i.setDato(j.getDato());
                j.setDato(nTemp.getDato());
                
            }
        }
        Nodo nTemp = null;
        nTemp.setDato(i.getSig().getDato());
        //aiDatos[i + 1] = aiDatos[high];
        i.getSig().setDato(high.getDato());
        //aiDatos[high] = iTemp;
        high.setDato(nTemp.getDato());
        return (i.getSig().getDato());
    }*/
    
    //Método que realiza el ordenamiento y regresa los nodos
    Nodo partition(Nodo low,Nodo high){ 
       //Se guarda el valor del último nodo en la lista para hacer las comparaciones
        int mayor = high.getDato(); 
        Nodo i = low.getPrevio(); 
        //For adaptado a listas
        for(Nodo j = low; j != high; j = j.getSig()){ 
            if(j.getDato() <= mayor){ 
                i = (i==null) ? low : i.getSig(); 
                int temp = i.getDato(); 
                i.setDato(j.getDato());  
                j.setDato(temp); 
            } 
        } 
        i = (i==null) ? low : i.getSig();
        int temp = i.getDato(); 
        i.setDato(high.getDato()); 
        high.setDato(temp); 
        return i; 
    } 
      
    //El método recursivo para la implementación de quicksort
    private void quickSortRecur(Nodo low,Nodo high){ 
        if(high!=null && low!=high && low!=high.getSig()){ 
            Nodo temp = partition(low,high); 
            quickSortRecur(low,temp.getPrevio()); 
            quickSortRecur(temp.getSig(),high); 
        } 
    } 
      
    // Función que interactúa con el usuario
    public void quickSort(Nodo nNodo){ 
        //Se necesita el último Nodo
        Nodo inicio = NodoFin(nNodo); 
        quickSortRecur(nNodo,inicio); 
    } 
    
    //Método que busca el último Nodo y lo regresa    
    Nodo NodoFin(Nodo nNodo){ 
        while(nNodo.getSig() != null) 
            nNodo = nNodo.getSig(); 
        return nNodo; 
    } 
}

