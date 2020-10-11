import java.util.ArrayList;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) {

        // TODO Auto-generated method stub

        Scanner in = new Scanner(System.in);
        int[][] grid = new int[9][9];
        //ArrayList<Pair> emptySpots = new ArrayList<Pair>();

        for(int i = 0; i < 81; i++) {
            int r = i/9;
            int c = i%9;
            //System.out.println("row : " + r + "\ncol : " + c);
            grid[r][c] = in.nextInt();

        }

        if(backtracking(grid) == true) {
            print(grid);
        }else {
            System.out.println("No solution");
        }

    }

    public static void print(int[][] grid) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static boolean check(int n, int row , int col, int[][] grid) {
        //First check if the number that the backtracking function wants to add is not already in the same row and column
        //Then check if its not in the square block
        //if its all ok return true

        for(int i = 0; i < 9; ++i) {
            if(grid[row][i] == n || grid[i][col] == n) {
                return false;
            }
        }

        int SquareRow = row - row % 3;
        int SquareCol = col - col % 3;

        for(int r = SquareRow; r < SquareRow +3; ++r) {
            for(int c = SquareCol; c < SquareCol +3; ++c) {
                if(grid[r][c] == n) {
                    return false;
                }
            }
        }
        return true;


    }

    public static boolean backtracking(int[][] grid) {
        boolean isComplete = true;
        int row = -1;
        int col = -1;
        int r;
        int c;

        //check for 0's
        for(int i = 0; i < 81; i++){
            r = i/9;
            c = i%9;
            if(grid[r][c] == 0){
                row = r;
                col = c;
                isComplete = false;
                break;
            }
        }

        //no 0's left
        if(isComplete == true){
            return true;
        }

        //check for valid number between 1 and 9
        for(int j = 1 ; j < 10 ; ++j){
            if(check(j,row,col,grid)){
                grid[row][col] = j;
                if(backtracking(grid)){
                    return true;
                }else{
                    //reset grid at (row,col) and try next number
                    grid[row][col] = 0;
                }
            }
        }
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
