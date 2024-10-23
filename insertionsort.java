/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

/**
 *
 * @author dzaky
 */
public class insertionsort {
    int arr[] = new int[6];
    int nElemen = arr.length;
    
    public static void main(String[] args) {
        insertionsort st = new insertionsort();
        
        st.arr[0] = 20;
        st.arr[1] = 10;
        st.arr[2] = 40;
        st.arr[3] = 60;
        st.arr[4] = 70;
        st.arr[5] = 30;
        
        System.out.println("sebelum sort");
        st.printa();
        
        st.InsertionSort();  // Menggunakan Insertion Sort
        
        System.out.println("sesudah");
        st.printa();
    }
    
    public void InsertionSort() {
        int i, curIn;
        // Mulai dari elemen kedua (indeks 1) karena elemen pertama dianggap sudah terurut
        for (curIn = 1; curIn < nElemen; curIn++) {
            int temp = arr[curIn];  // Elemen yang akan disisipkan
            i = curIn;  // Posisi saat ini
            
            // Geser elemen-elemen yang lebih besar ke kanan
            while (i > 0 && arr[i - 1] > temp) {
                arr[i] = arr[i - 1];
                i--;
                
                System.out.println("Setelah geser");
                printa();
            }
            
            // Sisipkan elemen yang diseleksi ke posisi yang benar
            arr[i] = temp;
            System.out.println("Setelah masukin");
            printa();
            
        }
    }
    
    public void swap(int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
    
    public void printa() {
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}

