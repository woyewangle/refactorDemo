package rentalstore;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @Author: Leon
 * @Description:
 * @Date: Create in 2:01 PM 8/24/2018
 * @Modified By:
 */
public class CustomerTest {
    private Customer customer=new Customer("Jerry");


    @Test
    public void should_return_correct_statement_given_customer_has_no_rental() {
        String statement = customer.TxtStatement();

        assertEquals("Rental Record for Jerry\nAmount owed is0.0\nYou earned0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = new Movie("Titanic", 0);
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.TxtStatement();

        assertEquals("Rental Record for Jerry\n" +
                "\t" + regularMovie.getTitle() + "\t2.0\n" +
                "Amount owed is2.0\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        Movie regularMovie = new Movie("Titanic", 0);
        Rental oneDayRental = new Rental(regularMovie, 3);
        customer.addRental(oneDayRental);

        String statement = customer.TxtStatement();

        assertEquals("Rental Record for Jerry\n" +
                "\t" + regularMovie.getTitle() + "\t3.5\n" +
                "Amount owed is3.5\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_new_release_movie_has_rent_one_rental_and_day_rented_1() {
        Movie movie =new Movie("movie1Title",Movie.NEW_RELEASE);
        Rental rental = new Rental(movie,1);
        customer.addRental(rental);

        String result = customer.TxtStatement();

        assertThat(result,is("Rental Record for Jerry\n" +
                "\tmovie1Title\t3.0\n" +
                "Amount owed is3.0\n" +
                "You earned1 frequent renter points"));
    }


    @Test
    public void should_return_correct_statement_given_customer_new_release_movie_has_rent_one_rental_and_day_rented_4() {
        Movie movie =new Movie("movie1Title",Movie.NEW_RELEASE);
        Rental rental = new Rental(movie,4);
        customer.addRental(rental);

        String result = customer.TxtStatement();

        assertThat(result,is("Rental Record for Jerry\n" +
                "\tmovie1Title\t12.0\n" +
                "Amount owed is12.0\n" +
                "You earned2 frequent renter points"));
    }

    @Test
    public void should_return_html_statement() {
        Movie movie =new Movie("Roman Holiday",Movie.NEW_RELEASE);
        Rental rental=new Rental(movie,1);
        customer.addRental(rental);

        String result=  customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                "\tRoman Holiday\t3.0<BR>\n" +
                "<P>You owe<EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>",result);
    }














}