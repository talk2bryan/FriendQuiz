/**
 * 
 */
package business;

import java.util.ArrayList;

import application.Services;
import objects.Question;
import persistence.DataAccessStub;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class AccessQuestions {
	private DataAccessStub dataAccess;
	private ArrayList<Question> questions;
	private Question question;
	private int currentQuestion;
	
	public AccessQuestions() {
		dataAccess = Services.getDataAccess("stub");
		dataAccess.getQuestionSequential(questions);
		question = null;
		currentQuestion = 0;
	}
	
	public String refreshQuestions(){
		questions.clear();
		currentQuestion = 0;
		return dataAccess.getQuestionSequential(questions);
	}

}
