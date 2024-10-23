package strukdat;

class node {
    long nim;
    double skor;
    
    node prev;
    node next;
    
    public node(long nim, double skor) {
        this.nim = nim;
        this.skor = skor;
        this.prev = null;
        this.next = null;
    }
}

class dll {
    private node head;
    private node tail;
    private int size;
    
    public dll() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addrec(long nim, double skor) {
        node newnode = new node(nim, skor);
        if (head == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
        size++;
    }
    
    public double rata() {
        if (head == null) return 0;
        double total = 0;
        node current = head;
        while (current != null) {            
            total += current.skor;
            current = current.next;
        }
        return total/size;
    }
    
    public double med() {
        if (size == 0) return 0;
        node kir = head;
        node kan = tail;
        
        for (int i = 0; i < size/2; i++) {
            kir = kir.next;
            kan = kan.prev;
        }
        
        if (size % 2 == 0) {
            return (kir.skor + kan.skor) / 2;
        } else {
            return kir.skor;
        }
    }
    
    public void lulusg(double kkm) {
        if (size == 0) {
            System.out.println("List kosong");
            return;
        }
        
        int lulus = 0;
        int gagal = 0;
        node current = head;
        
        while (current != null) {            
            if (current.skor >= kkm) {  // Fixed comparison operator
                lulus++;
            } else {
                gagal++;
            }
            current = current.next;
        }
        
        System.out.println("Yang lulus = " + lulus);
        System.out.println("Yang gagal = " + gagal);
    }
    
    public void displ() {
        if (size == 0) {
            System.out.println("List kosong");
            return;
        }
        
        node current = head;
        System.out.println("\nDaftar Nilai Mahasiswa:");
        while (current != null) {            
            System.out.println("NIM: " + current.nim + " | Skor: " + current.skor);
            current = current.next;
        }
    }
}

public class traing {
    public static void main(String[] args) {
        dll dl = new dll();
        dl.addrec(1234, 80);
        dl.addrec(1235, 70);
        dl.addrec(1236, 90);
        double kkm = 80;
        
        System.out.println("Rata-rata: " + dl.rata());
        System.out.println("Median: " + dl.med());
        
        System.out.println("\nHasil Kelulusan (KKM = " + kkm + "):");
        dl.lulusg(kkm);
        
        dl.displ();
    }
}