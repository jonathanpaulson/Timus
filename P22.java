import java.util.*;

public class P22 {
    static List<Integer> ans;
    static List<Integer>[] edges;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        edges = new ArrayList[n+1];
        ans = new ArrayList<Integer>(n+1);
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++)
            edges[i] = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
            while(true) {
                int k = in.nextInt();
                if(k==0) break;
                edges[k].add(i);
            }
        }

        for(int i=1; i<=n; i++)
            dfs(i);
        for(int i=0; i<n; i++)
            System.out.print(ans.get(i)+(i==n-1?"":" ")); 
        System.out.println();
    }
    public static void dfs(int n) {
        if(visited[n]) return;
        visited[n] = true;
        for(Integer i: edges[n])
            dfs(i);
        ans.add(n);
    }
}
