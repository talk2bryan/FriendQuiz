/**
 * 
 */
package henrybryan.friendquiz.presentation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

import henrybryan.friendquiz.business.AccessQuestions;
import henrybryan.friendquiz.business.Calculate;
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
	  private int maxScore;
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
		totalScore = 0.0;
		percent = 0.0;
		setMaxScore();
	}
	
	private void setMaxScore() {
		maxScore = 0;
		for (Question question : questions) {
			maxScore += question.getPassMark();
		}
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
		displaySummary();
	}
	
	private void displaySummary() {
		percent = getPercentage();
		
		System.out.println("\n***************RESULT***************\n");
		System.out.println("Your score is: "+ totalScore+" out of "+maxScore+"\n");
		System.out.println("In terms of percentage, you have scored : "+ percent+"%\n");
		System.out.println(""+((percent<=70)? "You are a bad friend "+player+" :(":"You are a good friend "+player+" :)"));
		
		System. out.println("\n\nQuestions were designed and edited by Aleli(80%) and Bryan(20%)\n");
		System.out.println("Programmed by Bryan Wodi, Mar 9, 2015. For Alyssa, for being such a good friend\n");
		System.out.println("We all love you Alyssa\n");
		System.out.println("Courtesy: Aleli & Bryan, on behalf of Walter, Richard, Tobi, Joshua and Nguvan\n");
		System.out.println("\n\nLong live our friendship\n");
		System.out.println("\n\n***************THE END****************\n");
		
		//JOptionPane.showMessageDialog(null,"Check out your tanscripts in \"log.txt\" located in this parent directory");
		
	}

	private double getPercentage() {
		
		return Calculate.claculatePercentage(totalScore, maxScore);
	}

	private void validateResponse(String userResponse) {
		Question question = questions.get(currentIndex);
		UserResponse response = new UserResponse(userResponse);
		responses.add(currentIndex, response);
		
		if (question.getKey().equalsIgnoreCase(userResponse)) {
			updateScore(question,true);
			System.out.println("You are correct");
		} else {
			updateScore(question, false);
			System.out.println("uhh! you're wrong");
		}
	}

	private void updateScore(Question question, boolean b) {
		if (b) {
			totalScore += question.getPassMark();
		}else {
			totalScore += question.getFailMark();
		}
		
	}

}
