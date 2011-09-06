import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P446 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String>[] L = new List[4];
        String[] houses = new String[]{"Slytherin","Hufflepuff","Gryffindor","Ravenclaw"};
        for(int i=0; i<4; i++) L[i] = new ArrayList<String>();
        int n = in.nextInt(); in.nextLine();
        for(int i=0; i<n; i++) {
            String name = in.nextLine();
            String house = in.nextLine();
            for(int j=0; j<4; j++)
                if(house.equals(houses[j]))
                    L[j].add(name);
        }
        for(int i=0; i<4; i++) {
            System.out.println(houses[i]+":");
            for(String s:L[i])
                System.out.println(s);
            System.out.println();
        }
    }
}
