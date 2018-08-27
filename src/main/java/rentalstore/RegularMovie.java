package rentalstore;

/**
 * @Author: Leon
 * @Description:
 * @Date: Create in 1:08 AM 8/28/2018
 * @Modified By:
 */
public class RegularMovie extends MovieFactory{
    public RegularMovie() {
    }
    protected  double getThisAmount(double thisAmount, Rental each){
        thisAmount += 2;
        if(each.getDayRented() > 2){
            thisAmount+=(each.getDayRented() - 2) * 1.5;
        }
        return thisAmount;
    }
}
