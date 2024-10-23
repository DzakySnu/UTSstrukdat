/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

/**
 *
 * @author dzaky
 */
public class insertordered {
    private int[] array = new int [10];
    private int nelement = 0;
    
    public void insert(int value){
        int posisi = nelement;
        
        for (int i = 0; i < nelement; i++) {
            if (array[i] > value) { 
                posisi = i;
                break;
            }
        }
        
        for (int i = nelement; i > posisi; i--) {
            array[i] = array[i - 1];
        }
        
        array[posisi] = value;
        nelement++;
    }
    
    public void printArray() {
        for (int i = 0; i < nelement; i++) { 
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
    
    public int biner(int value) {
        int l = 0;
        int h = nelement-1;
        
        while (l <= h) {            
            int m = (l+h)/2;
            
            if (array[m] == value) {
                return m;
            } else if (array[m] < value) {
                l = m +1;
            } else {
                h = m - 1;
            }
        }
        return  -1;
    }
    
    public static void main(String[] args) {
        insertordered io = new insertordered();
        
        io.insert(8);
        io.insert(9);
        io.insert(4);
        io.insert(2);
        io.insert(3);
        
        System.out.println("array dari kosong di tambahi");
        io.printArray();
        
        io.insert(5);
        io.insert(1);
        System.out.println("tambahan");
        io.printArray();
        
        int temu = 5;
        int ketemu = io.biner(temu);
        
        if (ketemu != -1){
            System.out.println("ketemu");
        } else {
            System.out.println("tidak ");
        }
    }
}


