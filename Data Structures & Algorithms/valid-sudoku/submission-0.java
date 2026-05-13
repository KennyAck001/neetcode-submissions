class Solution {

    public boolean isValidSudoku(char[][] board) {

        for(int row = 0; row < 9; row++){

            for(int col = 0; col < 9; col++){

                if(board[row][col] != '.'){

                    char num = board[row][col];

                    // temporarily remove current number
                    board[row][col] = '.';

                    if(!isSafe(board, row, col, num)){
                        return false;
                    }

                    // restore
                    board[row][col] = num;
                }
            }
        }

        return true;
    }

    public static boolean isSafe(char [][] board, int r, int c, char num) {

        // row check
        for(int i = 0; i < board.length; i++){
            if(board[r][i] == num){
                return false;
            }
        }

        // column check
        for(int i = 0; i < board.length; i++){
            if(board[i][c] == num){
                return false;
            }
        }

        // 3x3 box check
        int sqrt = (int)Math.sqrt(board.length);

        int rowStart = r - r % sqrt;
        int colStart = c - c % sqrt;

        for(int i = rowStart; i < rowStart + sqrt; i++){

            for(int j = colStart; j < colStart + sqrt; j++){

                if(board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }
}