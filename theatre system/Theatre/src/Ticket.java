public class Ticket {
    int row;
    int seat;
    double price;
    Person person;

    // Constructor that takes row, seat, price, and a Person object as inputs
    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // Getters for row, seat, price, and person
    public int getRow() {
        return row;
    }


    public int getSeat() {
        return seat;
    }


    public double getPrice() {
        return price;
    }



    // Method that prints all the information from a ticket
    public void print() {
        System.out.println("Person's name is: " + person.getName());
        System.out.println("Person's surname is: " + person.getSurname());
        System.out.println("Person's email is: " + person.getEmail());
        System.out.println("Row number is: " + row);
        System.out.println("Seat number is: " + seat);
        System.out.println("Ticket price is: £" + price + "\n");
    }
}
