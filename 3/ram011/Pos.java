public class Pos implements Comparable<Pos>{
	public int x, y;
	//added field parent which can be initialized and set to find way back to start easily
	public Pos parent;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int compareTo(Pos p){
		return (this.x != p.x ? this.x - p.x : this.y - p.y);
	}
}
