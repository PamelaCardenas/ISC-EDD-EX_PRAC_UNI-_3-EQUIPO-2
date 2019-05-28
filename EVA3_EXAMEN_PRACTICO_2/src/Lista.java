
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author INTEGRANTES DEL EQUIPO:

	---> Luisa María González Ordóñez 18550352
	---> Karla Pamela Cárdenas Leyva 18550338
	---> Josué David Martínez García 18550360
	---> Roberto Antonio Pedroza Fernández 18550354
	---> Irving Gerardo Mancera Mejía 18550317
 */
public class Lista {
    //Inicio de la lista
    private Nodo inicio;
    private Nodo fin;
    private int iCont = 0;
    Scanner yol = new Scanner(System.in);
    //Al crear la lista, inicia con 0 elementos
    //Lista vacia:
    //3 estados: Vacia, con un nodo, con N nodos
    public Lista() {
        inicio = null;
        fin = null;
    }
    //Primer mètodo: agregar un nodo
    //Metodo que reciba un nodo
    //Eficiencia --> O(N)
    //Nueva eficiencia --> O(1)
    public void agregarNodo(Nodo nNuevo) {
        //Verificar el estado de la lista:
        //Esta vacia?
        if (inicio == null) {  //Lista vacia
            inicio = nNuevo;
            fin = nNuevo;  //Modificado -->Mayor eficiencia
        } else {
            iCont++;
        }
        fin.setSig(nNuevo);
        fin = nNuevo;
    }
    //O(N)
    public void agregarInicio(Nodo nNuevo) {
        if (inicio == null) {  //Lista vacia
            inicio = nNuevo;
            fin = nNuevo;  //Modificado --> Mayor eficiencia
        } else {//Lista con un nodo
            nNuevo.setSig((inicio));//Lo ponemos al incipio
            inicio = nNuevo;
        }
    }
    //O(1)
    public boolean estaVacia() {
        if (inicio == null) {
            return true;
        }
        return false;
    }
    public int buscar(int iVal) {
        int iPos = 1;
        //Como buscamos el valor
        //Recorer elementos por elementos

        //detener la busqueda cuando lo encontramos
        //Se puede llegar al final de la lista sin encontrarlo
        Nodo nTemp = inicio;
        int iCont = 0;
        while (nTemp != null) {
            if (iVal == nTemp.getDato()) {
                iPos = iCont;
                break;
            }
            iCont++;
            nTemp = nTemp.getSig();
        }
        return iPos;
    }
    //O(n)
    
