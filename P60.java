import java.util.*;

public class P60 {
    static Set<Integer> seen = new HashSet<Integer>();
    static int best = -1;
    static Queue<State> queue  = new LinkedList<State>();

    static class State {
        boolean[][] grid;
        int steps;
        public State(boolean[][] g,int n) { grid=g; steps=n; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean[][] grid = new boolean[4][4];
        for(int i=0; i<4; i++) {
            String line = in.nextLine();
            for(int j=0; j<4; j++)
                grid[i][j] = line.charAt(j)=='w';
        }
        queue.add(new State(grid,0));
        while(!queue.isEmpty()) {
            bfs(queue.poll());
        }
        System.out.println(best>=0?best:"Impossible");
    }
    public static void bfs(State s) {
        boolean[][] grid = s.grid;
        int steps = s.steps;

        if(seen.contains(hash(grid))) return;
        seen.add(hash(grid));
        if((count(grid)==0 || count(grid)==16) && (best==-1 || steps < best)) {
            best = steps;
            return;
        }
        for(int i=0; i<4; i++)
            for(int j=0; j<4; j++) {
                boolean[][] next = new boolean[4][4];
                for(int k=0; k<4; k++)
                    for(int l=0; l<4; l++)
                        next[k][l] = (Math.abs(k-i)+Math.abs(l-j) <= 1 ? !grid[k][l] : grid[k][l]);
                if(!seen.contains(hash(next)))
                    queue.offer(new State(next,steps+1));
            }
    }
    public static int count(boolean[][] grid) {
        int ans = 0;
        for(int i=0; i<4; i++)
            for(int j=0; j<4; j++)
                if(grid[i][j]) ans++;
        return ans;
    }
    public static int hash(boolean[][] grid) {
        int ans = 0;
        for(int i=0; i<4; i++)
            for(int j=0; j<4; j++)
                if(grid[i][j])
                    ans+=1<<(i*4+j);
        return ans;
    }
}
