import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P67 {
    static Map<String,List<String>> children;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        children = new HashMap<String,List<String>>();
        List<String> root = new ArrayList<String>();
        int n = in.nextInt(); in.nextLine();
        for(int t=0; t<n; t++) {
            String[] arr = in.nextLine().split("\\\\");
            String[] tmp = new String[arr.length];
            tmp[0] = arr[0];
            for(int i=1; i<arr.length; i++)
                tmp[i] = tmp[i-1]+"/"+arr[i];
            for(int i=0; i<arr.length; i++)
                if(!children.containsKey(tmp[i]))
                    children.put(tmp[i],new ArrayList<String>());
            if(!root.contains(tmp[0]))
                root.add(tmp[0]);
            for(int i=0; i<arr.length-1; i++) {
                if(!children.get(tmp[i]).contains(tmp[i+1]))
                    children.get(tmp[i]).add(tmp[i+1]);
            }
        }
        Collections.sort(root);
        for(String s:root) emit(s,"");
    }
    public static void emit(String str,String padding) {
        System.out.println(padding+convert(str));
        List<String> c = children.get(str);
        Collections.sort(c);
        for(String s:c) emit(s,padding+" ");
    }
    public static String convert(String str) {
        return str.substring(str.lastIndexOf('/')+1);
    }
}
