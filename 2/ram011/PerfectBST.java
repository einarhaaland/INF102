public class PerfectBST<Key extends Comparable<Key>, Value> extends BST<Key, Value>{
	
    private Key[] keys;
    private Value[] values;
    private Node root;
    
	PerfectBST(Key keys[], Value values[]){
		this.keys = keys;
		this.values = values;
	    this.root = constructTree(0, keys.length);
	}
	
	//Constructs the PerfectBST recursively
	private Node constructTree(int lo, int hi) {
	    if (hi <= lo) return null;
	    
	    int mid = lo + ((hi - lo) / 2);
	    Node n = new Node(keys[mid], values[mid], 1);
	    n.left = constructTree(lo, mid);
	    n.right = constructTree(mid + 1, hi);
	    return n;
	}
}
