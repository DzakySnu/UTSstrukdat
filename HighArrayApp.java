/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

/**
 *
 * @author dzaky
 */
// Kelas utama yang menjalankan aplikasi HighArray
public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100; // Ukuran maksimum array
        HighArray arr = new HighArray(maxSize); // Membuat objek HighArray dengan ukuran maxSize
        arr.insert(70); // Menambahkan elemen 70 ke array
        arr.insert(80); // Menambahkan elemen 80 ke array
        arr.insert(75); // Menambahkan elemen 75 ke array
        arr.insert(55); // Menambahkan elemen 55 ke array
        arr.insert(85); // Menambahkan elemen 85 ke array
        arr.insert(25); // Menambahkan elemen 25 ke array
        arr.insert(30); // Menambahkan elemen 30 ke array
        arr.insert(0);  // Menambahkan elemen 0 ke array
        arr.insert(90); // Menambahkan elemen 90 ke array
        arr.insert(40); // Menambahkan elemen 40 ke array
        arr.display();  // Menampilkan elemen-elemen di array

        // Memanggil metode size untuk menampilkan jumlah elemen di array
        System.out.println("Jumlah elemen dalam array: " + arr.size());

        int key = 25; // Elemen yang ingin dicari
        // Mencari elemen di array dan menampilkan hasilnya
        if (arr.find(key)) {
            System.out.println(key + " ditemukan"); // Jika ditemukan
        } else {
            System.out.println(key + " tidak ditemukan"); // Jika tidak ditemukan
        }

        arr.delete(0);   // Menghapus elemen 0 dari array
        arr.delete(80);  // Menghapus elemen 80 dari array
        arr.delete(55);  // Menghapus elemen 55 dari array
        arr.display();   // Menampilkan elemen-elemen yang tersisa di array

        // Menampilkan jumlah elemen setelah beberapa elemen dihapus
        System.out.println("Jumlah elemen dalam array setelah penghapusan: " + arr.size());
    }
}

