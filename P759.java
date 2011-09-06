import java.util.*;

public class P759 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        long max = 0;
        int max_i = -1;
        for(int i=1; i<=n; i++) {
            String[] arr = in.nextLine().split(" ");
            if(dist(arr[0],arr[2]) > max) {
                max = dist(arr[0],arr[2]);
                max_i = i;
            }
        }
        System.out.println(max_i);
    }
    public static long dist(String s1, String s2) {
        Date d1 = new GregorianCalendar(Integer.parseInt(s1.substring(6,6+4))-1500,Integer.parseInt(s1.substring(3,3+2))-1,Integer.parseInt(s1.substring(0,0+2))
                ,0,0).getTime();
        Date d2 = new GregorianCalendar(Integer.parseInt(s2.substring(6,6+4))-1500,Integer.parseInt(s2.substring(3,3+2))-1,Integer.parseInt(s2.substring(0,0+2))
                ,0,0).getTime();
        return (d2.getTime()-d1.getTime())/(1000*60*60*24);
    }
}

