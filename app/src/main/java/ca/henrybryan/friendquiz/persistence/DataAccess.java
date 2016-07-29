package ca.henrybryan.friendquiz.persistence;

import java.util.List;

import ca.henrybryan.friendquiz.objects.Question;

public interface DataAccess {

	void open(String dbName);

	String getQuestionSequential(List<Question> questionResult);

	String insertQuestion(Question currentQuestion);

	String deleteQuestion(Question currentQuestion);

	//assert that question not null
	Question getCurrentQuestion(Question currQuestion);

	String getQuery(Question currQuestion);

	String getKey(Question currQuestion);
	
	int fetchMark(Question currQuestion, String response);

	void close();

}