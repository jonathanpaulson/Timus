import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P258 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int W = in.nextInt();
		int D = in.nextInt(); in.nextLine();
		int x0 = in.nextInt();
		int y0 = in.nextInt(); in.nextLine();
		int x1 = in.nextInt();
		int y1 = in.nextInt(); in.nextLine();

		long dx = 0;
		long dy = 0;
		int curx = x0;
		int cury = y0;
		String path = in.nextLine();
		for(int i=0; i<path.length(); i++) {
			switch(path.charAt(i)) {
				case 'F': dy+=cury; cury=0; break;
				case 'L': dx+=curx; curx=0; break;
				case 'R': dx+=W-curx; curx=W; break;
				case 'B': dy+=D-cury; cury=D; break;
			}
		}
		dx+=abs(x1-curx);
		dy+=abs(y1-cury);
		System.out.printf("%.4f\n",(sqrt(dx*dx+dy*dy)));
    }
}
