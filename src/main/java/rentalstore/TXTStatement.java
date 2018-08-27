package rentalstore;

import java.util.Enumeration;

/**
 * @Author: Leon
 * @Description:
 * @Date: Create in 12:13 AM 8/28/2018
 * @Modified By:
 */
public class TXTStatement extends Statement{

    protected  String getAllItemString(Enumeration rentals) {
        String result="";
        while(rentals.hasMoreElements()){
            double thisAmount =0;
            Rental each = (Rental) rentals.nextElement();
            thisAmount = getThisAmount(thisAmount, each);
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        return result;
    }

    protected  String getHeaderString(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
    protected  String getFooterString() {
        //add footer lines
        String result = "Amount owed is" + String.valueOf(totalAmount) + "\n";
        result += "You earned" + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

}
