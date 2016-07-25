/**
 * 
 */
package persistence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
import objects.Question;

public class DataAccessStub {
	private ArrayList<Question> questions;
	
	public void open(String dbName){
		Question question;
		
		questions = new ArrayList<>();
		
		question = new Question ("Is Jon Snow a bastard?", "Yes");
		questions.add(question);
		
		question = new Question ("What does he know?", "Nothing");
		questions.add(question);
		
		question = new Question ("Which family are the kings of the North? (a)The Boltons (b)The Lannisters (c)The Starks", "C");
		questions.add(question);
		
		question = new Question ("Who is Aya Stark? (a)A girl has no name (b)No one (c)Aya Stark", "C");
		questions.add(question);
		
		question = new Question ("King Geoffery was not as inhumane as Randy Bolton. True or False?", "True");
		questions.add(question);
		
		System.out.println("opened " + dbName);
	}
	
	public String getQuestionSequential(List<Question> questionResult) {
		questionResult.clear();
		questionResult.addAll(questions);
		return null;
	}
	
	public String  insertQuestion(Question currentQuestion) {
		questions.add(currentQuestion);
		return null;
	}
	
	public String deleteQuestion(Question currentQuestion){
		int index;
		index = questions.indexOf(currentQuestion);
		
		if (index >= 0) {
			questions.remove(index);
		}
		return null;
	}
	
	//assert that question not null
	public Question getCurrentQuestion(Question currQuestion){
		Question question = null;
		
		for (int i = 0; i < questions.size(); i++) {
			
			String query = currQuestion.getQuery();
			String key = currQuestion.getKey();
			
			if (questions.get(i).getQuery().equalsIgnoreCase(query) && questions.get(i).getKey().equalsIgnoreCase(key)) {
				question = questions.get(i);
			}
		}
		return question;
	}
	
	public String getQuery(Question currQuestion) {
        int index;
        String query = null;

        index = questions.indexOf(currQuestion);
        if (index >= 0)
        {
        	query = questions.get(index).getQuery();
        }
        return query;
    }
	
	public String getKey(Question currQuestion) {
        int index;
        String key = null;

        index = questions.indexOf(currQuestion);
        if (index >= 0)
        {
        	key = questions.get(index).getKey();
        }
        return key;
    }
}