package rentalstore;

/**
 * @Author: Leon
 * @Description:
 * @Date: Create in 1:08 AM 8/28/2018
 * @Modified By:
 */
public class NewReleaseMovie {
    public NewReleaseMovie() {
    }
    public double getThisAmount(double thisAmount, Rental each){
        thisAmount+=each.getDayRented()*3;
        return thisAmount;
    }
}
