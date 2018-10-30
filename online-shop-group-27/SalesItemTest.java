

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SalesItemTest
{
    private SalesItem salesIte1;
    private SalesItem salesIte2;

    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        salesIte1 = new SalesItem("Pepsi", 10);
        salesIte1.addComment("James", "Better than Coke", 5);
        salesIte1.addComment("Kristie", "it's awful", 1);
        salesIte2 = new SalesItem("Shoe", 500);
        salesIte2.addComment("Becky", "Its blue", 5);
        salesIte2.addComment("Rami", "its red", 5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void TestAddComment()
    {
        assertEquals(true, salesIte1.addComment("ME", "Test", 5));
        assertEquals(false, salesIte1.addComment("ME", "Test2", 5));
        assertEquals(false, salesIte1.addComment("ME2", "Test", 10));
        assertEquals(false, salesIte1.addComment("ME3", "Test", -1));
    }

 
    

    @Test
    public void TestRemoveComment()
    {
        salesIte1.removeComment(0);
        assertEquals(1, salesIte1.getNumberOfComments());
        salesIte2.removeComment(5);
        assertEquals(2, salesIte2.getNumberOfComments());
    }

    @Test
    public void TestConstructor()
    {
        SalesItem salesIte3 = new SalesItem("Cup", 20);
        assertEquals("Cup", salesIte3.getName());
        assertEquals(20, salesIte3.getPrice());
    }

    @Test
    public void TestUpvote()
    {
        salesIte1.upvoteComment(1);
        Comment comment1 = salesIte1.findMostHelpfulComment();
        assertEquals(1, comment1.getVoteCount());
    }

    @Test
    public void TestMostHelpful()
    {
        salesIte1.upvoteComment(0);
        salesIte1.upvoteComment(0);
        salesIte1.upvoteComment(1);
        Comment comment1 = salesIte1.findMostHelpfulComment();
        assertEquals(2, comment1.getVoteCount());
    }

    @Test
    public void TestDownvote()
    {
        salesIte1.upvoteComment(0);
        salesIte1.upvoteComment(0);
        salesIte1.downvoteComment(0);
        Comment comment1 = salesIte1.findMostHelpfulComment();
        assertEquals(1, comment1.getVoteCount());
    }

    @Test
    public void testRatingInvalid()
    {
        assertEquals(false, salesIte1.addComment("jojo", "I LOVE it", 10000000));
        assertEquals(true, salesIte1.addComment("Man", "its ok", 5));
    }

    @Test
    public void testFindAuthorComment()
    {
        assertEquals(false, salesIte1.addComment("James", "more things to say", 3));
        assertEquals(true, salesIte1.addComment("Unique Name", "Pepsi is pepsi", 3));
    }
}










