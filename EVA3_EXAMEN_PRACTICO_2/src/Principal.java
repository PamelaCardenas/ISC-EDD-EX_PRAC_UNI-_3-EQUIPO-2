
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int iVal;
        Lista lista = new Lista();
        Scanner yol = new Scanner(System.in);
        System.out.println("De que tamaño sera su arreglo?");
        iVal = yol.nextInt();
        yol.nextLine();
        int[] aiDatos = new int[iVal];
        for (int i = 0; i < aiDatos.length; i++) {
            int iVal1 = (int) (Math.random() * 100);
            lista.agregarNodo(new Nodo(iVal1));
        }
        System.out.println("Original");
        lista.imprimir();
        System.out.println("");
        lista.ordenarlista();   // Metodo burbuja
        //lista.imprimir();
        
        System.out.println("MergeSort");
        lista.ordenar2();
        lista.imprimir();
        lista.buscar();
    }
}
