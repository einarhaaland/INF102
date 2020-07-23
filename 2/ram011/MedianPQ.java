public class MedianPQ {

    MinPQ<Double> minOfLargestPQ; //PQ of largest numbers prioritizing min
    MaxPQ<Double> maxOfSmallestPQ; //PQ of smallest numbers prioritizing max
    
	MedianPQ(){
	    this.minOfLargestPQ = new MinPQ<Double>();
	    this.maxOfSmallestPQ = new MaxPQ<Double>();
	}

	public void insert(Double a){
	    if (minOfLargestPQ.isEmpty() || a > minOfLargestPQ.min()) minOfLargestPQ.insert(a);
	    else maxOfSmallestPQ.insert(a);
	    rebalance();
	}

	public double findMedian(){
	    if (minOfLargestPQ.size() == maxOfSmallestPQ.size()) return (maxOfSmallestPQ.max() + minOfLargestPQ.min()) / 2.0;
	    if (minOfLargestPQ.size() > maxOfSmallestPQ.size()) return minOfLargestPQ.min();
	    else return maxOfSmallestPQ.max();
	}
	
	/**
	 * rebalances minPQ and maxPQ if neccesary
	 */
	private void rebalance() {
	    if (Math.abs(minOfLargestPQ.size() - maxOfSmallestPQ.size()) < 2) return; //no need to rebalance
	    
	    //rebalance
	    if (minOfLargestPQ.size() > maxOfSmallestPQ.size()) maxOfSmallestPQ.insert(minOfLargestPQ.delMin());
	    else minOfLargestPQ.insert(maxOfSmallestPQ.delMax());
	}
}
