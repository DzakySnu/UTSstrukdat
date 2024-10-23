class Node {
    long nim;
    double score;
    Node prev;
    Node next;

    public Node(long nim, double score) {
        this.nim = nim;
        this.score = score;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    
    public void addRecord(long nim, double score) {
        Node newNode = new Node(nim, score);
        if (head == null) {
            head = tail = newNode;  
        } else {
            Node current = head;
            while (current != null && current.score < score) {
                current = current.next;
            }
            if (current == null) {  
                tail.next = newNode;  
                newNode.prev = tail;  
                tail = newNode;       
            } else if (current == head) { 
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else {  
                Node prevNode = current.prev;
                prevNode.next = newNode;
                newNode.prev = prevNode;
                newNode.next = current;
                current.prev = newNode;
            }
        }
        size++;
    }

    
    public double calculateAverage() {
        if (size == 0) return 0;
        double totalScore = 0;
        Node current = head;
        while (current != null) {
            totalScore += current.score;
            current = current.next;
        }
        return totalScore / size;
    }

    
    public double calculateMedian() {
        if (size == 0) return 0;

        Node left = head;
        Node right = tail;

        
        for (int i = 0; i < size / 2; i++) {
            left = left.next;
            right = right.prev;
        }

       
        if (size % 2 == 1) {
            return left.score;
        } else { 
            return (left.score + right.score) / 2;
        }
    }

    
    public int[] countPassFail(double passingScore) {
        int passCount = 0;
        int failCount = 0;
        Node current = head;
        while (current != null) {
            if (current.score >= passingScore) {
                passCount++;
            } else {
                failCount++;
            }
            current = current.next;
        }
        return new int[]{passCount, failCount};
    }

    
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println("NIM: " + current.nim + ", Score: " + current.score);
            current = current.next;
        }
    }
}

public class kisisiuts {
    public static void main(String[] args) {
        
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addRecord(12345, 78.5);
        dll.addRecord(23456, 85.0);
        dll.addRecord(34567, 90.5);
        dll.addRecord(45678, 60.0);
        dll.addRecord(56789, 72.3);
        dll.addRecord(67890, 88.0);
        dll.addRecord(78901, 93.2);
        dll.addRecord(89012, 55.6);
        dll.addRecord(90123, 67.4);
        dll.addRecord(10123, 80.0);

        
        System.out.println("Daftar mahasiswa dan nilai secara urut:");
        dll.printList();

      
        double averageScore = dll.calculateAverage();
        System.out.printf("\nRata-rata nilai mahasiswa: %.2f\n", averageScore);

      
        double medianScore = dll.calculateMedian();
        System.out.printf("Median nilai mahasiswa: %.2f\n", medianScore);

       
        double passingScore = 70.0;  
        int[] passFailCounts = dll.countPassFail(passingScore);
        System.out.println("\nJumlah mahasiswa yang lulus: " + passFailCounts[0]);
        System.out.println("Jumlah mahasiswa yang tidak lulus: " + passFailCounts[1]);
    }
}
