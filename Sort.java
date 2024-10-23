/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package strukdat;

import java.util.Random;

/**
 *
 * @author dzaky
 */
public class Sort {

    
    
    private int[] arr;

    
    
    public static void main(String[] args) {
        Sort sor = new Sort();
        Random rand = new Random();
        
        sor.arr = new int[100];
        
        for (int i = 0; i < 10; i++) {
            sor.arr[i] = rand.nextInt(100);
        }
        System.out.println("sebelum");
        sor.printa();
        
        sor.buble();
        sor.printa();
        
        sor.select();
        sor.printa();
        
        sor.insert();
        sor.printa();
        
    }
    
    public void printa() {
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println("");
    }
    
    public void buble() {
        int nelement = 10;  // Length of the array
        for (int i = 0; i < nelement - 1; i++) {
            for (int j = 0; j < nelement - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {  // Compare adjacent elements
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public void select() {
        int nelemnt = 10;
        for (int i = 0; i < nelemnt; i++) {
            int minix = i;
            for (int j = i+1; j < nelemnt; j++) {
                if (arr[j] < arr[minix]) {
                    minix = j; 
                }
            }
            int temp = arr[minix];
            arr[i] = arr[minix];
            arr[minix] = temp;
        }        
    }
    
    public void insert(){
        int nelemnt = 10;
        for (int i = 1; i < nelemnt; i++) {
            int key = arr[i];
            int j = i-1;
            
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
    
    
    
}
