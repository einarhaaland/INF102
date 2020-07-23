/**
 * Created by Olav on 15.09.19.
 */
public class Sort1 {
    //You need to implement this
    /**
     * Sorts array of type extends(or is) Comparable using bubblesort
     * @param a array to be sorted
     */
    public static void sort(Comparable[] a){
        boolean didSwap = true;
        int end = a.length-1;
        
        while(didSwap) {
            didSwap = false;
            for (int i = 0; i < end; i++) {
                if (a[i].compareTo(a[i+1]) > 0) {
                   swap(a, i, i+1);
                   didSwap = true;
                }
            }
            end--; //move end back because a[previous end] is in correct spot
        }
    }
    
    /**
     * Swaps values at two given indexes at given array
     * @param array array to swap values in
     * @param a index to swap
     * @param b index to swap
     */
    private static void swap(Comparable[] array, int a, int b) {
        Comparable temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //You can use this for testing, we will not grade it
    public static void main(String args[]) throws Exception{
        Integer[] a = {2,3,4,5,1};
        sort(a);
        for(int i=0; i<a.length;i++)System.out.println(a[i]);
    }
}
