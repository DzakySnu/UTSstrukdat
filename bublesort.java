/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

/**
 *
 * @author dzaky
 */
public class bublesort {
    
    int arr[] = new int[6];
    int nElemen = arr.length;
    
    public static void main(String[] args) {
        bublesort bs = new bublesort();
        
        bs.arr[0] = 20;
        bs.arr[1] = 10;
        bs.arr[2] = 40;
        bs.arr[3] = 60;
        bs.arr[4] = 70;
        bs.arr[5] = 30;
        
        System.out.println("sebelum sort");
        bs.printa();
        
        bs.BubbleSort();
        
        System.out.println("sesudah");
        bs.printa();
    }
    
    public void BubbleSort() {
        int batas, i;
        for (batas = nElemen - 1; batas > 0; batas--) {
            for (i = 0; i < batas; i++) {
                if (arr[i] < arr[i + 1]) {
                    swap(i, i + 1);                      
                }
            }
        }
    }
    
    public void swap(int one, int two) {
    int temp = arr[one];
    arr[one] = arr[two];
    arr[two] = temp;
}
    public void printa() {
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

}
