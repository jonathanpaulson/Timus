import java.util.*;

public class P104 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = "";
        while(in.hasNextLine())
            line+=in.nextLine().trim();
        int largest = 1;
        for(int i=0; i<line.length(); i++) {
            if(n(line.charAt(i))>largest)
                largest = n(line.charAt(i));
        }
        int sod = 0;
        for(int i=0; i<line.length(); i++)
            sod+=n(line.charAt(i));
        for(int k=largest+1; k<=36; k++) {
            if(sod%(k-1)==0)
                { System.out.println(k); return; }
        }
        System.out.println("No solution.");
    }
    public static int n(char c) {
        return Character.isLetter(c)?c-'A'+10:c-'0';
    }
}
