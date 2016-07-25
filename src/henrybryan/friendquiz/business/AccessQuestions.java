/**
 * 
 */
package henrybryan.friendquiz.business;

import java.util.ArrayList;

import henrybryan.friendquiz.application.Services;
import henrybryan.friendquiz.persistence.DataAccessStub;
import henrybryan.friendquiz.objects.Question;

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
	
	public String deleteQuestion(Question currQuestion) {
		String result;
		result = dataAccess.deleteQuestion(currQuestion);
		refreshQuestions();
		return result;
	}
	
	public String insertQuestion(Question currQuestion){
		String result = dataAccess.insertQuestion(currQuestion);
		refreshQuestions();
		return result;
	}
	
	public Question getSequential(){
		if (questions == null) {
			questions = new ArrayList<>();
			dataAccess.getQuestionSequential(questions);
			currentQuestion = 0;
		}
		else if (currentQuestion < questions.size()) {
			question = questions.get(currentQuestion);
			currentQuestion++;
		}
		else {
			refreshQuestions();
			question = null;
			currentQuestion = 0;
		}
		return question;
	}

}