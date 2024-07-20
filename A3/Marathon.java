import java.util.Arrays;
import java.util.Scanner;

class Marathon {
    private static int KthFastestRunner(int[] times, int k) {
        /* Copy the array for sort */
        Integer[] TimeCopy = new Integer[times.length];
        for (int i = 0; i < TimeCopy.length; i++) {
            TimeCopy[i] = times[i];
        }
        Arrays.sort(TimeCopy);
        /* Find the K Smallest Value */ 
        int kValue = TimeCopy[k - 1];
        /* Find the index of the runner */
        for (int i = 0; i < TimeCopy.length; i++) {
            if (times[i] == kValue) {
                return i;
            }
        }
        return -1; // Return -1 if error ocurrs
    }


    public static void main (String[] arguments) {
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
        };

        int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
            343, 317, 265
        };

        // for (int i = 0; i < names.length; i++) {
        //     System.out.println(names[i] + ": " + times[i]);
        // }

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Scanner liScanner = new Scanner(line);
        int k = liScanner.nextInt();
        scanner.close();
        liScanner.close();

        int index = KthFastestRunner(times, k);
        System.out.println("The " + k + "-th runner is -> " + names[index] + ": " + times[index]);
    }
} 