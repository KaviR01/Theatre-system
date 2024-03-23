import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays; // imports the Arrays class from the java.util package
import java.util.Scanner; // Import the Scanner class to read text files

public class Theatre {

    private static final int[] row1 = new int[12]; //an array for row1
    private static final int[] row2 = new int[16]; //an array for row2
    private static final int[] row3 = new int[20]; //an array for row3

    private static final ArrayList<Ticket> tickets = new ArrayList<>(); //an array list  of tickets to save all the Tickets


    public static void main(String[] args) {
        //print a welcome message at the start of the program
        System.out.println("*******  Welcome to the New Theatre  *******");

        //initialize all seats to be free(0)
        Arrays.fill(row1, 0);
        Arrays.fill(row2, 0);
        Arrays.fill(row3, 0);

        while(true){
            try{
                while (true) {
                    //Display menu and get user input
                    System.out.println("------------------------------------------------");
                    System.out.println("Please select an option:");
                    System.out.println("""
                    1) Buy a ticket
                    2) Print seating area
                    3) Cancel ticket
                    4) List available seats
                    5) Save to file
                    6) Load from file
                    7) Print ticket information and total price
                    8) Sort tickets by price
                      0) Quit""");
                    System.out.println("------------------------------------------------");

                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter option: ");
                    int option = input.nextInt();

                    switch (option) {
                        case 1 -> buyTicket();
                        case 2 -> printSeatingArea();
                        case 3 -> cancelTicket();
                        case 4 -> showAvailable();
                        case 5 -> saveFile();
                        case 6 -> loadFile();
                        case 7 -> showTicketsInfo();
                        case 8 -> sortTickets(tickets);
                        case 0 -> {
                            System.out.println("\n******* Thank You!!! Have a nice day!!! *******");
                            System.exit(0);
                        }
                        default -> System.out.println("Invalid option,Please select an option given above");
                    }
                }
            } catch (Exception e) {
                System.out.println("Something went wrong.Number required.");
            }
        }
    }

    //create a method called buyTicket
    public static void buyTicket() {
        Scanner input = new Scanner(System.in);

        //get the person's information
        System.out.print("Please enter person's name: ");
        String name = input.next();
        System.out.print("Please enter person's surname: ");
        String surname = input.next();
        System.out.print("Please enter person's email (username@gmail.com): ");
        String email = input.next();
        System.out.print("Please enter the ticket price: £");
        double price = input.nextDouble();

        while(true){
            try{
                //get row number
                System.out.print("Please enter the row number: ");
                int row = input.nextInt();

                //check that the row is correct
                while (row < 1 || row > 3) {
                    System.out.print("Invalid row number.Please select 1-3.\nEnter the row number again: ");
                    row = input.nextInt();
                }

                //get seat number
                System.out.print("Please Enter the seat number: ");
                int seat = input.nextInt();

                //check that the seats in a row is correct
                do {
                    if (row == 1) {
                        if (seat < 1 || seat > 12) {
                            System.out.println("Invalid seat number.Please select 1-12.");
                        } else {
                            if (row1[seat - 1] == 0) {
                                row1[seat - 1] = 1;
                                System.out.println("\n******* Thank you! Your purchase is successful *******" +
                                        "\nYour row number is " + row + " and your seat number is " + seat + "\n");
                                break;
                            }
                            else if (row1[seat-1] == 1) {
                                System.out.println("seat is already booked");
                            }
                        }

                    } else if (row == 2) {
                        if (seat < 1 || seat > 16) {
                            System.out.println("Invalid seat number.Please select 1-16.");
                        } else {
                            if(row2[seat - 1] == 0) {
                                row2[seat - 1] = 1;
                                System.out.println("\n******* Thank you! Your purchase is successful *******" +
                                        "\nYour row number is " + row + " and your seat number is " + seat + "\n");
                                break;
                            }
                            else if (row2[seat-1] == 1) {
                                System.out.println("seat is already booked");
                            }
                        }

                    } else {
                        if (seat < 1 || seat > 20) {
                            System.out.println("Invalid seat number.Please select 1-20.");
                        } else {
                            if(row3[seat - 1] == 0) {
                                row3[seat - 1] = 1;
                                System.out.println("\n******* Thank you! Your purchase is successful *******" +
                                        "\nYour row number is " + row + " and your seat number is " + seat + "\n");
                                break;
                            }
                            else if (row3[seat-1] == 1) {
                                System.out.println("seat is already booked");
                            }
                        }
                    }
                    System.out.print("Enter the seat number again: ");
                    seat = input.nextInt();
                } while (true);

                Person person = new Person(name, surname, email);        //creates a new object of the Person class with the given arguments
                Ticket ticket = new Ticket(row, seat, price, person);    //creates a new object of the Ticket class with the given arguments
                tickets.add(ticket);                                     //adds the newly created ticket to the tickets ArrayList
                ticket.print();                                          //calls the print() method of the ticket object to display its information

            } catch (Exception e) {
                System.out.print("\nSomething went wrong.Row and seat should be a number\n");
            }
            break;
        }

    }

