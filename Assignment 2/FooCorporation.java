import java.util.Scanner;

public class FooCorporation {

    private static int BaseHour = 40;
    private static double MinWage = 8.00;
    private static double OverRate = 1.5;
    private static int OverHour = 60;

    private static double salary(double base, int hour) throws Exception {
        /* Check the base pay */
        if (base < MinWage) {
            throw new Exception("The base pay should not be less than $" + MinWage + "!");
        }
        /* Check the work hour */
        if (hour > OverHour) {
            throw new Exception("The number of hours can't be greater than " + OverHour + "!");
        }
        double TotalSalary = 0.;

        if (hour <= BaseHour) {
            TotalSalary += hour * base;
        } else {
            TotalSalary += BaseHour * base;
            TotalSalary += (hour - BaseHour) * base * OverRate;
        }

        return TotalSalary;
    }


    public static void main(String[] args) throws Exception {
        /* Scan the inputs */
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Scanner liScanner = new Scanner(line);

        double BasePay = liScanner.nextDouble();
        int WorkHour = liScanner.nextInt();

        scanner.close();
        liScanner.close();

        /* Compute the salary and print it */
        double salary = salary(BasePay, WorkHour);
        System.out.println("The salary of the employee is " + salary + ".");
    }
}
