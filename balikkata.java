
package strukdat;
        
import java.util.Scanner;

class stack {
    private char[] stackA;
    private int top;
    
    public stack (int size) {
        stackA = new char[size];
        top = -1;
    }
    
    public void push (char c) {
        if (top < stackA.length - 1) {
                stackA[++top] = c;
            } else {
            System.out.println("Penuh");
        }
    }
    
    public char pop() {
        if (top >= 0) {
            return stackA[top--];
        } else {
            System.out.println("Kosong");
            return '\0';
        }
    }
    
    public boolean isempty() {
        return top == -1;
    }
}

class pembalik {
    private stack stack;
    
    public pembalik(String I) {
        stack = new stack(I.length());
        for (int i = 0; i < I.length(); i++) {
            stack.push(I.charAt(i));
        }
    }
    
    public String balikan() {
        StringBuilder output = new StringBuilder();
        while (!stack.isempty()) {            
            output.append(stack.pop());
        }
        return output.toString();
    }
}


        
public class balikkata {
    public static void main(String[] args) {
        String Input1 = "Kasur";
        pembalik pmblk1 = new pembalik(Input1);
        System.out.println("Awal = " + Input1);
        String Output1 = pmblk1.balikan();
        System.out.println("Akhir = " + Output1);
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan Kata : ");
        String Input = scan.nextLine();
        
        pembalik pmblk = new pembalik(Input);
        String output = pmblk.balikan();
         
        System.out.println("hasil : " + output);
        
    }
}
