/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;
/**
 *
 * @author dzaky
 */

class Stack {
    // Deklarasi variabel-variabel privat untuk stack
    private int maxSize;        // Menyimpan ukuran maksimum stack
    private long[] stackArray;  // Array yang akan digunakan untuk menyimpan elemen stack
    private int top;            // Menunjuk posisi elemen teratas di stack

    // Konstruktor stack, akan dipanggil saat membuat objek stack baru
    public Stack(int size) {
        maxSize = size;           // Menginisialisasi ukuran maksimum stack dengan nilai parameter 'size'
        stackArray = new long[maxSize]; // Membuat array dengan ukuran maxSize untuk menyimpan elemen stack
        top = -1;                 // Inisialisasi top menjadi -1 menandakan bahwa stack kosong
    }

    // Method untuk menambahkan (push) elemen baru ke stack
    public void push(long item) {
        stackArray[++top] = item;  // Menambah nilai top dan memasukkan item ke posisi baru di stack
    }

    // Method untuk menghapus (pop) elemen teratas dari stack dan mengembalikannya
    public long pop() {
        return stackArray[top--];  // Mengembalikan nilai elemen di posisi top dan kemudian mengurangi nilai top
    }

    // Method untuk melihat elemen di puncak stack tanpa menghapusnya
    public long peek() {
        if (isEmpty()) {
            System.out.println("habis");
        } else {
        return stackArray[top];    // Mengembalikan nilai elemen di posisi top tanpa mengubahnya
        }
        return 0;
        }

    // Method untuk memeriksa apakah stack kosong
    public boolean isEmpty() {
        return (top == -1);        // Jika top bernilai -1, berarti stack kosong
    }

    // Method untuk memeriksa apakah stack sudah penuh
    public boolean isFull() {
        return (top == maxSize - 1); // Jika top mencapai maxSize - 1, berarti stack penuh
    }
}

public class stakque {
    public static void main(String[] args) {
        // Membuat objek stack dengan ukuran 10
        Stack theStack = new Stack(10);

        // Menampilkan pesan bahwa beberapa elemen akan dimasukkan (push) ke stack
        System.out.println(">> push some items");

        // Melakukan operasi push untuk memasukkan elemen ke stack
        theStack.push(20);  // Memasukkan elemen 20 ke dalam stack
        theStack.push(40);  // Memasukkan elemen 40 ke dalam stack
        theStack.push(60);  // Memasukkan elemen 60 ke dalam stack
        theStack.push(80);
        

        // Menampilkan pesan bahwa elemen-elemen akan di-pop dari stack
        System.out.println("\n>> pop items in the stack");

        // Melakukan operasi pop untuk mengeluarkan elemen dari stack selama stack tidak kosong
        while (!theStack.isEmpty()) {     // Mengecek apakah stack masih berisi elemen
            long value = theStack.pop();    // Mengambil elemen teratas dari stack dengan operasi pop
            System.out.print(value + " ");  // Menampilkan elemen yang di-pop
        }
        
        theStack.peek();
    }
}
