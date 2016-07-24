/**
 * 
 */
package objects;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class Trivia2 extends Game {
	public Trivia2(String q, String ans,int p, int f){
	    super(q,p,f);
	    super.answer = ans.toLowerCase();
	}
}
