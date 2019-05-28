
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner yolo = new Scanner(System.in);
        System.out.println("Cuantos valores quieres introducir? (String): ");
        int iVal = yolo.nextInt();
        yolo.nextLine();
        String [] aiDatos = new String[iVal];
        String [] aiDatos1 = new String[iVal];
        String [] aiDatos2 = new String[iVal];
        String [] aiDatos3 = new String[iVal];
        String [] aiDatos4 = new String[iVal];
        QuickSort QS = new QuickSort();
        
        for (int i = 0; i < aiDatos.length; i++) {
            System.out.println("Introduce una palabra: ");
            aiDatos[i]= yolo.nextLine();
        }
        copia(aiDatos, aiDatos1);
        copia(aiDatos, aiDatos2);
        copia(aiDatos, aiDatos3);
        copia(aiDatos, aiDatos4);
        
        System.out.println("Original");
        imprimir(aiDatos);
        System.out.println("Selection sort");
        selectionSort(aiDatos1);
        imprimir(aiDatos1);
        System.out.println("Insertion");
        insertionSort(aiDatos2);
        imprimir(aiDatos2);
        System.out.println("Bubble");
        bubbleSort(aiDatos3);
        imprimir(aiDatos3);
        System.out.println("Quick");
        QS.sort(aiDatos4, 0, aiDatos4.length - 1);
        imprimir(aiDatos4);
        
        
    }
      public static void copia(String aiDatos[], String aiCopia[]){
        for (int i = 0; i < aiDatos.length; i++) {
            aiCopia[i] = aiDatos[i];
        }
    }
    public static void imprimir(String aiDatos[]){
        for (int i = 0; i < aiDatos.length; i++) {
            System.out.print("[" + aiDatos[i] + "]");
        }
        System.out.println("");
    }
    
    public static void selectionSort(String aiDatos []){
        for (int i = 0; i < aiDatos.length - 1; i++) {
            int iMin = i;
            for (int j = i+1; j < aiDatos.length; j++) {
                if(aiDatos[j].compareTo(aiDatos[iMin]) < 0){
                    iMin = j;
                }
            }
            
            if(iMin != i){
                String iTemp = aiDatos[i];
                    aiDatos[i] = aiDatos[iMin];
                    aiDatos[iMin] = iTemp;
            }
        }
    }
    
    public static void insertionSort(String[] aiDatos){  //Hace menos comparaciones pero mas intercambios    O(N)           O(N^2)
                String temp;
                for (int i = 1; i < aiDatos.length; i++) {   
                   
                    for (int j = i; j > 0; j--) {
                        if(aiDatos[j].compareTo(aiDatos[j-1]) < 0){
                           temp = aiDatos[j];
                           aiDatos[j] = aiDatos[j-1];
                           aiDatos[j-1] = temp;
                        } 
                    }           
                }
            }
    
    public static void bubbleSort(String aiDatos[]) 
    { 
        int n = aiDatos.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (aiDatos[j].compareTo(aiDatos[j+1]) > 0) 
                { 
                    String iTemp = aiDatos[j]; 
                    aiDatos[j] = aiDatos[j+1]; 
                    aiDatos[j+1] = iTemp; 
                } 
    }
    
        public static void quickSort(String aiDatos[], int low, int high){
           
        if(low < high){
            int pi = partition(aiDatos, low, high);
            
            quickSort(aiDatos, low, pi - 1);
            quickSort(aiDatos, pi + 1, high);
        }
    }
    
    
     private static int partition(String aiDatos[], int low, int high){
        String pivot = aiDatos[high];
        int i = (low - 1);
        for (int j = low; i <= high - 1; j++) {
            if(aiDatos[j].compareTo(pivot) > 0){
                i++;
                String iTemp = aiDatos[i];
                aiDatos[i] = aiDatos[j];
                aiDatos[j] = iTemp;
                
            }
        }
        String iTemp = aiDatos[i+1];
        aiDatos[i + 1] = aiDatos[high];
        aiDatos[high] = iTemp;
        return (i+1);
    }
    
    
}
class QuickSort 
{ 
    int partition(String aiDatos[], int low, int high) 
    { 
        String pivot = aiDatos[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            
            if (aiDatos[j].compareTo(pivot) < 0){ 
                i++; 
  
                String temp = aiDatos[i]; 
                aiDatos[i] = aiDatos[j]; 
                aiDatos[j] = temp; 
            } 
        }
        
                String temp = aiDatos[i+1]; 
                aiDatos[i+1] = aiDatos[high]; 
                aiDatos[high] = temp;
                
            return i + 1;
    } 
    void sort(String aiDatos[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(aiDatos, low, high); 
  
            sort(aiDatos, low, pi-1); 
            sort(aiDatos, pi+1, high); 
        } 
    }
}
