package mj223gn_assign3.count_words;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for our Word
 * Created by Michael Johansson(mj223gn) on 2016-02-24.
 */
public class wordTest {

    private int run = 0;

    @Before
    public void setUp(){
        System.out.print("Running wordTest method: " +(++run));
    }
    @After
    public void tearDown(){System.out.println(" -----------> Done with wordTest " +run + "\n"); }

    @Test
    public void Word(){

        //We create some words to test.
        //test case sensitive.
        Word first = new Word("first");
        Word First = new Word("First");
        //test a empty word
        Word zero = new Word("");
        Word second = new Word("second");
        //test a long "Word"
        Word large = new Word("Hej jag heter michael johansson och är 24 år, jag bor i växjö och pluggar nätverkssäkerhet");

        assertEquals("Word first toString should be \"first\" ", "first", first.toString());
        assertEquals("Word First toString should be \"First\" ", "First", First.toString());
        assertEquals("Word zero toString should be \"\" ", "", zero.toString());
        assertEquals("first must be equal to First", true, first.equals(First));
        assertEquals("first and second should not be equal", false, first.equals(second));
        assertEquals("first and zero should not be equal", false, first.equals(zero));

        assertEquals("first and First hashCode must be the same", First.hashCode(), first.hashCode());

        assertEquals("first compared to second must return less then zero ", true, first.compareTo(second) < 0);
        assertEquals("second compared to first must return more then zero ", true, second.compareTo(first) > 0);

        assertEquals("A large hashcode should not give a negative value ", true, large.hashCode() > 0);
    }
}
