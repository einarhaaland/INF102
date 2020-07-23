import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Utilities {
    private static long seed = 0;
    private static long timerStart = 0;
    private static StringTokenizer st = new StringTokenizer("");
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


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

    //Returns the next int from standard in
    static int nextInt() throws Exception{
        while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    //Returns the next long from standard in
    static long nextLong() throws Exception{
        while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Long.parseLong(st.nextToken());
    }

    //Returns the next double from standard in
    static double nextDouble() throws Exception{
        while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Double.parseDouble(st.nextToken());
    }

    //Returns the next String (split by whitespace) from standard in
    static String nextToken() throws Exception{
        while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}