/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;
/**
 *
 * @author dzaky
 */

    // Definisi class Queue
class Queue {
    // Deklarasi variabel-variabel privat untuk queue
    private int maxSize;      // Menyimpan ukuran maksimum queue
    private long[] queArray;  // Array yang digunakan untuk menyimpan elemen-elemen queue
    private int front;        // Menunjuk elemen paling depan dalam queue
    private int rear;         // Menunjuk elemen paling belakang dalam queue
    private int nItems;       // Menyimpan jumlah elemen saat ini dalam queue

    // Konstruktor queue, diinisialisasi dengan ukuran maksimum 'size'
    public Queue(int size) {
        this.maxSize = size;         // Mengatur ukuran maksimum queue sesuai parameter 'size'
        queArray = new long[maxSize]; // Membuat array baru dengan ukuran maxSize untuk menyimpan elemen
        front = 0;                   // Mengatur front ke indeks 0 (awal)
        rear = -1;                   // Rear diatur ke -1 untuk menandai belum ada elemen
        nItems = 0;                  // nItems diatur ke 0 karena queue masih kosong
    }

    // Method untuk menambahkan (insert) elemen baru ke belakang (rear) queue
    public void insert(long value) {
        if (rear == maxSize - 1) {   // Jika rear mencapai batas akhir array, kembali ke indeks 0 (sirkular)
            rear = -1;
        }
        queArray[++rear] = value;    // Tambahkan elemen baru ke posisi berikutnya dari rear
        nItems++;                    // Tambah jumlah elemen dalam queue
    }

    // Method untuk menghapus (remove) elemen paling depan dari queue
    public long remove() {
        long temp = queArray[front++]; // Ambil elemen di posisi front, lalu tambahkan front (elemen dihapus)
        if (front == maxSize) {        // Jika front mencapai batas akhir array, kembali ke indeks 0 (sirkular)
            front = 0;
        }
        nItems--;                      // Kurangi jumlah elemen dalam queue
        return temp;                   // Kembalikan elemen yang dihapus
    }

    // Method untuk melihat elemen paling depan dalam queue tanpa menghapusnya
    public long peekFront() {
        return queArray[front];        // Mengembalikan nilai elemen di posisi front
    }

    // Method untuk memeriksa apakah queue kosong
    public boolean isEmpty() {
        return (nItems == 0);          // Jika jumlah elemen 0, berarti queue kosong
    }

    // Method untuk memeriksa apakah queue penuh
    public boolean isFull() {
        return (nItems == maxSize);    // Jika jumlah elemen sama dengan ukuran maksimum, berarti queue penuh
    }

    // Method untuk mendapatkan jumlah elemen saat ini dalam queue
    public int size() {
        return nItems;                 // Mengembalikan jumlah elemen dalam queue
    }
}

// Class QueueApp yang berfungsi sebagai main program untuk menguji Queue
public class ques {
    public static void main(String[] args) {
        // Membuat objek queue dengan ukuran maksimum 5
        Queue theQueue = new Queue(5);

        // Menambahkan elemen-elemen ke dalam queue (10, 20, 30, 40)
        theQueue.insert(10);  // Insert 10
        theQueue.insert(20);  // Insert 20
        theQueue.insert(30);  // Insert 30
        theQueue.insert(40);  // Insert 40

        // Menghapus tiga elemen dari depan queue (akan menghapus 10, 20, 30)
        theQueue.remove();    // Remove elemen 10
        theQueue.remove();    // Remove elemen 20
        theQueue.remove();    // Remove elemen 30

        // Menambahkan elemen baru ke dalam queue (50, 60, 70)
        theQueue.insert(50);  // Insert 50
        theQueue.insert(60);  // Insert 60
        theQueue.insert(70);  // Insert 70

        // Menambahkan elemen lagi (80), sehingga queue berisi: 40, 50, 60, 70, 80
        theQueue.insert(80);  // Insert 80

        // Mengeluarkan elemen dari queue dan menampilkannya hingga queue kosong
        while (!theQueue.isEmpty()) {  // Looping selama queue tidak kosong
            long n = theQueue.remove();  // Menghapus dan mengambil elemen dari depan queue
            System.out.print(n);         // Menampilkan elemen yang dihapus
            System.out.print(" ");       // Menampilkan spasi setelah setiap elemen
        }
        System.out.println("");         // Baris baru setelah semua elemen ditampilkan
    }
}


