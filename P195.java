import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P195 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] board = new char[3][3];
        for(int i=0; i<3; i++) {
            String line = in.nextLine();
            for(int j=0; j<3; j++)
                board[i][j] = line.charAt(j);
        }
        int ans = calc(board,true);
        if(ans == 1) System.out.println("Crosses win");
        if(ans == -1) System.out.println("Ouths win");
        if(ans == 0) System.out.println("Draw");
    }
    public static int calc(char[][] board,boolean X) {
        String s = "XO";
        int i = X?1:0;
        if(board[0][0]==s.charAt(i) && board[0][1] == s.charAt(i) && board[0][2]==s.charAt(i)) return -1;
        if(board[1][0]==s.charAt(i) && board[1][1] == s.charAt(i) && board[1][2]==s.charAt(i)) return -1;
        if(board[2][0]==s.charAt(i) && board[2][1] == s.charAt(i) && board[2][2]==s.charAt(i)) return -1;

        if(board[0][0]==s.charAt(i) && board[1][0] == s.charAt(i) && board[2][0]==s.charAt(i)) return -1;
        if(board[0][1]==s.charAt(i) && board[1][1] == s.charAt(i) && board[2][1]==s.charAt(i)) return -1;
        if(board[0][2]==s.charAt(i) && board[1][2] == s.charAt(i) && board[2][2]==s.charAt(i)) return -1;

        if(board[0][0]==s.charAt(i) && board[1][1] == s.charAt(i) && board[2][2]==s.charAt(i)) return -1;
        if(board[0][2]==s.charAt(i) && board[1][1] == s.charAt(i) && board[2][0]==s.charAt(i)) return -1;

        int best = -1;
        boolean done=true;
        for(i=0; i<3; i++)
            for(int j=0; j<3; j++) {
                if(board[i][j]=='#') {
                    done=false;
                    board[i][j]=X?'X':'O';
                    best = max(best,-calc(board,!X));
                    board[i][j]='#';
                }
            }
        if(done) return 0;
        return best;
    }
}
