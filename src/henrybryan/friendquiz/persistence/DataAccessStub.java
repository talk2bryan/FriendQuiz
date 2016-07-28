/**
 * 
 */
package henrybryan.friendquiz.persistence;

import java.util.ArrayList;
import java.util.List;

import henrybryan.friendquiz.objects.Question;

public class DataAccessStub implements DataAccess {
	private ArrayList<Question> questions;
	private String dbName;
	
	public DataAccessStub(String dbName) { this.dbName = dbName; }
	
	/* (non-Javadoc)
	 * @see henrybryan.friendquiz.persistence.DataAccess#open(java.lang.String)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see henrybryan.friendquiz.persistence.DataAccess#getQuestionSequential(java.util.List)
	 */
	@Override
	public String getQuestionSequential(List<Question> questionResult) {
		questionResult.clear();
		questionResult.addAll(questions);
		return null;
	}
	
	/* (non-Javadoc)
	 * @see henrybryan.friendquiz.persistence.DataAccess#insertQuestion(henrybryan.friendquiz.objects.Question)
	 */
	@Override
	public String  insertQuestion(Question currentQuestion) {
		questions.add(currentQuestion);
		return null;
	}
	
	/* (non-Javadoc)
	 * @see henrybryan.friendquiz.persistence.DataAccess#deleteQuestion(henrybryan.friendquiz.objects.Question)
	 */
	@Override
	public String deleteQuestion(Question currentQuestion){
		int index;
		index = questions.indexOf(currentQuestion);
		
		if (index >= 0) {
			questions.remove(index);
		}
		return null;
	}
	
	//assert that question not null
	/* (non-Javadoc)
	 * @see henrybryan.friendquiz.persistence.DataAccess#getCurrentQuestion(henrybryan.friendquiz.objects.Question)
	 */
	@Override
	public Question getCurrentQuestion(Question currQuestion){
		Question question = null;
		
		for (int i = 0; i < questions.size(); i++) {
			
			String query = currQuestion.getQuestion();
			String key = currQuestion.getKey();
			
			if (questions.get(i).getQuestion().equalsIgnoreCase(query) && questions.get(i).getKey().equalsIgnoreCase(key)) {
				question = questions.get(i);
			}
		}
		return question;
	}
	
	/* (non-Javadoc)
	 * @see henrybryan.friendquiz.persistence.DataAccess#getQuery(henrybryan.friendquiz.objects.Question)
	 */
	@Override
	public String getQuery(Question currQuestion) {
        int index;
        String query = null;

        index = questions.indexOf(currQuestion);
        if (index >= 0)
        {
        	query = questions.get(index).getQuestion();
        }
        return query;
    }
	
	/* (non-Javadoc)
	 * @see henrybryan.friendquiz.persistence.DataAccess#getKey(henrybryan.friendquiz.objects.Question)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see henrybryan.friendquiz.persistence.DataAccess#close()
	 */
	@Override
	public void close() {
		System.out.println("Closed " + dbName );
	}

	@Override
	public int fetchMark(Question currQuestion, String response) {
		return  ( (getKey(currQuestion).equalsIgnoreCase(response)) ? currQuestion.getPassMark() : ((-1) * currQuestion.getFailMark()) );
		
	}
}