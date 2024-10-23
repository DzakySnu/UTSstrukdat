package strukdat;

class array {
    private int arr[];
    private int nelemen;
    
    public array (int size) {
        arr = new int[size];
        nelemen = 0;
    }
    
    public void insert (int value) {
        arr[nelemen] = value;
        nelemen++;
    }
    
    public void display() {
        for (int i = 0; i < nelemen; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    
    public void mergesort() {
        int[] workspace = new int[nelemen];
        recmergesort(workspace, 0, nelemen - 1);
    }
    
    public void recmergesort (int[] workspace, int lowerbound, int upperbound) {
        if (lowerbound == upperbound) {
            return;
        } else {
            int mid = (lowerbound + upperbound) / 2;
            recmergesort(workspace, lowerbound, mid);
            recmergesort(workspace, mid + 1, upperbound);
            merge(workspace, lowerbound, mid + 1, upperbound);
        }
    }
    
    public void merge(int[] workspace, int lowindex, int highindex, int upperbound) {
        int j = 0;
        int lowerbound = lowindex;
        int mid = highindex - 1;
        int nitem = upperbound - lowerbound + 1;
        
        // Proses penggabungan elemen
        while (lowindex <= mid && highindex <= upperbound) {
            if (arr[lowindex] < arr[highindex]) {
                workspace[j++] = arr[lowindex++];
            } else {
                workspace[j++] = arr[highindex++];
            }
        }
        
        // Jika masih ada elemen di bagian kiri
        while (lowindex <= mid) {
            workspace[j++] = arr[lowindex++];
        }

        // Jika masih ada elemen di bagian kanan
        while (highindex <= upperbound) {
            workspace[j++] = arr[highindex++];
        }

        // Salin kembali elemen dari workspace ke array asli
        for (j = 0; j < nitem; j++) {
            arr[lowerbound + j] = workspace[j];
        }
    }
}

public class mergeso {
    public static void main(String[] args) {
        array myArray = new array(10);  // Membuat array dengan kapasitas 10

        // Memasukkan 10 item yang tidak terurut
        myArray.insert(50);
        myArray.insert(23);
        myArray.insert(9);
        myArray.insert(18);
        myArray.insert(61);
        myArray.insert(32);
        myArray.insert(40);
        myArray.insert(27);
        myArray.insert(15);
        myArray.insert(5);

        // Menampilkan data sebelum diurutkan
        System.out.println("Array sebelum diurutkan:");
        myArray.display();

        // Mengurutkan array menggunakan mergeSort
        myArray.mergesort();

        // Menampilkan data setelah diurutkan
        System.out.println("Array setelah diurutkan:");
        myArray.display();
    }
}
