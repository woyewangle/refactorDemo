package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement(){
        TXTStatement txtStatement = new TXTStatement();
        return txtStatement.statement(this);
    }


    public String htmlStatement(){
        HtmlStatement htmlStatement = new HtmlStatement();
        return htmlStatement.htmlStatement(this);
    }

    public void setName(String name) {
        this.name = name;
    }
    public Vector getRentals() {
        return rentals;
    }
    public void setRentals(Vector rentals) {
        this.rentals = rentals;
    }
}
