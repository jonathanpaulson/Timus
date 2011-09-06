import java.util.*;

public class P86 {
    public static void main(String[] args) {
        boolean[] c = new boolean[170000];
        for(int i=2; i<170000;) {
            for(int j=2; i*j<170000; j++)
                c[i*j] = true;
            i++;
            while(i<170000 && c[i]) i++;
        }
        List<Integer> primes = new ArrayList<Integer>(16000);
        for(int i=2; i<170000; i++)
            if(!c[i])
                primes.add(i);

        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for(int i=0; i<k; i++)
            System.out.println(primes.get(in.nextInt()-1));
    }
}
