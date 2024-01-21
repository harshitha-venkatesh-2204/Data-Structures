public class Radix {
    public static void main(String[] args) {
        int[] a = { 5585, 3, 1339, 443223, 210, 554, 412, 2341, 917, 895, 73, 29, 0, 6, 18, 99, 980 };

        // Print unsorted array.
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        double start = System.nanoTime();
        // Sort the array.
        a = radixSort(a);
        double elapsed = (System.nanoTime() - start) / 1000000000;
        System.out.println("Time Taken: "+elapsed);

        // Print sorted array.
        System.out.println("Sorted Array:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    } // End Main

    public static int[] radixSort(int[] a) {
        // IMPLEMENT ME
        // Find the number of digits in the numbers.
        int maximum = a[0];
        for (int number : a) {
            if (number > maximum) {
                maximum = number;
            }
        }

        int numberOfDigits = (int) Math.floor(Math.log10(maximum)) + 1;

        // Perform counting sort.
        for (int digit = 1; digit <= numberOfDigits; digit++) {
            a = count(a, digit);
        }

        return a;

    } // End radixSort
      // sort digit place

    public static int[] count(int[] a, int digit) {
        int size = a.length;
        int[] result = new int[size];
        int[] count = new int[10];

        for (int i = 0; i < size; i++) {
            int sort = (a[i] / (int) Math.pow(10, digit - 1)) % 10;
            count[sort]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = size - 1; i >= 0; i--) {
            int sort = (a[i] / (int) Math.pow(10, digit - 1)) % 10;
            result[count[sort] - 1] = a[i];
            count[sort]--;
        }

        return result;
    }
} // End Class