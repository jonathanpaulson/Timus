import java.util.*;

public class P226 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String line = in.nextLine();
            String s="";
            for(int i=0; i<line.length(); i++) {
                if(!Character.isLetter(line.charAt(i))) {
                    System.out.print(s);
                    s="";
                    System.out.print(line.charAt(i));
                } else s=line.charAt(i)+s;
            }
            System.out.print(s);
            System.out.println();
        }
    }
}
