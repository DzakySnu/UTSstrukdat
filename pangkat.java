/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

import java.util.Scanner;

class rekursangka {
    public static int pangkatan(int base, int exp) {
        if (exp == 0) {
            return 1;
        } else {
            return base * pangkatan(base,exp-1);
    }
}
}

public class pangkat {
    public static void main(String[] args) {
        rekursangka rks = new rekursangka();
        java.util.Scanner scn = new Scanner(System.in);
        int base = 2;
        int exp = 3;
        int hasil = rks.pangkatan(base, exp);
        System.out.println("hasil : " + hasil);
        
    }
}
