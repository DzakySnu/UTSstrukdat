/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

class rekur {
    public int fibon(int n) {
        if (n <= 1) {
            return n;
        }
        return fibon(n-1) + fibon(n-2);
    }
    
    public int fac(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fac(n-1);
    }
}
    
class sort {
    public void buble(int[] ar) {
        int batas;
        for (batas = ar.length;  batas> 0; batas--) {
            for (int i = 0; i < batas-1; i++) {
                if (ar[i] > ar[i+1]) {
                    swap(ar, i, i+1);
                }
            }
        }
    }
    
    public void select(int[] ar){
        int n = ar.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (ar[j] < ar[min]) {
                    min = j;
                }
            }
            swap(ar, i, min);
        }
    }
    
    public void swap(int[]ar,int one,int two) {
        int temp = ar[one];
        ar[one] = ar[two];
        ar[two] = temp;
    }
    
    public void printa(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
public class traing {
    public static void main(String[] args) {
        rekur rk = new rekur();
        sort sr = new sort();
        int[] ar1 = {43,21,2,5,1};
        int[] ar2 = {23,12,56,87,1,10};
        
        System.out.println(rk.fibon(4));
        System.out.println(rk.fac(4));
        sr.buble(ar1);
        sr.printa(ar1);
        sr.select(ar2);
        sr.printa(ar2);
    }
}
