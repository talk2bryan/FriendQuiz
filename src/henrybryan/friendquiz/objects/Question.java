/**
 * 
 */
package henrybryan.friendquiz.objects;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class Question {
	private String query;
	private String key;
	private int passMark;
	private int failMark;
	
	public Question(String qq, String kk){
		this.query = qq;
		this.key = kk;
		this.passMark = 1;
		this.failMark = 0;
	}
	
	public Question (String qq, String kk,int correct){
		this.query = qq;
		this.key = kk;
		this.passMark = correct;
		this.failMark = 0;
	}
	
	public Question (String qq, String kk,int correct, int wrong){
		this.query = qq;
		this.key = kk;
		this.passMark = correct;
		this.failMark = wrong;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
	public int getPassMark() {
		return passMark;
	}
	
	public int getFailMark() {
		return failMark;
	}
	
	
}
