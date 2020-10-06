import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int[][] grid = new int[9][9];
		ArrayList<Pair> emptySpots = new ArrayList<Pair>();

		
		for(int i = 0; i < 81; i++) {
			int r = i/9;
			int c = i%9;
			//System.out.println("row : " + r + "\ncol : " + c);
			grid[r][c] = in.nextInt();
			check(grid[r][c], r, c, emptySpots);
			
			
			 /*if(i < 9) {
				 grid[0][i] = in.nextInt();
				 check(grid[0][i], 0, i, emptySpots);

			 }
			 else if (i < 18){
				 grid[1][i - 9] = in.nextInt();
				 check(grid[1][i-9], 1, i-9, emptySpots);
			 }
			 else if(i < 27) {
				 grid[2][i - 18] = in.nextInt();
				 check(grid[2][i - 18], 2, i-18, emptySpots);

			 }
			 else if(i < 36) {
				 grid[3][i - 27] = in.nextInt();
				 check(grid[3][i-27], 3, i-27, emptySpots);

			 }
			 else if(i < 45) {
				 grid[4][i - 36] = in.nextInt();
				 check(grid[4][i-36], 4, i-36, emptySpots);

			 }
			 else if(i < 54) {
				 grid[5][i - 45] = in.nextInt();
				 check(grid[5][i-45], 5, i-45, emptySpots);

			 }
			 else if(i < 63) {
				 grid[6][i - 54] = in.nextInt();
				 check(grid[6][i-54], 6, i-54, emptySpots);

			 }
			 else if(i < 72) {
				 grid[7][i - 63] = in.nextInt();
				 check(grid[7][i-63], 7, i-63, emptySpots);

			 }
			 else {
				 grid[8][i - 72] = in.nextInt();
				 check(grid[8][i-72], 8, i-72, emptySpots);

			 }*/
		}
		
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.print("\n");
		}
		
		for(int i = 0; i < emptySpots.size(); i++) {
			emptySpots.get(i).printPair();
		}
		
	}
	
	public static void check(int n, int r , int c, ArrayList<Pair> empties) {
		if(n == 0) {
			//System.out.println("adding to empty (" + r + " , " + c + ")");
			Pair p = new Pair(r,c);
			//p.printPair();
			empties.add(p);
		}
	}
	
	public static boolean backtracking(int[][] grid, ArrayList<Pair> empty) {
		return false;
	}
	
	public static boolean validNumLS(int[][] grid , Pair p , int num) {
		
		for(int i = 0; i < 9; i ++) {
			if(grid[p.r][i] == num) {
				return false;
			}
			if(grid[i][p.c] == num) {
				return false;
			}			
		}
		
		int blockStartRow = p.r - p.r % 3;
		int blockStartCol = p.c - p.c % 3;
		for(int r = blockStartRow; r < blockStartRow + 3; r++) {
			for(int c = blockStartCol; c < blockStartCol + 3; c++) {
				if(grid[r][c] == num) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	

}
