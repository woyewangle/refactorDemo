package rentalstore;

/**
 * @Author: Leon
 * @Description:
 * @Date: Create in 1:14 AM 8/28/2018
 * @Modified By:
 */
public abstract class MovieFactory {
    protected abstract double getThisAmount(double thisAmount, Rental each);
}
