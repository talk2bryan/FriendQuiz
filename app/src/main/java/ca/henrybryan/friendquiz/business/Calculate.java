/**
 * 
 */
package ca.henrybryan.friendquiz.business;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class Calculate {
	
	public static double claculatePercentage(double totalScore, int maxScore) {
		double percent = 0.0;
		percent = (double)Math.round(((totalScore/maxScore)*100.0)*100)/100;
		return percent;
	}

}
