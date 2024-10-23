package strukdat;

// Node class for the linked list
class Node {
    int nim;
    String nama;
    Node next;

    // Constructor untuk Node
    public Node(int nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    // Menampilkan Node
    public void displayNode() {
        System.out.println("NIM: " + nim + ", Nama: " + nama);
    }
}

// Queue class implementing linked list
class Queue {
    private Node front, rear;

    // Constructor untuk Queue
    public Queue() {
        front = rear = null;
    }

    // Insert a new node at the end
    public void insert(int nim, String nama) {
        Node newNode = new Node(nim, nama);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        System.out.println("Mahasiswa dengan NIM: " + nim + " masuk antrian.");
    }

    // Remove node from the front
    public Node remove() {
        if (isEmpty()) {
            System.out.println("Queue kosong.");
            return null;
        }
        Node temp = front;
        front = front.next;
        if (front == null) rear = null;
        System.out.println("Mahasiswa dengan NIM: " + temp.nim + " di-remove.");
        return temp;
    }

    // Display all nodes in the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue kosong.");
            return;
        }
        System.out.println("Isi dari depan ke belakang:");
        Node current = front;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}

// Main class to test the queue
public class Quelink {
    public static void main(String[] args) {
        Queue queue = new Queue();  // Buat objek Queue
        
        queue.insert(123, "Ali");
        queue.insert(124, "Ardi");
        queue.insert(125, "Nur");
        queue.insert(126, "Mada");
        
        queue.displayQueue();  // Tampilkan isi queue
        
        queue.remove();  // Remove elemen depan
        
        queue.displayQueue();  // Tampilkan lagi setelah remove
    }
}
