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
	
	public Question(String qq, String kk){
		this.query = qq;
		this.key = kk;
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
}
