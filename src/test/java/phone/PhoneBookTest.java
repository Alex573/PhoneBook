package phone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PhoneBookTest {

    private String name1 = "Иванов И.И.";
    private String name2 = "Сидоров С.С.";
    private String name3 = "сидоров с.с.";
    private String error = "Full name not found";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() throws Exception {

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void clenUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    /**
     * checking the usual method for correct data
     */
    @Test
    public void printPhone() {
        PhoneBook.printPhone(name1);
        System.err.println("1. +8 800 2000 500");
        System.err.println("2. +8 800 200 600");
        assertEquals(errContent.toString(), outContent.toString());
    }

    /**
     * checking the ignorecase method for correct data
     */
    @Test
    public void printPhoneICase() {
        PhoneBook.printPhoneIgnoreCase(name2);
        printPhoneName3();
        assertEquals(errContent.toString(), outContent.toString());
    }

    /**
     * checking the usual method for  caseignor correct data
     */
    @Test
    public void printPhoneIgnoreCase() {
        PhoneBook.printPhoneIgnoreCase(name3);
        printPhoneName3();
        assertEquals(errContent.toString(), outContent.toString());
    }

    /**
     * checking the ignore method for incorrect data
     */
    @Test
    public void printPhoneIgnoreCaseNotFound() {
        PhoneBook.printPhoneIgnoreCase("Kdo toto");
        System.err.println(error);
        assertEquals(errContent.toString(), outContent.toString());
    }

    /**
     * checking the usual method for incorrect data
     */
    @Test
    public void printPhoneNotFound() {
        PhoneBook.printPhone("Kdo toto");
        System.err.println(error);
        assertEquals(errContent.toString(), outContent.toString());
    }

    /**
     * print Phone for Name3
     */
    private void printPhoneName3(){
        System.err.println("1. +8 800 2000 800");
        System.err.println("2. +8 800 2000 900");
        System.err.println("3. +8 800 2000 000");
    }
}