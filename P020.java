import java.util.*;

public class P20 {
    static double[][] pts;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double r = in.nextDouble();
        pts = new double[n][2];
        for(int i=0; i<n; i++)
            for(int j=0; j<2; j++)
                pts[i][j] = in.nextDouble();
        double ans = 0;
        for(int i=0; i<n-1; i++)
            ans+=dist(i,i+1);
        ans+=dist(n-1,0);
        ans+=2*Math.PI*r;
        System.out.printf("%.2f\n",ans);
    }
    public static double dist(int i,int j) {
        return Math.sqrt(Math.pow(pts[i][0]-pts[j][0],2)+Math.pow(pts[i][1]-pts[j][1],2));
    }
}
