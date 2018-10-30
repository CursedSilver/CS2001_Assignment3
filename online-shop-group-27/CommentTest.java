

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    private Comment comment1;
    private Comment comment2;

    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
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
        comment1 = new Comment("John", "Absolutely fantastic!", 10);
        comment2 = new Comment("", "", 0);
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
    public void downVote()
    {
        comment1.downvote();
        comment2.downvote();
    }

    @Test
    public void getRating()
    {
        assertEquals(0, comment2.getRating());
        assertEquals(10, comment1.getRating());
    }

    @Test
    public void createFalseComment()
    {
        Comment comment3 = new Comment("asdf", "Disgusting", -5);
        comment3.downvote();
        assertEquals(0, comment3.getRating());
    }
}



