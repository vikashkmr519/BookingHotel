import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class DriverClass {


    public static Inventory inventory  = new Inventory();



    public  static void main(String[] args){


    bookingLabel:
    while(true) {
        System.out.println("Welcome to XYZ hotels");
        System.out.println("*****************************");
        Scanner sc = new Scanner(System.in);

        System.out.println("What's your name?");
        String customerName = sc.nextLine();

        Customer customer = new Customer(customerName, Integer.valueOf(new Random().nextInt(1000)), null);
        System.out.println("Hi.. " + customerName + " , happy to serve you :)");
        occupancyLabel:
        while (true) {
            System.out.println("which occupancy you required?");
            System.out.println("Enter 1 for Single");
            System.out.println("Enter 2 for Double");
            System.out.println("Enter 3 for Triple");
            int occupancyType = sc.nextInt();
            sc.nextLine();

            switch (occupancyType) {
                case 1:
                    customer.setOccupancyRequired(Occupancy.SINGLE);
                    break occupancyLabel;
                case 2:
                    customer.setOccupancyRequired(Occupancy.DOUBLE);
                    break occupancyLabel;
                case 3:
                    customer.setOccupancyRequired(Occupancy.TRIPPLE);
                    break occupancyLabel;
                default:
                    System.out.println("Please enter a valid number");
            }
        }
        Facility facility = new Facility();
        facilityLabel:
        while (true) {
            System.out.println("Do you want AC");
            System.out.println("Type Y for YES");
            System.out.println("Type N for NO");
            String ac = sc.nextLine();
            switch (ac.toUpperCase()) {
                case "Y":
                    facility.setAC(true);
                    break facilityLabel;

                case "N":
                    facility.setAC(false);
                    break facilityLabel;

                default:
                    System.out.println("Please enter a valid Input");
            }
        }
        BookingRequest bookingRequest = new BookingRequest(customerName, customer.getOccupancyRequired(), facility, 0);
        floorLabel:
        while (true) {
            System.out.println("Which Floor Would you prefer?");
            System.out.println("Enter 1 for 1");
            System.out.println("Enter 2 for 2");
            System.out.println("No preference Type 0");
            int floorNum = sc.nextInt();

            switch (floorNum) {
                case 1:
                    bookingRequest.setFloorNumber(1);
                    break floorLabel;
                case 2:
                    bookingRequest.setFloorNumber(2);
                    break floorLabel;
                case 0:
                    bookingRequest.setFloorNumber(0);
                    break floorLabel;
                default:
                    System.out.println("Please give valid Input");
            }
        }

        //System.out.println(bookingRequest);
        Booking booking = new Booking(customer, bookingRequest);
        Room response = booking.completeBooking(inventory);

        if (response == null) {
            //toh kuch issue hai handle here
            System.out.println("Sorry your requirement can not be satisfied");

        } else {
            System.out.println("Please Complete the payment as final step..");
            System.out.println("Type the amount showing here : " + response.getPrice() + " and you payment will be completed");
            while (true) {
                double amount = sc.nextDouble();
                sc.nextLine();

                if (amount != response.getPrice()) {
                    System.out.println("Amount typed is not correct.");
                    System.out.println("Want to try again ?");
                    System.out.println("if Yes type yes");
                    System.out.println("if no type No");
                    String paymentTry = sc.nextLine();
                    if (paymentTry.toUpperCase().equals("YES")) {
                        double amount2 = sc.nextDouble();
                        sc.nextLine();

                        if (amount2 != response.getPrice()) {
                            System.out.println("Sorry your payment failed multiple time, please try later.");
                            inventory.onPaymentUnsuccessful(response, customer);
                            break;
                        } else {
                            System.out.println("Payment Successfull. :)");
                            System.out.println("Please Enjoy your stay here " + customerName.toUpperCase());
                            break;
                        }
                    } else if (paymentTry.toUpperCase().equals("NO")) {
                        sc.close();
                        System.out.println("You chose to not to proceed forward. Thank you for your time");
                        inventory.onPaymentUnsuccessful(response, customer);
                        break;

                    } else {
                        System.out.println("We are really sorry , your payment is unsuccessful");
                        inventory.onPaymentUnsuccessful(response, customer);
                        break;
                    }

                } else {
                    System.out.println("Payment Successfull. :)");
                    System.out.println("Please Enjoy your stay here " + customerName.toUpperCase());
                    System.out.println("Your room Details are : ->");
                    System.out.println("Room Number: " + response.getRoomNum());
                    System.out.println("Occupancy  : " + response.getOccupancy());
                    System.out.println("AC         : " + response.getFacility().getAC());
                    System.out.println("Thankyou " + customerName.toUpperCase());
                    System.out.println("******************************************");
                    System.out.println();
                    break;
                }
            }
        }
    }

    }
}
