package strukdat;

public class quicknim {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); 

            quickSort(arr, low, pi - 1); 
            quickSort(arr, pi + 1, high); 
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            
            if (arr[j] < pivot) {
                i++;
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

       
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; 
    }

    public static void main(String[] args) {
        int[] nim = {2,3,0,6,0,5,1,1,0,0,5,3}; 
        System.out.println("NIM sebelum diurutkan:");
        for (int i : nim) {
            System.out.print(i + " ");
        }

        quickSort(nim, 0, nim.length - 1);

        System.out.println("\nNIM setelah diurutkan (Quick Sort):");
        for (int i : nim) {
            System.out.print(i + " ");
        }
    }
}
