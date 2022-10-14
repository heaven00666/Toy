package Oct.BlockGame;

/**
 * @author hs
 * @version 1.0
 * Create by 2022/10/14 10:50
 */

public class Main {
    public static void main(String[] args) {
        boolean[][] b = new boolean[4][4];
        System.out.println(is_full(b,1));
        System.out.println(lock_dot(b,new int[]{1,2}));
    }
    public static boolean is_full(boolean[][] board,int row){
        for (int i = 0;i < board[row].length;i++){
            if(board[row][i] == false){
                return false;
            }
        }
        return true;
    }
    public static boolean lock_dot(boolean[][] board,int[] pos){
        if(board[pos[0]][pos[1]] == false){
            return false;
        }
        return true;
    }
}
