/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

import java.util.Deque;

class queue {
    private String[] queueA;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public queue(int capacity) {
        this.capacity = capacity;
        queueA = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
        
    }
    
    public boolean isfull() {
        return size == capacity;
    }
    
    public boolean isempty() {
        return size == 0;
    }
    
    public void enqueue(String item) {
        if (isfull()) {
            System.out.println("Antrian penuh");
        } else {
            rear = (rear + 1) % capacity;
            queueA[rear] = item;
            size++;
            System.out.println("Ditambahkan ke antri = " + item);
                
            }
    }
    
    public String dequeue() {
        if (isempty()) {
            System.out.println("Antrian kosong");
            return null;
        }else {
            String item = queueA[front];
            front = (front + 1) % capacity;
            size--;
            return item;
        }
    }
    
    public void displayqueue() {
        if (isempty()) {
            System.out.println("Antrian kosong");
        } else {
            System.out.println("Isi antrian : ");
            for (int i = 0; i < size; i++) {
                System.out.print(queueA[(front + i) % capacity] + " ");
            }
            System.out.println();
        }
    }
    
}
        
public class Antri {
    public static void main(String[] args) {
        int kapasitas = 5;
        
        queue que = new queue(kapasitas);
        
        que.enqueue("adama");
        que.enqueue("madas");
        que.enqueue("dimas");
        que.enqueue("vase");
        que.enqueue("beso");
        que.enqueue("aska");
        
        que.displayqueue();
        
        while (!que.isempty()) {            
            String keluar = que.dequeue();
            System.out.println("Keluar dari antri: " + keluar);
            que.displayqueue();
        }
        System.out.println("Antrian kosong");
    }
}
