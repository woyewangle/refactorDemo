package rentalstore;

import java.util.Enumeration;

/**
 * @Author: Leon
 * @Description:
 * @Date: Create in 12:53 AM 8/28/2018
 * @Modified By:
 */
public abstract class Statement {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    public String statement(Customer customer){
        Enumeration rentals = customer.getRentals().elements();
        String result = getHeaderString(customer);
        result +=getAllItemString(rentals);
        result += getFooterString();
        return result;
    }
    protected abstract String getAllItemString(Enumeration rentals);
    protected abstract String getHeaderString(Customer customer);
    protected abstract String getFooterString();

    protected double getThisAmount(double thisAmount, Rental each) {
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
        return thisAmount;
    }
}