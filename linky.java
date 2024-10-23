package strukdat;

class Link {
    public int Data;      // Data yang disimpan di node
    public Link next;     // Pointer ke node berikutnya

    public Link(int Data) {   // Konstruktor untuk inisialisasi node dengan data
        this.Data = Data;
    }

    public void displayLink() {  // Menampilkan data di node ini
        System.out.print(Data + " ");
    }
}

class LinkedList {
    private Link first;  // Pointer ke node pertama

    // Konstruktor
    public LinkedList() {
        first = null;
    }

    // Memeriksa apakah list kosong
    public boolean isEmpty() {
        return (first == null);
    }

    // Metode untuk menambahkan node di awal list
    public void insertFirst(int Data) {
        Link newLink = new Link(Data);
        newLink.next = first;
        first = newLink;
    }

    // Metode untuk menambahkan node di akhir list
    public void insertLast(int Data) {
        Link newLink = new Link(Data);  // Buat node baru dengan data
        if (isEmpty()) {                // Jika list kosong, node baru menjadi node pertama
            first = newLink;
        } else {
            Link current = first;       // Mulai dari node pertama
            while (current.next != null) {  // Looping sampai menemukan node terakhir
                current = current.next;
            }
            current.next = newLink;     // Set node terakhir agar menunjuk ke node baru
        }
    }

    // Metode untuk menghapus node pertama
    public Link deleteFirst() {
        Link temp = first;
        if (!isEmpty()) {
            first = first.next;         // Geser first ke node berikutnya
        }
        return temp;                    // Kembalikan node yang dihapus
    }

    // Metode untuk menghapus node terakhir
    public Link deleteLast() {
        if (isEmpty()) {               // Jika list kosong
            return null;
        }

        if (first.next == null) {       // Jika hanya ada satu node
            Link temp = first;          // Simpan node pertama
            first = null;               // Hapus satu-satunya node
            return temp;                // Kembalikan node yang dihapus
        }

        Link current = first;           // Mulai dari node pertama
        Link previous = null;           // Variabel untuk menyimpan node sebelum node terakhir

        // Traversing untuk menemukan node terakhir
        while (current.next != null) {  // Looping sampai node terakhir ditemukan
            previous = current;         // Simpan referensi ke node sebelumnya
            current = current.next;     // Pindah ke node berikutnya
        }

        previous.next = null;           // Set node sebelum terakhir agar menjadi node terakhir
        return current;                 // Kembalikan node terakhir yang dihapus
    }

    // Menampilkan isi linked list
    public void displayList() {
        System.out.print("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    // Mencari node berdasarkan data (key)
    public Link find(int key) {
        Link current = first;
        while (current != null && current.Data != key) {
            current = current.next;
        }
        return current;  // Kembalikan node jika ditemukan, null jika tidak
    }

    // Menghapus node dengan data tertentu (key)
    public Link delete(int key) {
        Link current = first;
        Link previous = first;

        // Loop untuk mencari node dengan key yang cocok
        while (current != null && current.Data != key) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return null;  // Node dengan key tidak ditemukan
        }

        if (current == first) {  // Jika node yang dihapus adalah node pertama
            first = first.next;
        } else {
            previous.next = current.next;  // Skip node yang dihapus
        }

        return current;  // Kembalikan node yang dihapus
    }
}

public class linky {
    public static void main(String[] args) {
        LinkedList theList = new LinkedList();

        // Menambahkan node di awal
        theList.insertFirst(22);  // List: 22
        theList.insertFirst(44);  // List: 44 -> 22
        theList.displayList();    // Output: 44 22

        // Menambahkan node di akhir
        theList.insertLast(33);   // List: 44 -> 22 -> 33
        theList.insertLast(55);   // List: 44 -> 22 -> 33 -> 55
        theList.displayList();    // Output: 44 22 33 55

        // Menghapus node terakhir
        Link deleted = theList.deleteLast();   // Hapus node 55
        if (deleted != null) {
            System.out.println("Deleted: " + deleted.Data);
        }
        theList.displayList();    // Output: 44 22 33

        deleted = theList.deleteLast();        // Hapus node 33
        if (deleted != null) {
            System.out.println("Deleted: " + deleted.Data);
        }
        theList.displayList();    // Output: 44 22

        // Mencoba mencari node
        Link found = theList.find(22);
        if (found != null) {
            System.out.println("Found: " + found.Data);
        } else {
            System.out.println("Node tidak ditemukan.");
        }

        // Menghapus node dengan key tertentu
        Link deletedKey = theList.delete(44);
        if (deletedKey != null) {
            System.out.println("Deleted node with key: " + deletedKey.Data);
        } else {
            System.out.println("Node dengan key tidak ditemukan.");
        }
        theList.displayList();    // Output: 22
    }
}
