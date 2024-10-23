package strukdat;

class ShellSortExample {
    private char[] arr;
    private int nElemen;

    // Constructor untuk inisialisasi array
    public ShellSortExample(char[] array) {
        this.arr = array;
        this.nElemen = array.length;
    }

    // Fungsi untuk menampilkan isi array
    public void display() {
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Fungsi Shell Sort
    public void shellSort() {
        int in, out;
        int temp;
        int h = 1;

        // Hitung nilai h menggunakan persamaan Knuth: h = 3 * h + 1
        while (h <= nElemen / 3) {
            h = 3 * h + 1;  // Menentukan gap terbesar sesuai dengan ukuran array
        }

        // Lakukan sorting dengan gap h
        while (h > 0) {
            for (out = h; out < nElemen; out++) {
                temp = arr[out];
                in = out;

                // Lakukan pergeseran jika elemen di kiri lebih besar
                while (in >= h && arr[in - h] > temp) {
                    arr[in] = arr[in - h];
                    in -= h;
                }
                arr[in] = (char) temp;

                // Tampilkan array setelah setiap penyisipan elemen
                display();
            }

            // Kurangi gap menggunakan rumus kebalikan Knuth: h = (h - 1) / 3
            h = (h - 1) / 3;
        }
    }
}

public class shelnama {
    public static void main(String[] args) {
        String nama = "Moch. Dzaky Sunnii Kautsar";
        char[] array = nama.toCharArray();
        
        ShellSortExample sorter = new ShellSortExample(array);
        System.out.println("Array sebelum diurutkan:");
        sorter.display();
        
        // Lakukan pengurutan menggunakan shell sort
        sorter.shellSort();
        
        System.out.println("Array setelah diurutkan:");
        sorter.display();
    }
}