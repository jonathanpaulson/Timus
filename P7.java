import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(in.hasNext()) {
            StringBuffer s = new StringBuffer(in.next());
            int[] arr = new int[s.length()+1];
            arr[s.length()]=0;
            int sum = 0;    
            for(int i=s.length()-1; i>=0; i--) {
                sum+=s.charAt(i)=='1'?i+1:0;
                sum%=n+1;
                arr[i]=(i<s.length()-1?arr[i+1]:0)+(s.charAt(i)=='1'?1:0);
            }
            
            if(s.length()==n) {
                if(sum>0) s.setCharAt(sum-1,'0');
            } else if(s.length()<n) {
                for(int i=0; i<=s.length(); i++) {
                    if( (sum+(i+1)+arr[i])%(n+1) == 0) {
                        s.insert(i,'1');
                        break; 
                    }
                    else if( (sum+arr[i])%(n+1) == 0) {
                        s.insert(i,'0');
                        break;
                    }
                }
            } else {
                for(int i=0; i<s.length(); i++) {
                    if( (sum+s.length()*(n-1)-arr[i]-(s.charAt(i)=='1'?i:0))%(n+1)==0 ) {
                        s.deleteCharAt(i);
                        break;
                    }
                }
            }
            System.out.println(s);
        }
    }
}
