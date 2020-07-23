import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Utilities {
    private static long seed = 0;
    private static long timerStart = 0;
    private static StringTokenizer st = new StringTokenizer("");
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	//Seed the random number generator, same seed guarantees same sequence of numbers
	public static void setSeed(int a){
		seed = a % (2<<31 - 1);
	}

    //produces a random int between 0 and 2^31-1 (with period 2^31-1)
    public static int nextRandomInt(){
        seed = (1103515245 * seed + 12345) % (2<<31 - 1);
        return (int) seed;
    }

    //Starts timer
    public static void startTimer(){
        timerStart = System.currentTimeMillis();
    }

    //Returns time in seconds since the last time startTimer() was called
    public static double checkTimer(){
        return (System.currentTimeMillis() - timerStart) / 1000.;
    }
}
