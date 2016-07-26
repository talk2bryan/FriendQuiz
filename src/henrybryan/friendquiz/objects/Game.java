	package henrybryan.friendquiz.objects;

	import java.util.ArrayList;

import henrybryan.friendquiz.business.AccessQuestions;

	/**
	 * @author Bryan Wodi <talk2kamp@gmail.com>
	 *
	 */
	public class Game {
	  protected String question;
	  protected String answer;
	  protected String reply;
	  protected int correct;
	  private int fail;
	  private int currentIndex;
	  private AccessQuestions accessQuestions;
	  private ArrayList<Question> questions;
	  private ArrayList<UserResponse> responses;
	  
	  public Game(String q, int p, int f){
	    question = q;
	    reply = "";
	    answer = "";
	    correct = p;
	    fail = f;
	  }
	  
	  public Game() {
		accessQuestions = new AccessQuestions();
		questions = accessQuestions.getQuestions();
		responses = new ArrayList<>();
		currentIndex = 0;
	}
	  
	  public int calcScore(Question currQuestion, String response){
	    return accessQuestions.fetchMark(currQuestion, response);
	  }
	  
	  
	  
	  /*
	   * everything below is going to be deleted soon
	   */
	  
	  
	  
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