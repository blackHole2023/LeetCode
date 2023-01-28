package mid;

public class No36 {
    public boolean isValidSudoku(char[][] board) {


        return true;
    }

    public static void main(String[] args) {
        String[][] board={
         {"5","3",".",".","7",".",".",".","."}
        ,{"6",".",".","1","9","5",".",".","."}
        ,{".","9","8",".",".",".",".","6","."}
        ,{"8",".",".",".","6",".",".",".","3"}
        ,{"4",".",".","8",".","3",".",".","1"}
        ,{"7",".",".",".","2",".",".",".","6"}
        ,{".","6",".",".",".",".","2","8","."}
        ,{".",".",".","4","1","9",".",".","5"}
        ,{".",".",".",".","8",".",".","7","9"}
        };

        char[][] board1 = new char[9][9];
        for (int i = 0; i <9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println(board[i][j]);
                board1[i][j]=board[i][j].charAt(0);
            }
        }
        System.out.println(board1);
        No36 no36 = new No36();
//        no36.isValidSudoku(board);

    }
}
