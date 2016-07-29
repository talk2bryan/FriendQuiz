/**
 * 
 */
package ca.henrybryan.friendquiz.business;

import java.util.ArrayList;

import henrybryan.friendquiz.application.Services;
import henrybryan.friendquiz.objects.Question;
import henrybryan.friendquiz.persistence.DataAccess;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class AccessQuestions {
	private DataAccess dataAccess;
	private ArrayList<Question> questions;
	private Question question;
	private int currentQuestion;
	
	public AccessQuestions() {
		questions = new ArrayList<>();
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
	
	public int fetchMark(Question currQuestion, String response){
		return dataAccess.fetchMark(currQuestion, response);
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
		}
		return question;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

}
