
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Banana Bread
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int iVal = 0;
        ListaDoble lista = new ListaDoble();
        Scanner sc = new Scanner(System.in);
        System.out.println("De que tamaño será su lista?");
        iVal = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < iVal; i++) {
            lista.agregarNodo(new Nodo((int) (Math.random() * 100)));
        }
        System.out.println("Original");
        lista.imprimir();
        System.out.println("");
        System.out.println("QuickSort");
        lista.quickSort(lista.inicio);
        lista.imprimir();        
        // lista.test();
        
    }
    
}

