import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P603 {
    static char[] grid = new char[16];
    static Node root = new Node();
    static List<String> words = new ArrayList<String>();
    static Set<String> found = new HashSet<String>();

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        for(int i=0; i<4; i++) {
            String s = in.next();
            for(int j=0; j<4; j++)
                grid[i*4+j] = s.charAt(j);
        }
        int n = in.nextInt();
        for(int i=0; i<n; i++) {
            String s = in.next();
            while(s.equals("")) s = in.nextLine();
            words.add(s);
            add(s);
        }
        
        for(int i=0; i<4; i++)
            for(int j=0; j<4; j++)
                search(i,j);

        for(String s:words) {
            System.out.println(s+": "+(found.contains(s)?"YES":"NO") );
        }
    }

    public static void search(int y,int x) {
        search(y*4+x,root,0,new char[16],0);
    }
    public static void search(int c, Node cur,int seen,char[] path,int ix)
    {
        if(cur.terminal) {
            char[] word = new char[ix];
            for(int i=0; i<ix; i++)
                word[i] = path[i];
            found.add(new String(word));
        }
        if(cur.has(grid[c]) && ((seen&(1<<c))==0) ) {
            path[ix] = grid[c];
            if(c>0 && (c%4)!=0)
                search(c-1, cur.arr[grid[c]-'a'], seen|(1<<c), path,ix+1);
            if(c<15 && (c%4)!=3)
                search(c+1, cur.arr[grid[c]-'a'], seen|(1<<c), path,ix+1);
            if(c>=4)
                search(c-4, cur.arr[grid[c]-'a'], seen|(1<<c), path,ix+1);
            if(c<12)
                search(c+4, cur.arr[grid[c]-'a'], seen|(1<<c), path,ix+1);
        }
    }
    
    private static class Node {
        Node[] arr;
        boolean terminal;

        public Node() {
            arr = new Node[26];
            terminal = false;
        }
        public String toString() {
            return toString("");
        }
        public String toString(String indent) {
            String ans = "";
            for(int i=0; i<26; i++)
                if(arr[i] != null)
                    ans += indent+(char)('a'+i)+":\n"+arr[i].toString(indent+" ");
            return ans;
        }
        public boolean has(char c) { return arr[c-'a'] != null; }
    }
    public static void add(String s) {
        add(root,s,0);
    }
    public static void add(Node n,String s,int i) {
        if(i == s.length()) {
            n.terminal = true;
            return;
        }
        if(n.arr[s.charAt(i)-'a'] == null)
            n.arr[s.charAt(i)-'a'] = new Node();
        add(n.arr[s.charAt(i)-'a'],s,i+1);

    }
}
