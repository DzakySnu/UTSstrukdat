/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

/**
 *
 * @author dzaky
 */
public class selectionsort {
    
    int arr[] = new int[6];
    int nElemen = arr.length;
    
    public static void main(String[] args) {
        selectionsort st = new selectionsort();
        
        st.arr[0] = 20;
        st.arr[1] = 10;
        st.arr[2] = 40;
        st.arr[3] = 60;
        st.arr[4] = 70;
        st.arr[5] = 30;
        
        System.out.println("sebelum sort");
        st.printa();
        
        st.SelectionSort();
        
        System.out.println("sesudah");
        st.printa();
    }
    
    
    public void SelectionSort() {
        int awal, i, min;
        for (awal=0; awal< nElemen-1; awal++) {
        min = awal;
           for (i = awal + 1; i < nElemen; i++) {
                if (arr[i] < arr[min]) {
                min = i;
        }
        }
        swap(awal, min);
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
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

}
