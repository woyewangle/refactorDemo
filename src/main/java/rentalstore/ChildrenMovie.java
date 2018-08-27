package rentalstore;

/**
 * @Author: Leon
 * @Description:
 * @Date: Create in 1:06 AM 8/28/2018
 * @Modified By:
 */
public class ChildrenMovie {
    public ChildrenMovie() {
    }
    public double getThisAmount(double thisAmount, Rental each){
        thisAmount+=1.5;
        if(each.getDayRented() > 3){
            thisAmount += (each.getDayRented() -3)*1.5;
        }
        return thisAmount;
    }
}
