/**
 * 
 */
package henrybryan.friendquiz.objects;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class MultiChoiceQuestion extends Question {
	  private String a,b,c;
	  
	  public MultiChoiceQuestion(String q, String aa, String bb, String cc, String ans,int p, int f){
		  
	    super(q,ans,p,f);
	    a=aa.toLowerCase();
	    b=bb.toLowerCase();
	    c=cc.toLowerCase();
	  }
	  
	  @Override
	  public String getQuestion (){
	    String result = " "+ question + "\n(a) " + a +" (b) "+ b +" (c)" +c;
	    return result;
	  }
	  
//	  public void setReply(String str){
//	    char ch = str.charAt(0);
//	    if(ch == 'a')
//	    {
//	      super.reply = a;
//	    }
//	    else if(ch == 'b')
//	    {
//	      super.reply = b;
//	    }
//	    else
//	      super.reply = c;
//	  }
}