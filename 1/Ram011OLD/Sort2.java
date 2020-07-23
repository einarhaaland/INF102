public class Sort2 {
    //You need to implement this¨
    /**
     * Sorts comparable array using cocktail sort
     * @param a
     */
    public static void sort(Comparable[] a){
        int start = 0;
        int end = a.length-1;
        boolean didSwap = true;
        
        while(didSwap) {
            didSwap = false;
            for (int i = start; i < end; i++) {
                if (a[i].compareTo(a[i+1]) > 0) {
                   swap(a, i, i+1);
                   didSwap = true;
                }
            }
            end--; //decreases indexes to go through because previous a[end] is in correct spot
            
            if (!didSwap) break; //is sorted
            for (int i = end; i > start; i--) {
                if (a[i].compareTo(a[i-1]) < 0) {
                   swap(a, i, i-1);
                   didSwap = true;
                }
            }
            start++; //decreases indexes to go through because previos a[start] is in correct spot
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
