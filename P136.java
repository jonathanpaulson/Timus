import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P136 {
    static List<Integer> ans = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for(int i=0; i<n; i++)
            data[i] = in.nextInt();
        Node tree = new Node(null,null,data[n-1]);
        for(int i=n-2; i>=0; i--)
            tree.add(data[i]);
        trav(tree);
        for(int i=0; i<ans.size(); i++)
            System.out.print(ans.get(i)+(i==ans.size()-1?"":" "));
        System.out.println();
    }
    public static void trav(Node n) {
        if(n==null) return;
        trav(n.right);
        trav(n.left);
        ans.add(n.data);
    }
    public static class Node {
        Node left;
        Node right;
        int data;
        public Node(Node l,Node r,int d) {
            left = l;
            right = r;
            data = d;
        }
        public void add(int x) {
            if(x<data) {
                if(left==null) left=new Node(null,null,x);
                else left.add(x);
            } else {
                if(right==null) right=new Node(null,null,x);
                else right.add(x);
            }
        }
    }
}
