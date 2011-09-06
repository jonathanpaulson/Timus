import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P106 {
	static List<Integer>[] friends;
	static Map<Integer,Boolean> color;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		friends = (List<Integer>[]) new List[n];
		for(int i=0; i<n; i++) {
			friends[i] = new ArrayList<Integer>();
			while(true) {
				int k = in.nextInt();
				if(k==0) break;
				friends[i].add(k);
			}
			if(friends[i].size()==0) { System.out.println(0); System.exit(0); }
		}

		color = new HashMap<Integer,Boolean>();
		for(int i=0; i<n; i++)
			color(i,true);
		List<Integer> ans = new ArrayList<Integer>();
		for(Integer key:color.keySet())
			if(color.get(key))
				ans.add(key);
		System.out.println(ans.size());
		for(int i=0; i<ans.size(); i++)
			System.out.print((ans.get(i)+1)+(i==ans.size()-1?"":" "));
		System.out.println();
			
    }
	public static void color(int n,boolean c) {
		if(color.containsKey(n)) return;
		color.put(n,c);
		for(Integer i:friends[n])
			color(i-1,!c);
	}
}
