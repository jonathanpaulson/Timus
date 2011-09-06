import java.util.*;
import java.awt.Point;
import java.math.*;

public class P377 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int top = 2;
        int left = 1;
        int bot = in.nextInt();
        int right = in.nextInt();

        int y1 = in.nextInt();
        int x1 = in.nextInt();
        int y2 = in.nextInt();
        int x2 = in.nextInt();

        int x = 1;
        int y = 1;
        int dir = 0; //Right,Down,Left,Up
        int count = 0;
        boolean flag = false;
        while(true) {
            if(flag) count++;
            if((x==x1 && y==y1) || (x==x2 && y==y2)) {
                if(flag) { System.out.println(count); return; }
                else flag = true;
            }
            switch(dir) {
                case 0:
                    if(x==right) { y++; right--; dir=1; }
                    else x++;
                    break;
                case 1:
                    if(y==bot) { x--; bot--; dir=2; }
                    else y++;
                    break;
                case 2:
                    if(x==left) { left++; y--; dir=3; }
                    else x--;
                    break;
                case 3:
                    if(y==top) { top++; x++; dir=0; }
                    else y--;
                    break;
            }
        }
    }
}

