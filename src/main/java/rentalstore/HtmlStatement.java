package rentalstore;

import java.util.Enumeration;

/**
 * @Author: Leon
 * @Description:
 * @Date: Create in 12:12 AM 8/28/2018
 * @Modified By:
 */
public class HtmlStatement {

    double totalAmount = 0;
    int frequentRenterPoints = 0;

    public String statement(Customer customer){
        Enumeration rentals = customer.getRentals().elements();
        String result = getHeaderString(customer);
        result += getAllItemString(rentals);
        result += getFooterString();
        return result;
    }

    private String getAllItemString(Enumeration rentals) {
        String result = "";
        while(rentals.hasMoreElements()){
            double thisAmount =0;
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "<BR>\n";
            totalAmount += thisAmount;
        }
        return result;
    }


    private String getFooterString() {
        //add footer lines
        String result = "<P>You owe<EM>" + String.valueOf(totalAmount) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(frequentRenterPoints) + "</EM> frequent renter points<P>";
        return result;
    }
    private String getHeaderString(Customer customer) {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }

}
