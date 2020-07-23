import java.util.Random;

/**
 * @author Torstein Strømme
 */
@SuppressWarnings({"SameParameterValue", "WeakerAccess"})
public class BigOQuiz {
    int count = 0;

    void step() {
        count++;
    }

    int tally() {
        int res = count;
        count = 0;
        return res;
    }

    public static void main(String[] args) {
        // Test out whether your function makes sense.
        BigOQuiz q = new BigOQuiz();

//        q.functionB(0);
//        System.out.printf("B0 %d\n", q.tally());
//
//        q.functionB(1);
//        System.out.printf("B1 %d\n", q.tally());
        
        for (int i = 1; i<=10; i++) {
            q.functionF(i);
            System.out.printf(i+"Q %d\n", q.tally());
        }
        

    }


    void functionA(int n) {
        step();
        for (int i = 0; i < n; i++) {
            step();
            step();
        }
    }

    void functionB(int n) {
        step();
        if (n > 0) {
            step();
            functionB(n/2);
        }
    }

    void functionC(int n) {
        step();
        step();
        for (int i = 0; i < n; i++) {
            step();
            for (int j = 0; j <= i; j++) {
                step();
            }
        }
    }

    void functionD(int n) {
        if (n % 2 == 0) {
            step();
        }
        else
            step();
    }

    void functionE(int n) {
        for (int i = 0; i < n; i += 3) {
            step();
        }
    }

    void functionF(int n) {
        step();
        for (int i = 0; i < n; i++) {
            functionF(n-1);
        }
    }

    void functionG(int n) {
        step();
        if (n > 0)
            functionG(n-1);
    }

    void functionH(int n) {
        step();
        if (n > 0) {
            functionH(n/2);
        }
    }

    void functionI(int n) {
        if (n > 0) {
            functionI(n/2);
        }

        for (int i = 0; i < n; i++) {
            step();
        }

        if (n > 0) {
            functionI(n/2);
        }
    }

    void functionJ(int n) {
        for (int i = 0; i*i < n; i++) {
            step();
            step();
        }
    }

    void functionK(int n) {
        for (int i = n; i > 0; i /= 2) {
            step();
        }
    }

    void functionL(int n) {
        for (int i = 0; i <= n; i++) {
            step();
            step();
        }
    }

    void functionM(int n) {
        step();
        for (int i = n; i > 0; i = i / 2) {
            for (int j = 0; j < i; j++) {
                step();
            }
        }
    }

    void functionN(int n) {
        Random random = new Random();
        int target = random.nextInt(n);
        int lo = 0;
        int hi = n;

        while (hi - lo > 1) {
            step();
            int mid = (lo + hi) / 2;

            if (mid > target) {
                hi = mid;
            }
            else {
                lo = mid;
            }
        }
    }

    void functionO(int n) {
        step();
        if (n > 0) {
            functionO(n-1);
            functionO(n-1);
            functionO(n-1);
        }
    }

    void functionP(int n) {
        for (int i = 0; i < n; i++) {
            step();
            for (int j = 1; j <= n; j *= 3) {
                step();
            }
        }
    }

    void functionQ(int n) {
        step();
        for (int i = 1; i <= n; i *= 2) {
            step();
            step();
        }

        for (int i = 0; i <n; i++) {
            step();
        }
    }

    void functionR(int n) {
        int i = n * n * n;
        while (i > 0) {
            step();
            for (int j = 0; j * j < n; j++) {
                step();
                i--;
            }
        }
    }


    void functionS(int n) {
        for (int i = 0; i < Math.log(n); i++) {
            step();
        }

        if (n > 0) {
            functionS(n / 2);
        }
    }

    void functionT(int n) {
        int len = 0;
        while (n > 0) {
            len++;
            n = n / 2;
        }

        int i = 1;
        for (int j = 0; j < len; j++) {
            step();
            i = i * 2;
        }

        for (int j = 0; j < i; j++) {
            step();
        }
    }

    void functionU(int n) {
        for (int i = 0; i * i < n; i++) {
            step();
        }
        for (int i = n; i > 0; i--) {
            step();
        }
        for (int i = n; i > 0; i = i / 2) {
            step();
        }
    }

    void functionV(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                step();
            }
        }
    }
}