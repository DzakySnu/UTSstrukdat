package strukdat;

class Node {
    // Properties
    String namaKepalaKeluarga;
    int jumlahAnggotaKeluarga;
    String alamat;
    Node prev;
    Node next;
    
    // Constructor - make sure this matches exactly how it's called
    Node(String namaKepalaKeluarga, int jumlahAnggotaKeluarga, String alamat) {
        this.namaKepalaKeluarga = namaKepalaKeluarga;
        this.jumlahAnggotaKeluarga = jumlahAnggotaKeluarga;
        this.alamat = alamat;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    // Constructor
    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Check if name exists
    private boolean isNamaExist(String namaKepalaKeluarga) {
        Node current = head;
        while (current != null) {
            if (current.namaKepalaKeluarga.equals(namaKepalaKeluarga)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Add new record
    public void addRecord(String namaKepalaKeluarga, int jumlahAnggotaKeluarga, String alamat) {
        if (isNamaExist(namaKepalaKeluarga)) {
            System.out.println("Nama kepala keluarga sudah terdaftar: " + namaKepalaKeluarga);
            return;
        }

        Node newNode = new Node(namaKepalaKeluarga, jumlahAnggotaKeluarga, alamat);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        System.out.println("Data berhasil ditambahkan: " + namaKepalaKeluarga);
    }

    // Search by name
    public void searchByNamaKepalaKeluarga(String namaKepalaKeluarga) {
        if (head == null) {
            System.out.println("Daftar kosong");
            return;
        }

        Node left = head;
        Node right = tail;

        while (left != null && right != null && left != right && left.prev != right) {
            if (left.namaKepalaKeluarga.equals(namaKepalaKeluarga)) {
                System.out.println("Data ditemukan (dari depan):");
                printNode(left);
                return;
            }
            if (right.namaKepalaKeluarga.equals(namaKepalaKeluarga)) {
                System.out.println("Data ditemukan (dari belakang):");
                printNode(right);
                return;
            }
            left = left.next;
            right = right.prev;
        }

        if (left == right && left != null && left.namaKepalaKeluarga.equals(namaKepalaKeluarga)) {
            System.out.println("Data ditemukan:");
            printNode(left);
        } else {
            System.out.println("Data tidak ditemukan: " + namaKepalaKeluarga);
        }
    }

    // Print node details
    private void printNode(Node node) {
        System.out.println("Nama Kepala Keluarga: " + node.namaKepalaKeluarga);
        System.out.println("Jumlah Anggota: " + node.jumlahAnggotaKeluarga);
        System.out.println("Alamat: " + node.alamat + "\n");
    }

    // Print all records
    public void printList() {
        if (head == null) {
            System.out.println("Daftar kosong");
            return;
        }

        System.out.println("\n=== Daftar Warga RT ===");
        Node current = head;
        while (current != null) {
            printNode(current);
            current = current.next;
        }
        System.out.println("Total keluarga: " + size);
    }
}

public class RT {
    public static void main(String[] args) {
        // Create new list
        DoublyLinkedList wargaRT = new DoublyLinkedList();

        // Add records
        System.out.println("Menambahkan data warga:");
        wargaRT.addRecord("Pak Budi", 4, "Jl. Mawar No. 12");
        wargaRT.addRecord("Bu Ani", 3, "Jl. Melati No. 5");
        wargaRT.addRecord("Pak Joko", 5, "Jl. Anggrek No. 8");

        // Print all records
        wargaRT.printList();

        // Search for records
        System.out.println("\nMencari data warga:");
        wargaRT.searchByNamaKepalaKeluarga("Pak Budi");
        wargaRT.searchByNamaKepalaKeluarga("Bu Ani");
        wargaRT.searchByNamaKepalaKeluarga("Pak Eko"); // Should not be found
    }
}