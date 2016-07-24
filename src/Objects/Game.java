	package objects;
	
	/**
	 * @author Bryan Wodi <talk2kamp@gmail.com>
	 *
	 */
	public class Game {
	  protected String question;
	  protected String answer;
	  protected String reply;
	  protected int correct;
	  protected int fail;
	  
	  public Game(String q, int p, int f){
	    question = q;
	    reply = "";
	    answer = "";
	    correct = p;
	    fail = f;
	  }
	  
	  public int calcScore(){
	    if(checkResponse())
	      return correct;
	    else
	      return (-1*fail);
	  }
	  public String getQstn(){
	    return question;
	  }
	  public boolean checkResponse(){
	    boolean result = false;
	    if(answer.equals(reply))
	    {
	      result =true;
	    }
	    return result;
	  }
	  public void setReply(String r){
	    reply = r.toLowerCase();
	  }
	}