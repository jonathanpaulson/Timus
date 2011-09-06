import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P804 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        for(int i=0; i<n; i++) {
            String[] arr = in.nextLine().split(" ");

            boolean home = arr[3].equals("home");
            int my_home = 0;
            int their_home = 0;
            int my_away = 0;
            int their_away = 0;
            if(home) { 
                my_home = Integer.parseInt(arr[6]);
                their_away = Integer.parseInt(arr[10]);
                int lo = 0;
                for(lo=0; lo<=30; lo++)
                    if(can_win(my_home, 0, lo, their_away))
                        break;

                int hi=0;
                for(hi=30; hi>=0; hi--)
                    if(can_win(30,my_home,their_away,hi))
                        break;
                System.out.println(lo+" "+hi);
            }
            else {
                my_away = Integer.parseInt(arr[6]);
                their_home = Integer.parseInt(arr[10]);
                int lo = 0;
                for(lo=0; lo<=30; lo++)
                    if(can_win(lo, their_home, my_away, 0))
                        break;

                int hi=0;
                for(hi=30; hi>=0; hi--)
                    if(can_win(their_home,hi,30,my_away))
                        break;
                System.out.println(lo+" "+hi);
            }
        }
    }
    public static boolean can_win(int my_home, int their_home, int my_away, int their_away)
    {
        if(my_home+my_away > their_home + their_away) return true;
        if(my_home+my_away < their_home + their_away) return false;
        if(my_away >= their_away) return true;
        return false;
    }
}
