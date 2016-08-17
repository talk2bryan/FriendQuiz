package ca.henrybryan.friendquiz.objects;

/**
 * Created by Bryan Wodi <talk2kamp@gmail.com> on 16-08-10.
 */
import junit.framework.ComparisonFailure;
import junit.framework.TestCase;

import ca.henrybryan.friendquiz.objects.UserResponse;

public class UserResponseTest extends TestCase {
    public UserResponseTest(String arg0) {super(arg0);}

    public void testResponseCreationAndModification(){
        UserResponse response;

        System.out.println("Starting testResponseCreationAndModification()");

        response = new UserResponse("b");
        assertNotNull(response);
        assertEquals("b",response.getUserResponse());

        response.setUserResponse("a");
        assertNotNull(response);

        try{
            assertEquals("b",response.getUserResponse());
            fail("expected assertion to fail");
        }catch (ComparisonFailure cf){
            System.out.println(cf.getMessage());
        }

        System.out.println("Finished testResponseCreationAndModification()");
    }
}
