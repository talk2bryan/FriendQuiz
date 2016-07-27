/**
 * 
 */
package henrybryan.friendquiz.presentation;

import java.util.ArrayList;
import java.util.Scanner;

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
	  private Scanner kbd;
	 
	public SimulateGame(){
		accessQuestions = new AccessQuestions();
		questions = accessQuestions.getQuestions();
		responses = new ArrayList<>();
		currentIndex = 0;
		kbd = new Scanner(System.in);
	}
	public void playGame(){
		String userResponse;
		for (Question question : questions){
			System.out.println(question.getQuestion());
			userResponse = kbd.nextLine();
			//assert that we don't get null here
			validateResponse(userResponse);
			currentIndex++;
		}
	}
	private void validateResponse(String userResponse) {
		Question question = questions.get(currentIndex);
		if (question.getKey().equalsIgnoreCase(userResponse)) {
			System.out.println("You are correct");
		} else {
			System.out.println("uhh! you're wrong");
		}
	}

}
