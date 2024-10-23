/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

class node {
    int data;
    node prev;
    node next;
    
    public node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class doublylink {
    node first;
    node last;
    
    public doublylink(){
        this.first = null;
        this.last = null;
    }
    
    public void insertlast(int data) {
        node newnode = new node(data);
        if (first == null) {
            first = newnode;
            last = newnode;
        } else {
            last.next = newnode;
            newnode.prev = last;
            last = newnode;
        }
    }
    
    public boolean bidirectional(int target) {
        if (first == null) {
            return false;
        }
        
        node start = first;
        node end = last;
        
        while (start != null && end != null && start != end && start.prev != end) {            
            if (start.data == target || end.data == target) {
                return true;
            }
            
            start = start.next;
            
            end = end.prev;
            
        }
        if (start == end && start.data == target) {
            return true;
        }
        return false;
    }
    
    public void displaynode() {
        node current = first;
        while (current != null) {            
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }
}

public class bidirect {
        public static void main(String[] args) {
        // Create a doubly linked list
        doublylink dll = new doublylink();

        // Add nodes to the list
        dll.insertlast(10);
        dll.insertlast(20);
        dll.insertlast(30);
        dll.insertlast(40);
        dll.insertlast(50);

        // Display the list
        System.out.println("List elements:");
        dll.displaynode();

        // Perform bidirectional search
        int target = 30;
        if (dll.bidirectional(target)) {
            System.out.println("Element " + target + " found in the list.");
        } else {
            System.out.println("Element " + target + " not found in the list.");
        }

        // Try searching for an element not in the list
        target = 60;
        if (dll.bidirectional(target)) {
            System.out.println("Element " + target + " found in the list.");
        } else {
            System.out.println("Element " + target + " not found in the list.");
        }
    }
}