    //create a method called printSeatingArea
    public static void printSeatingArea() {
        System.out.println("      *********");
        System.out.println("      * STAGE *");
        System.out.println("      *********");

        for (int i = 0; i < row1.length; i++) {    //row1
            if (i == 0) {
                System.out.print("    ");
            }
            if (i == 6) {
                System.out.print(" ");
            }
            if (row1[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.println();

        for (int i = 0; i < row2.length; i++) {    //row2
            if (i == 0) {
                System.out.print("  ");
            }
            if (i == 8) {
                System.out.print(" ");
            }
            if (row2[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.println();

        for (int i = 0; i < row3.length; i++) {    //row3
            if (i == 0) {
                System.out.print("");
            }
            if (i == 10) {
                System.out.print(" ");
            }
            if (row3[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.println();
    }

    //create a method called cancelTicket
    public static void cancelTicket() {
        Scanner input = new Scanner(System.in);

        while(true){
            try{
                //get row number
                System.out.print("Enter the row number you want to cancel: ");
                int row = input.nextInt();

                //check that the row is correct
                while (row < 1 || row > 3) {
                    System.out.print("Invalid row number.Please select 1-3.\nEnter the row number again: ");
                    row = input.nextInt();
                }


                //get seat number
                System.out.print("Enter the seat number you want to cancel: ");
                int seat = input.nextInt();

                //check that the seats in a row is correct
                do{
                    if (row == 1) {
                        if (seat < 1 || seat > 12) {
                            System.out.print("Invalid seat number.Please select 1-12.");
                        } else {
                            if( row1[seat - 1] == 1){
                                row1[seat - 1] = 0;
                            } else {
                                System.out.println("\nTicket not found, please try again.\n");
                                break;
                            }

                        }
                    } else if (row == 2) {
                        if (seat < 1 || seat > 16) {
                            System.out.print("Invalid seat number.Please select 1-16.");
                        } else {
                            if(row2[seat - 1] == 1){
                                row2[seat - 1] = 0;
                            }
                            else{
                                System.out.println("\nTicket not found, please try again.\n");
                                break;
                            }

                        }
                    } else {
                        if (seat < 1 || seat > 20) {
                            System.out.print("Invalid seat number.Please select 1-20.");
                        } else {
                            if(row3[seat - 1] == 1){
                                row3[seat - 1] = 0;
                            }
                            else{
                                System.out.println("\nTicket not found, please try again.\n");
                                break;
                            }
                        }

                    }

                    for (Ticket ticket : tickets) {     //loops through the tickets ArrayList to find a ticket that matches the row and seat number
                        if (ticket.getRow() == row && ticket.getSeat() == seat) {
                            tickets.remove(ticket);   //removes that ticket from the list using the remove() method
                            System.out.println("\n******* Ticket " + row +"-"+ seat +" cancelled successfully *******\n");
                            return;
                        }
                    }
                    System.out.print("Enter the seat number again: ");
                    seat = input.nextInt();
                }while(true);
            } catch (Exception e) {
                System.out.print("\nSomething went wrong.Row and seat should be a number\n");
            }
            break;
        }
    }

    // create a method called showAvailable
    public static void showAvailable(){
        System.out.print("Seats available in row 1: ");  //row1
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == 0) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

        System.out.print("Seats available in row 2: ");   //row2
        for (int i = 0; i < row2.length; i++) {
            if (row2[i] == 0) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

        System.out.print("Seats available in row 3: ");  //row3
        for (int i = 0; i < row3.length; i++) {
            if (row3[i] == 0) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    // create a method called saveFile
    public static void saveFile(){                        //https://www.w3schools.com/java/java_files_create.asp
        try {
            FileWriter myWriter = new FileWriter("theatre.txt");  //saves the current seating status to a file named "theatre.txt"
                myWriter.write((Arrays.toString(row1))+ "\n");  //row1
                myWriter.write((Arrays.toString(row2))+"\n");   //row2
                myWriter.write((Arrays.toString(row3)));           //row3
            myWriter.close();
            System.out.println("******* Save to the File Successful *******\n");
        } catch (IOException e) {
            System.out.println("An ERROR occurred.\n");
        }

    }

    // create a method called loadFile
    public static void loadFile(){                               //https://www.w3schools.com/java/java_files_read.asp
        try {
            File myfile = new File("theatre.txt");   //loads the data from the file "theatre.txt" and prints the contents of the file to the console
            Scanner fileReader = new Scanner(myfile);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An ERROR occurred.\n");
        }
    }

    // create a method called showTicketsInfo
    public static void showTicketsInfo(){
        double totalPrice = 0;     // displays the ticket information and the total price for all the tickets in the tickets ArrayList
        System.out.println("\n******* Ticket information and Total price *******\n");

        for (Ticket ticket : tickets) {
            ticket.print();
            totalPrice += ticket.getPrice();
        }
        System.out.println("Total price is: £" + totalPrice);
    }

    // create a method called sortTickets
    public static void sortTickets(ArrayList<Ticket> tickets){
        ArrayList<Ticket> sortedtickets = new ArrayList<>(tickets);
        if(sortedtickets.isEmpty()) {
            System.out.println("No tickets purchased.");
        }
        else{
            for(int i = 0; i < sortedtickets.size(); i++){
                for(int j = 0; j < sortedtickets.size(); j++){
                    if(sortedtickets.get(i).getPrice() < sortedtickets.get(j).getPrice() ){
                       Ticket temp = sortedtickets.get(i);
                        sortedtickets.set(i, sortedtickets.get(j));
                        sortedtickets.set(j, temp );
                    }
                }
            }
            System.out.println("\n******* Sorted tickets by price (cheapest first) ******* \n");

            for (Ticket ticket : sortedtickets) {
                ticket.print();
            }
        }
    }
}

