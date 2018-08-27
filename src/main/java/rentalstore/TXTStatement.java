package rentalstore;

import java.util.Enumeration;

/**
 * @Author: Leon
 * @Description:
 * @Date: Create in 12:13 AM 8/28/2018
 * @Modified By:
 */
public class TXTStatement {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    public String statement(Customer customer){
        Enumeration rentals = customer.getRentals().elements();
        String result = getHeaderString(customer);
        result +=getAllItemString(rentals);
        result += getFooterString();
        return result;
    }

    private String getAllItemString(Enumeration rentals) {
        String result="";
        while(rentals.hasMoreElements()){
            double thisAmount =0;
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        return result;
    }

    private String getHeaderString(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
    private String getFooterString() {
        //add footer lines
        String result = "Amount owed is" + String.valueOf(totalAmount) + "\n";
        result += "You earned" + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
