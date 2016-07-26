/**
 * 
 */
package henrybryan.friendquiz.presentation;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import henrybryan.friendquiz.business.AccessQuestions;
import henrybryan.friendquiz.objects.Game;
import henrybryan.friendquiz.objects.Question;
import henrybryan.friendquiz.objects.UserResponse;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *@date    Jul 26, 20161:37:34 PM
 */
public class SimulateGame {
	private int currentIndex;
	  private AccessQuestions accessQuestions;
	  private ArrayList<Question> questions;
	  private ArrayList<UserResponse> responses;
	  private double totalScore;
	  private double maxScore;
	  private double percent;
	  private String player;
	  private int count;
	 
	public SimulateGame(){
		accessQuestions = new AccessQuestions();
		questions = accessQuestions.getQuestions();
		responses = new ArrayList<>();
		currentIndex = 0;
	}
	public void playGame(){
		for (Question question : questions) {
			JOptionPane.showMessageDialog(null, question.getQuestion());
		}
	}

}
