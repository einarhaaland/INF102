import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;

public class UFwithDeunion {
    
    static int[] id;
    static int[] sz;
    static Stack<Integer> lastUnion;
    
    //You need to implement this
    public static int setSize(int n){
        id = new int[n];
        sz = new int[n];
        lastUnion = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            id[i] = i; // every node is their own parent
            sz[i] = 1; // every node is of size 1
        }
        return 0;//this method should really return void, but lecturer said to just return a random number
    }

    //You need to implement this
    public static int find(int a){
        while (a != id[a]) a = id[a]; //finds root pointing to itself
        return a;
    }

    //You need to implement this
    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        //already connected
        if (rootA == rootB) return;
        
        //merge smaller component into larger and add size
        if (sz[rootA] > sz[rootB]) {
            sz[rootA] += sz[rootB];
            id[rootB] = rootA;
        }
        else {
            sz[rootB] += sz[rootA];
            id[rootA] = rootB;
        }
        lastUnion.push(rootA);
        lastUnion.push(rootB);
    }

    //You need to implement this
    public static void deUnion(){
        if (lastUnion.isEmpty())
            throw new EmptyStackException();
        
        //last two roots involved in a union operation
        int root1 = lastUnion.pop();
        int root2 = lastUnion.pop();
        
        //deUnion and decrease size of largest component
        if (sz[root1] < sz[root2]) {
            sz[root2] -= sz[root1];
            id[root1] = root1;
        }
        else {
            sz[root1] -= sz[root2];
            id[root2] = root2;
        }
    }
    

    //You need to implement this
    public static int elementsInSet(int a){
        return sz[find(a)]; //size of root of int a
    }

    //You can use this for testing, we will not grade it
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        setSize(n);
        
        while(sc.hasNext()) {
            int a = sc.nextInt();
            if (a >= 0) {
                int b = sc.nextInt();
                union(a,b);
            }
            else {
                deUnion();
            }
            if (sc.hasNext("stop")) break;
        }
        //print
        for (int i = 0; i < id.length; i++) {
            for (int j = 0; j < id.length; j++) {
                if (find(id[j]) == i) {
                    System.out.print(j);
                }
            }
            System.out.println(); //will give extra linebreaks
        }
    }
}
