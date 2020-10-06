
public class Pair {
	
	int r, c;
	
	Pair(int row , int col){
		r = row;
		c = col;
	}
	
	Pair(){
		r = -1;
		c = -1;
	}
	
	public void printPair() {
		System.out.println("(" + r + ',' + c + ")");
	}
	
	public void change(int row, int col) {
		r = row;
		c = col;
	}

}
