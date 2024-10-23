/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

// Kelas yang merepresentasikan node di linked list (elemen stack)
class Node {
    public int id;  // Field untuk menyimpan ID barang elektronik
    public String namaBarang;  // Field untuk menyimpan nama barang elektronik
    public Node next;  // Pointer ke node berikutnya dalam stack (linked list)

    // Konstruktor untuk menginisialisasi node baru
    public Node(int id, String namaBarang) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.next = null;
    }

    // Metode untuk menampilkan informasi barang dalam node
    public void displayNode() {
        System.out.println("ID Barang: " + id + ", Nama Barang: " + namaBarang);
    }
}

// Kelas untuk mengimplementasikan stack menggunakan linked list
class Stack {
    private Node top;  // Pointer ke elemen teratas dalam stack

    // Konstruktor untuk menginisialisasi stack kosong
    public Stack() {
        top = null;
    }

    // Metode untuk menambahkan elemen (barang) ke dalam stack
    public void push(int id, String namaBarang) {
        Node newNode = new Node(id, namaBarang);  // Membuat node baru
        newNode.next = top;  // Set node baru menjadi elemen teratas
        top = newNode;  // Update top ke node baru
        System.out.println("Barang berhasil ditambahkan ke stack: " + namaBarang);
    }

    // Metode untuk menghapus elemen teratas dari stack (pop)
    public Node pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong, tidak ada yang bisa di-pop.");
            return null;
        } else {
            Node temp = top;  // Menyimpan elemen teratas untuk dihapus
            top = top.next;  // Menggeser elemen teratas ke node berikutnya
            System.out.println("Barang di-pop dari stack: " + temp.namaBarang);
            return temp;  // Mengembalikan elemen yang dihapus
        }
    }

    // Metode untuk menampilkan semua elemen dalam stack
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
        } else {
            System.out.println("Isi stack dari atas ke bawah:");
            Node current = top;  // Mulai dari elemen teratas
            while (current != null) {
                current.displayNode();  // Menampilkan data tiap node
                current = current.next;  // Pindah ke node berikutnya
            }
        }
    }

    // Metode untuk memeriksa apakah stack kosong
    public boolean isEmpty() {
        return (top == null);  // Jika top == null, berarti stack kosong
    }
}

// Kelas utama untuk menjalankan program
public class linkstack {
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Push beberapa barang elektronik ke stack
        stack.push(101, "TV");
        stack.push(102, "Laptop");
        stack.push(103, "Smartphone");
        stack.push(104, "Tablet");

        // Tampilkan isi stack
        stack.displayStack();

        // Pop satu barang dari stack
        stack.pop();

        // Tampilkan isi stack setelah pop
        stack.displayStack();
    }
}

