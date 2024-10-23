package strukdat;

// Kelas Link merepresentasikan sebuah node dalam doubly linked list
class Link {
    public int Data;        // Data yang disimpan dalam node
    public Link next;       // Referensi ke node berikutnya
    public Link previous;   // Referensi ke node sebelumnya
    
    // Constructor untuk membuat node baru
    public Link(int Data) {
        this.Data = Data;
    }
    
    // Metode untuk menampilkan data node
    public void displayLink() {
        System.out.print(Data + " ");
    }
}

// Kelas DoublyLinkedList mengimplementasikan struktur doubly linked list
class DoublyLinkedList {
    private Link first;     // Referensi ke node pertama
    private Link last;      // Referensi ke node terakhir
    
    // Constructor untuk membuat list kosong
    public DoublyLinkedList() {
        first = null;
        last = null;
    }
    
    // Memeriksa apakah list kosong
    public boolean isEmpty() {
        return first == null;
    }
    
    // Menyisipkan node baru di awal list
    public void insertFirst(int Data) {
        Link newLink = new Link(Data);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }
    
    // Menyisipkan node baru di akhir list
    public void insertLast(int Data) {
        Link newLink = new Link(Data);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }
    
    // Menghapus node pertama dari list
    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }
    
    // Menghapus node terakhir dari list
    public Link deleteLast() {
        Link temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }
    
    // Menyisipkan node baru setelah node dengan key tertentu
    public boolean insertAfter(int key, int Data) {
        Link current = first;
        while (current.Data != key) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        Link newLink = new Link(Data);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }
    
    // Menghapus node dengan key tertentu
    public Link deleteKey(int key) {
        Link current = first;
        while (current.Data != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }
    
    // Menampilkan list dari depan ke belakang
    public void displayForward() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
    
    // Menampilkan list dari belakang ke depan
    public void displayBackward() {
        System.out.print("List (last-->first): ");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println("");
    }
}

// Kelas utama untuk menguji implementasi DoublyLinkedList
public class doublelink {
    public static void main(String[] args) {
        DoublyLinkedList theList = new DoublyLinkedList();
        
        // Menyisipkan beberapa elemen di awal list
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.displayForward();    
      
        // Menyisipkan beberapa elemen di akhir list
        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayForward();    
        theList.displayBackward();   
        
        // Menghapus elemen pertama
        theList.deleteFirst();
        theList.displayForward();    
        
        // Menghapus elemen terakhir
        theList.deleteLast();
        theList.displayForward();   
       
        // Menghapus elemen dengan key tertentu
        theList.deleteKey(11);
        theList.displayForward();    
       
        // Menyisipkan elemen setelah node dengan key tertentu
        theList.insertAfter(22, 77);
        theList.insertAfter(33, 88);
        theList.displayForward();    
    }
}