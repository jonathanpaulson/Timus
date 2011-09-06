import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P69 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> code = new ArrayList<Integer>();
        while(in.hasNextInt())
            code.add(in.nextInt()-1);
        code.remove(code.size()-1);
        
        int n = code.size();
        int[] deg = new int[n+2];
        for(int i=0; i<n+2; i++) deg[i]=1;
        for(Integer i:code) deg[i]++;
        
        List<Integer>[] edges = new List[n+2];
        for(int i=0; i<n+2; i++)
            edges[i] = new ArrayList<Integer>();

        for(Integer i:code) {
            for(int j=0; j<n+2; j++)
                if(deg[j]==1) {
                    edges[j].add(i);
                    edges[i].add(j);
                    deg[j]--;
                    deg[i]--;
                    break;
                }
        }
        int v1=-1;
        int v2=-1;
        for(int j=0; j<n+2; j++)
            if(deg[j]>0) {
                if(v1==-1) v1=j;    
                else v2=j;
            }
        edges[v1].add(v2);
        edges[v2].add(v1);
        for(int i=0; i<edges.length; i++) {
            System.out.print( (i+1)+":");
            Collections.sort(edges[i]);
            for(Integer j:edges[i])
                System.out.print(" "+(j+1));
            System.out.println();
        }
    }
}
