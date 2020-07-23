public class MedianPQClient{
	
	/* Program which reads numbers from stdin and for each number read, prints out the median of all numbers read so far
	/	
	*/ 
	public static void main(String args[]){
		MedianPQ pq = new MedianPQ();

		//Read until end of file, You can press ctrl+d to signal end of file in a terminal (linux, mac), or ctrl+z (windows)
		while (!StdIn.isEmpty()){
			pq.insert(StdIn.readDouble());  // Insert the next read number into pq
			StdOut.printf("Median = %.1f\n", pq.findMedian()); // Print the median of all numbers read so far (with 1 decimal)
		}
	}
}
