import java.util.*;
import java.awt.Point;
import java.math.*;

public class P208 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[][] edges = new boolean[n][n];
        String[][] team = new String[n][3];
        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                team[i][j] = in.next();
                for(int k=0; k<i; k++) {
                    for(int l=0; l<3; l++) {
                        if(team[k][l].equals(team[i][j])) {
                            edges[i][k] = true;
                            edges[k][i] = true;
                        }
                    }
                }
            }
        }
        int max = 0;
        int lim = (int)Math.pow(2,n);
        OUTER: for(int A=0; A<lim; A++) {
            List<Integer> set = new ArrayList<Integer>();
            int scratch = A;
            int index = 0;
            while(scratch > 0) {
                if(scratch%2==1)
                    set.add(index);
                scratch/=2;
                index++;
            }
            for(int i=0; i<set.size(); i++)
                for(int j=0; j<i; j++)
                    if(edges[set.get(i)][set.get(j)])
                        continue OUTER;
            max = Math.max(max,set.size());
        }
        System.out.println(max);
    }
}
