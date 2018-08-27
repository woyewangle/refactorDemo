package rentalstore;

/**
 * @Author: Leon
 * @Description:
 * @Date: Create in 1:08 AM 8/28/2018
 * @Modified By:
 */
public class NewReleaseMovie extends MovieFactory{
    public NewReleaseMovie() {
    }
    protected  double getThisAmount(double thisAmount, Rental each){
        thisAmount+=each.getDayRented()*3;
        return thisAmount;
    }
}
