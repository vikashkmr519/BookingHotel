import java.util.Scanner;

public class DriverClass {

    public static BookingRequest bookingRequest;

    public  static void main(String[] args){
        System.out.println("Welcome to XYZ hotels");
        System.out.println("*****************************");
        Scanner sc = new Scanner(System.in);
        System.out.println("What's your name?");
        String customerName = sc.nextLine();
        System.out.println("Hi.. "+customerName + " , happy to serve you :)");
        System.out.println("which occupancy you required?");
        System.out.println("Enter 1 for Single");
        System.out.println("Enter 2 for Double");
        System.out.println("Enter 3 for Triple");
        int occupancyType = sc.nextInt();
        sc.nextLine();

        System.out.println("Do you want AC");
        System.out.println("Type y for YES");
        System.out.println("Type N for NO");
        String ac = sc.nextLine();

        System.out.println("Which Floor Would you prefer?");
        System.out.println("Enter 1 for 1");
        System.out.println("Enter 2 for 2");
        System.out.println("No preference Type 0");
        int floorNum = sc.nextInt();

        System.out.println(customerName+" " +occupancyType+" "+ac+" "+floorNum+" ");

        bookingRequest = new BookingRequest();

    }
}
