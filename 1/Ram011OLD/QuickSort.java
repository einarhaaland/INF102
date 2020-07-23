import java.util.Random;

public class QuickSort {
    //cutoffs, you should run experiments to find good values
    public static int a;
    public static int b;
    public static int c;

    public static void sort(int[] array){
        shuffle(array);
        sort(array,0,array.length-1);
    }

    //You need to implement this
    private static void shuffle(int[] a){
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            swap(a, i, random.nextInt(a.length));
        }
    }

    //You need to implement this
    private static int partitionByMedianOf3(int[] array, int lo, int hi){
        int mid = (lo + hi) / 2;
        
        if(array[lo] > array[mid])
            swap(array, lo,mid);
         
        if(array[lo] > array[hi])
            swap(array, lo, hi);
         
        if(array[mid] > array[hi])
            swap(array, mid, hi);
         
        swap(array, mid, lo); //put pivot in array[lo] so that partition() gets right pivot
        return partition(array, lo, hi);
        
    }

    //You need to implement this
    private static int partitionByMedianOf9(int[] array, int lo, int hi){
        int mid = (lo + hi) / 2;
        insertionSort(array, mid-4, mid+4);
        swap(array, mid, lo); //put pivot in array[lo] so that partition() gets right pivot
        return partition(array, lo, hi);
    }

    //You need to implement this
    public static void insertionSort(int[] array, int lo, int hi){
        for (int i = lo + 1; i <= hi; i++) {
            int temp = array[i];
            int j = i-1;
            while(j >= lo && array[j] > temp) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }

    //partion by the first element
    private static int partition(int[] array, int lo, int hi){
        int pivot = array[lo], i = lo, j = hi+1;
        while (true){
            while (array[++i] < pivot) if (i == hi) break;
            while (array[--j] > pivot) if (j == lo) break;
            if (i >= j) break;
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        array[lo] = array[j];
        array[j] = pivot;
        return j;
    }

    //You should modify this to use the various cutoffs
    private static void sort(int[] array, int lo, int hi){
        if (hi <= lo) return; //maybe delete?
        int j;
        int n = hi-lo+1; //amount of elements in current subarray
        
        if ( n < a) {
            insertionSort(array, lo, hi);
            return;
        }
        //partition the current subarray
        else if (n >= a && n < b) j = partition(array, lo, hi);
        else if (n >= b && n < c) j = partitionByMedianOf3(array, lo, hi);
        else j = partitionByMedianOf9(array, lo, hi);

        //recursively sort the left and right subarray
        sort(array, lo, j-1);
        sort(array, j+1, hi);
    }
    
    /**
     * swaps given indexes at given array
     * @param array to swap in
     * @param a index to swap
     * @param b index to swap
     */
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //You can use this for testing, we will not grade it
    public static void main(String args[]) throws Exception{
        int[] a = new int[1000000];
        Utilities util = new Utilities();
        QuickSort qs = new QuickSort();
        double time = 0;
        qs.a = 50;
        qs.b = 1000;
        qs.c = 200000;
        for (int i = 0; i < a.length; i++) a[i] = util.nextRandomInt();
        for (qs.c = 10000; qs.c <= 500000; qs.c += 10000) { //changes values for cutoff
            time = 0;
            for (int i = 0; i < 10; i++) { //10 runs per cutoff value
                util.startTimer();
                qs.sort(a);
                time += util.checkTimer();
            }
            time /= 10.0;
            System.out.println(qs.c + " " + time);
        }
    }
}