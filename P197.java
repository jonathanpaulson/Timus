import java.util.*;

public class P197 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        for(int trial=0; trial<n; trial++) {
            String line = in.nextLine();
            int x = line.charAt(0)-'a'+1;
            int y = line.charAt(1)-'0';
            int count = 0;
            if(good(x+2,y+1)) count++;
            if(good(x+2,y-1)) count++;
            if(good(x-2,y+1)) count++;
            if(good(x-2,y-1)) count++;
            if(good(x+1,y+2)) count++;
            if(good(x+1,y-2)) count++;
            if(good(x-1,y+2)) count++;
            if(good(x-1,y-2)) count++;
            System.out.println(count);
        }
    }
    public static boolean good(int x,int y) {
        return 1<=x && x<=8 && 1<=y && y<=8;
    }
}
