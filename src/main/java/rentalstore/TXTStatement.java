package rentalstore;

import java.util.Enumeration;

/**
 * @Author: Leon
 * @Description:
 * @Date: Create in 12:13 AM 8/28/2018
 * @Modified By:
 */
public class TXTStatement {
    public String statement(Customer customer){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = customer.getRentals().elements();
        String result = "Rental Record for " + customer.getName() + "\n";
        while(rentals.hasMoreElements()){
            double thisAmount =0;
            Rental each = (Rental) rentals.nextElement();
            switch (each.getMovie().getPriceCode()){
                case Movie.REGULAR:
                    thisAmount += 2;
                    if(each.getDayRented() > 2){
                        thisAmount+=(each.getDayRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount+=each.getDayRented()*3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount+=1.5;
                    if(each.getDayRented() > 3){
                        thisAmount += (each.getDayRented() -3)*1.5;
                    }
                    break;
            }
            //add frequent renter points
            frequentRenterPoints ++;
            //add bonus for a two day new release rental
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1){
                frequentRenterPoints ++;
            }
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is" + String.valueOf(totalAmount) + "\n";
        result += "You earned" + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
