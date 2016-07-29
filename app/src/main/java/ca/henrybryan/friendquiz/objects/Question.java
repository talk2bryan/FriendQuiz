/**
 * 
 */
package ca.henrybryan.friendquiz.objects;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class Question {
	protected String question;
	private String key;
	private int passMark;
	private int failMark;
	
	public Question(String qq, String kk){
		this.question = qq;
		this.key = kk.toLowerCase();
		this.passMark = 1;
		this.failMark = 0;
	}
	
	public Question (String qq, String kk,int correct){
		this.question = qq;
		this.key = kk.toLowerCase();
		this.passMark = correct;
		this.failMark = 0;
	}
	
	public Question (String qq, String kk,int correct, int wrong){
		this.question = qq;
		this.key = kk.toLowerCase();
		this.passMark = correct;
		this.failMark = wrong;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String query) {
		this.question = query;
	}

	public String getKey() {
		return key;
	}

	public int getPassMark() {
		return passMark;
	}
	
	public int getFailMark() {
		return failMark;
	}
	
	
}