    //Eficiencia O(N)
    public void borrarNodo(int ipos) {
        //Borrar al inicio de la lista
        //Borrar cualquier posicion
        //Verificar que haya nodos
        //Verificar que la posicion sea vàlida
        if (inicio != null) {//Tener nodos
            if (ipos == 0) {//Nodo inicial
                //Hay un Nodo
                //Hay nNODOS
                inicio = inicio.getSig();
                //El problema es el nodo fin
                if (inicio.getSig() == null) {
                    fin = null;
                }
                //El problema es el nodo fin
            } else {//Cualquier otro nodo
                //Movernos por la lista
                //En una lista simple (un solo enlace implica movernos hasta la posicion previa -1
                Nodo nTemp = inicio; //Esto nunca cambia 
                // nTemp--> --> nodo a borrar --> nodo sig
                //              fin
                int iCont = 0;
                while (iCont != (ipos - 1)) {
                    iCont++;
                    nTemp = nTemp.getSig();
                }
                Nodo nSig = nTemp.getSig();
                nTemp.setSig(nTemp.getSig().getSig());
                //El problema es el nodo fin
                if (nTemp.getSig() == null) {//borramos el ultimonodo
                    fin = nTemp;
                }
                iCont--;
            }
        } else {//Generar una excepciòn --> Lista vacia
        }
    }
    //O(N)
    public void imprimir() {
        Nodo nTemp = inicio;
        while (nTemp != null) {  //Tenemos que dejar a nTemp en el ultimo nodo y getsig tiene que ser null
            System.out.print("[" + nTemp.getDato() + "]");
            nTemp = nTemp.getSig();
        }
        System.out.println("");
    }
    //O(N)
    public int longitud() {
        /*Nodo nTemp = inicio;
    int con =0;
            while(nTemp != null){  //Tenemos que dejar a nTemp en el ultimo nodo y getsig tiene que ser null
                con++;
                nTemp = nTemp.getSig();                
            }*/
        return iCont++;
    }
    //O(1)
    public void vaciar() {
        inicio = null;
        fin = null;
    }
    public int getValor(int iPos) {
        int iVal = 0;
        int iCont = 0;
        Nodo nTemp = inicio;
        while (nTemp != null) {
            if (iCont == iPos) {
                iVal = nTemp.getDato();
                break;
            }
            nTemp = nTemp.getSig();
            iCont++;
        }
        return iVal;
    }
    public void buscar() {
        Nodo lista = inicio;
        Nodo aux;
        int encontrado = 0;
        int ipos = 0;
        if (lista == null) {
        } else {
            int buscar;
            System.out.println("Ingrese el numero a buscar");
            buscar = yol.nextInt();
            yol.nextLine();
            aux = lista;
            while (aux != null) {
                ipos++;
                if (aux.getDato() == buscar) {
                    System.out.println("Encontrado, el numero esta en : " + ipos);
                    aux = null;
                    encontrado = 1;
                } else {
                    aux = aux.getSig();
                }
            }
        }
        if (encontrado == 0) {
            System.out.println("No se encontro ;/");
        }
    }
    public void ordenacionRapida(int vec[]) {
        Nodo vector = inicio;
        vector = vector.getSig();
        final int N = vec.length;
        mergeSort(vec, N);
    }
    public static void mergeSort(int[] aiDatos, int n) {
        if (n < 2) {
            return;
        }
        int med = n / 2;
        int[] I = new int[med];
        int[] D = new int[n - med];
        for (int i = 0; i < med; i++) {
            I[i] = aiDatos[i];
        }
        for (int i = med; i < n; i++) {
            D[i - med] = aiDatos[i];
        }
        mergeSort(I, med);
        mergeSort(D, n - med);
        merge(aiDatos, I, D, med, n - med);
    }
    public static void merge(int[] aiDatos, int[] I, int[] D, int izq, int der) {
        int i = 0, j = 0, k = 0;
        while (i < izq && j < der) {
            if (I[i] <= D[j]) {
                aiDatos[k++] = I[i++];
            }
            else {
                aiDatos[k++] = D[j++];
            }
        }
        while (i < izq) {
            aiDatos[k++] = I[i++];
        }
        while (j < der) {
            aiDatos[k++] = D[j++];
        }
    }
    void ordenar2() {
        int[] arreglo = new int[iCont + 1];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = getValor(i);
        }
        ordenacionRapida(arreglo);
        vaciar();
        for (int i = 0; i < arreglo.length; i++) {
            agregarNodo(new Nodo(arreglo[i]));
        }
    }
    public void ordenarlista() {
        Nodo lista = inicio;
        if (lista != null) {
//Selecionar algoritmo de ordenamiento
//Burbuja
            Nodo pivote = null;
            Nodo actual = null;
            pivote = inicio;
            int temporal = 0;
            while (pivote != fin) { //i < total -1
                actual = pivote;               // j = i+1
                while (actual != null) {    // j <  total
                    // j++
                    if (pivote.getDato() > actual.getDato()) {                // arreglo[i] > arreglo [j]
                        temporal = pivote.getDato();
                        pivote.setDato(actual.getDato());
                        actual.setDato(temporal);
                    }
                    actual = actual.getSig();
                }
                pivote = pivote.getSig();//i++
            }
        } else {
            System.out.println("Lista no inicializada");
        }
    }
}
