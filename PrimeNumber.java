import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class PrimeNumber {

    public static void main(String[] args) throws FileNotFoundException {
        int primeCount, stepCount, primeNumber;
        long nanoStartTime;
        long nanoEndTime;
        double timeTaken=System.nanoTime();
        Scanner s = new Scanner(new File("Values.txt"));

        ArrayList<Integer> listI = new ArrayList<Integer>();
        while (s.hasNextLine()) {
            listI.add(s.nextInt());
        }
        Integer[] n = new Integer[listI.size()];
        n = listI.toArray(n);
        primeCount = 0;
        stepCount = 0;
        primeNumber = 1;
        for (int k = 0; k < n.length; k++) {
            primeCount = 0;
            nanoStartTime=System.nanoTime();
            for (int i = 2; i <= n[k]; i++) {
                primeNumber = 1;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        primeNumber = 0;
                        break;
                    }
                }
                if (primeNumber == 1) {
                    primeCount++;
                }
                nanoEndTime=System.nanoTime();
                timeTaken = (nanoEndTime - nanoStartTime)/1e9;
            }
                stepCount++;
                System.out.println("Step Number:" + stepCount);
                System.out.println("Number of prime numbers:" + primeCount);
                System.out.println("Time taken in seconds: " +timeTaken);
                System.out.println("\n");
        }
    }

}
