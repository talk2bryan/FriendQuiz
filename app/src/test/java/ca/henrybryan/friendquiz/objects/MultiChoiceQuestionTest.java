package ca.henrybryan.friendquiz.objects;

import junit.framework.TestCase;

/**
 * Created by Bryan Wodi <talk2kamp@gmail.com> on 16-07-29.
 */
public class MultiChoiceQuestionTest extends TestCase{
    public MultiChoiceQuestionTest(String arg0) {super(arg0);}

    public  void testObjectCreation(){
        System.out.println("Starting testObjectCreation");

        MultiChoiceQuestion question = new MultiChoiceQuestion("What is a String?","an int","an object","a double","an object",1,1);
    }


}
