/**
 * 
 */
package henrybryan.friendquiz.objects;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class WrittenQuestion extends Game {
	public WrittenQuestion(String q, String ans,int p, int f){
	    super(q,p,f);
	    super.answer = ans.toLowerCase();
	}
}
