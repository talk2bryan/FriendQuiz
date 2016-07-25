/**
 * 
 */
package henrybryan.friendquiz.objects;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class MultiChoiceQuestion extends Game {
	  private String a,b,c;
	  
	  public MultiChoiceQuestion(String q, String aa, String bb, String cc, int ans,int p, int f){
		  
	    super(q,p,f);
	    a=aa.toLowerCase();
	    b=bb.toLowerCase();
	    c=cc.toLowerCase();
	    if(ans == 1)
	    {
	      super.answer = a;
	    }
	    else if(ans==2)
	    {
	      super.answer = b;
	    }
	    else
	      super.answer = c;
	  }
	  
	  @Override
	  public String getQstn(){
	    String result = " "+ question + "\n(a) " + a +" (b) "+ b +" (c)" +c;
	    return result;
	  }
	  
	  public void setReply(String str){
	    char ch = str.charAt(0);
	    if(ch == 'a')
	    {
	      super.reply = a;
	    }
	    else if(ch == 'b')
	    {
	      super.reply = b;
	    }
	    else
	      super.reply = c;
	  }
}