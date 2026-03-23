import java.util.*;
public class ticTacToe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[][] board=new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=' ';
            }
        }
        char player='X';
        while (true) {
            printboard(board);
            System.out.println();
            System.out.println("----------------------------------");
            System.out.println();
            int r=sc.nextInt();
            int c=sc.nextInt();
            if(board[r][c]==' '){
                board[r][c]=player;
                boolean win=win(board,player);
                if(win){
                    printboard(board);
                    System.out.println("Player "+player+" wins!");
                    break;
                }else if(boardfull(board)){
                    printboard(board);
                    System.out.println("It's a draw!");
                    break;
                }

                if(player=='X') player='O';
                else player='X';
            }else{
                System.out.println("Invalid move, try again.");
                continue;
            }
        }
    }
    public static boolean boardfull(char[][] board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==' ') return false;
            }
        }
        return true;
    }
    public static boolean win(char[][] board,char player){
        for(int i=0;i<3;i++){
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player) return true;
            if(board[0][i]==player && board[1][i]==player && board[2][i]==player) return true;
        }
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player) return true;
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player) return true;
        return false;
    }
    public static void printboard(char[][] board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]);
                if(j<2) System.out.print(" | ");
            }
            System.out.println();

        }
    }
}

