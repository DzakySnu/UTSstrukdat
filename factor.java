/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;


class Factorial {

    // Method untuk menghitung faktorial menggunakan iterasi
    public static int factorialIter(int n) {
        int result = 1; // Inisialisasi hasil
        for (int i = 1; i <= n; i++) {
            result *= i; // Mengalikan hasil dengan angka i
        }
        return result;
    }
    
    public static int factorialRecur(int n) {
        if (n == 1) { // Base case: faktorial dari 1 adalah 1
            return 1;
        } else {
            return n * factorialRecur(n - 1); // Memanggil dirinya sendiri
        }
    }
}

public class factor {
    public static void main(String[] args) {
        Factorial fct = new Factorial();
        int n = 5; // Nilai yang ingin dihitung faktorialnya
        int resultI = fct.factorialIter(n);
        int resultR = fct.factorialRecur(n);
        System.out.println("Faktorial dari " + n + " (iterasi) adalah: " + resultI);
        System.out.println("Faktorial dari " + n + " (Rekursi) adalah: " + resultR);
    }           
}
