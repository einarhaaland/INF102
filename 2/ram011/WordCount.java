
public class WordCount{

	public static void main(String args[]) {
	    BST<String, Integer> bst = new BST<String, Integer>();
	    String input = StdIn.readLine();
	    String[] s = input.split(" ");
	    
	    //put in bst
	    for (String str : s) {
	        if (bst.contains(str)) bst.put(str, bst.get(str)+1);
	        else bst.put(str, 1);
	    }
	    //print out key + value
	    for (String str : bst.keys()) System.out.println(str + "\t" + bst.get(str));
	}
}
