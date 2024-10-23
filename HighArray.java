/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

/**
 *
 * @author dzaky
 */
class HighArray {
    private int[] arr; // Deklarasi array untuk menyimpan elemen
    private int nElemen; // Menyimpan jumlah elemen yang terisi di array

    // Konstruktor untuk menginisialisasi array dengan ukuran maksimum
    public HighArray(int max) {
        arr = new int[max]; // Membuat array dengan ukuran max
        nElemen = 0; // Inisialisasi jumlah elemen terisi menjadi 0
    }

    // Metode untuk menambahkan elemen baru ke array
    public void insert(int value) {
        arr[nElemen] = value; // Menambahkan nilai pada indeks nElemen
        nElemen++; // Menambah jumlah elemen terisi
    }

    // Metode untuk mencari apakah elemen tertentu ada di array
    public boolean find(int key) {
        int i;
        // Loop untuk mencari elemen di array
        for (i = 0; i < nElemen; i++) {
            if (arr[i] == key) { // Jika elemen ditemukan
                break; // Keluar dari loop
            }
        }
        return i != nElemen; // Mengembalikan true jika ditemukan, false jika tidak
    }

    // Metode untuk menghapus elemen tertentu dari array
    public boolean delete(int value) {
        int i;
        // Mencari posisi elemen yang ingin dihapus
        for (i = 0; i < nElemen; i++) {
            if (value == arr[i]) { // Jika nilai ditemukan
                break; // Keluar dari loop
            }
        }
        if (i == nElemen) { // Jika elemen tidak ditemukan
            return false; // Kembalikan false karena elemen tidak ada
        } else {
            // Memindahkan elemen setelah yang dihapus ke kiri
            for (int j = i; j < nElemen - 1; j++) {
                arr[j] = arr[j + 1]; // Menimpa elemen dengan elemen selanjutnya
            }
            nElemen--; // Mengurangi jumlah elemen terisi
            return true; // Kembalikan true karena elemen berhasil dihapus
        }
    }

    // Metode untuk menampilkan elemen-elemen yang terisi di array
    public void display() {
        // Loop untuk mencetak elemen dari indeks 0 hingga nElemen-1
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i] + " "); // Mencetak elemen
        }
        System.out.println(); // Pindah baris setelah mencetak semua elemen
    }

    // Metode untuk mengembalikan jumlah elemen yang terisi di array
    public int size() {
        return nElemen; // Mengembalikan nilai nElemen
    }
}

