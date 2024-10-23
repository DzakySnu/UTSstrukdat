/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strukdat;

/**
 *
 * @author dzaky
 */
class mahasiswa {
    private long nim;
    private String nama;
    private String asal;
    
    public mahasiswa(long nim, String nama, String asal) {
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
    }
    
    public void displaymhs() {
       System.out.println("Nim: " + nim + ", Nama: " + nama + ", Asal: " + asal);
    }
    
    public long getnim() {
        return nim;
    }
    
    public String getnama() {
        return nama;
    }
}

public class dataarray {
    
    private mahasiswa[] mhs;
    private int nelement;
    
    public dataarray(int max) {
        mhs = new mahasiswa[max];
        nelement = 0;
    }
    
    public mahasiswa find(long searchnim) {
        int i;
        for ( i = 0; i < nelement; i++) {
            if (mhs[i].getnim()==searchnim) {
                break;
            }
        }
        if (i == nelement) {
            return null;
        } else {
            return mhs[i];
        }
    }
    
    public void insert(long nim, String nama, String asal) {
        mhs[nelement] = new mahasiswa(nim, nama, asal);
        nelement++;
    }
    
    public boolean delete(long searhcnim) {
        int i;
        for ( i = 0; i < nelement; i++) {
            if (mhs[i].getnim()==searhcnim) {
                break;
            }
        }
        
        if (i==nelement) {
            return false;
        } else {
            for (int j = i; j < nelement; j++) {
                mhs[j] = mhs[j+1];
            }
            nelement--;
            return true;
        }
    }
    
    public void displayarray() {
        for (int i = 0; i < nelement; i++) {
            mhs[i].displaymhs();
        }
        System.out.println("");
    }
    
    
    public void bubblesort() {
        for (int i = nelement-1; i < 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (mhs[j].getnim() > mhs[j+1].getnim()) {
                    swap(j,j+1);
                }
            }
        }
    }
    
    public void insertionsort() {
        for (int i = 1; i < nelement; i++) {
            mahasiswa temp = mhs[i];
            int j = i;
            while (j > 0 && mhs[j-1].getnim() > temp.getnim()) {                
                mhs[j] = mhs[j - 1];
                j--;
            }
            mhs[j] = temp;
        }
    }
    
    
    public void selectionbyname() {
        for (int i = 0; i < nelement-1; i++) {
            int mininx = i;
            for (int j = i+1; j < nelement; j++) {
                if (mhs[j].getnama().compareTo(mhs[mininx].getnama()) < 0) {
                    mininx = j;
                }
            }
            swap(i, mininx);
        }
    }
    
    
    
    private void swap(int one,int two){
        mahasiswa temp = mhs[one];
        mhs[one] = mhs[two];
        mhs[two] = temp;
}
    
    
}

class dataarrayapp {
    
    public static void main(String[] args) {
        int maxsize = 100;
        dataarray arr;
        arr = new dataarray(maxsize);
        
        arr.insert(16650290,"jundi","malang");
        arr.insert(16650210,"ahmad","sidoarjo");
        arr.insert(16650220,"ismail","banyuwangi");
        arr.insert(16650230,"sofi","semarang");
        arr.insert(16650265,"dinda","bandung");
        arr.insert(16650250,"rais","ambon");
        arr.insert(16650240,"helmi","madura");
        arr.insert(16650200,"agung","madiun"); 
        arr.insert(16650280,"arina","malang"); 
        
        //sebelum
        arr.displayarray();
        
        
        //bubble
        System.out.println("bublesort : ");
        arr.bubblesort();
        arr.displayarray();
        
        //insertionsort
        arr.insert(16650245, "mamat", "jabon");
        arr.insert(16650270, "meimei", "magetan");
        System.out.println("insertionsort : ");
        arr.insertionsort();
        arr.displayarray();
        
        //selectionsortbyname
        arr.selectionbyname();
        System.out.println("selction sort byname : ");
        arr.displayarray();
        
        //searching
        long searchkey = 16650290;
        mahasiswa mhs = arr.find(searchkey);
        if (mhs != null) {
            System.out.println("\nKetemu");
            mhs.displaymhs();
        } else {
            System.out.println("gaketemu " + searchkey);
        }
        
        // deleting
        searchkey = 16650240;
        System.out.println("\nHapus nim: " + searchkey);
        arr.delete(searchkey);
        
        arr.displayarray();
    }
}






