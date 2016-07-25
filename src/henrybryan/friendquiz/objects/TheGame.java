/**
 * 
 */
package henrybryan.friendquiz.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class TheGame {
	private double totalScore;
	private double maxScore;
	private double percent;
	private String player;
	private int count;
	
	public TheGame(){
		totalScore = 0.0;
	    maxScore = 41.0;
	    percent = 0.0;
	    count = -1;
	    player="";
	}
	
	public void play(){
	    Game []newGame;
	    
	    try
	    {
	      FileReader in;
	      BufferedReader buff;
	      String line;
	      String[]tokens;
	      String qstn,answer,result="";
	      char ch;
	      
	      in = new FileReader("Trivia.txt");
	      buff = new BufferedReader(in);
	      line = buff.readLine();
	      newGame = new Game[Integer.parseInt(line)];
	      line = buff.readLine();
	      PrintWriter out= new PrintWriter(new FileOutputStream(new File("log.txt")),true);
	      player = JOptionPane.showInputDialog(null,"Who is playing?");
	      out.println("Here are the list of "+player+"'s questions and answers\n\n\n");
	      
	      JOptionPane.showMessageDialog(null,"Welcome "+player+", shall we?");
	      while(line != null&&line!="")
	      {
	        line = line.trim();
	        tokens = line.split("-");
	        
	        ch = tokens[0].charAt(0);
	        
	        switch(ch)
	        {
	          case 'R': 
	            newGame[++count] = new Trivia2(tokens[1].trim(),tokens[2].trim(),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
	            qstn = newGame[count].getQstn();
	            out.println("Q: "+qstn);
	            answer = JOptionPane.showInputDialog(null,qstn);
	            out.println("A: "+answer+"\n");
	            newGame[count].setReply(answer.trim());
	            String str=""+((newGame[count].checkResponse())? "CORRECT":"uhh! you're wrong");
	            totalScore+=newGame[count].calcScore();
	            JOptionPane.showMessageDialog(null,str);
	          break;
	          case 'C':
	            newGame[++count] = new Trivia(tokens[1].trim(),tokens[2].trim(),tokens[3].trim(),tokens[4].trim(),Integer.parseInt(tokens[5]),Integer.parseInt(tokens[6]),Integer.parseInt(tokens[7]));
	            qstn = newGame[count].getQstn();
	            out.println("Q: "+qstn);
	            answer = JOptionPane.showInputDialog(null,qstn);
	            out.println("A: "+answer+"\n");
	            newGame[count].setReply(answer.trim());
	            String str2=""+((newGame[count].checkResponse())? "CORRECT":"uhh! you're wrong");
	            totalScore+=newGame[count].calcScore();
	            JOptionPane.showMessageDialog(null,str2);
	            break;
	        }
	        line = buff.readLine();
	      }
	      if(0<= totalScore)
	        percent = (double)Math.round(((totalScore/maxScore)*100.0)*100)/100;
	      else
	        percent = 0.0;
	      out.println("\n***************RESULT***************\n");
	      out.println("Your score is: "+ totalScore+" out of "+maxScore+"\n");
	      out.println("In terms of percentage, you have scored : "+ percent+"%\n");
	      out.println(""+((percent<=70)? "You are a bad friend "+player+" :(":"You are a good friend "+player+" :)"));
	      result = ("\n***************RESULT***************\n"+"Your score is: "+ totalScore+" out of "+maxScore+"\n"
	        +"In terms of percentage, you have scored : "+ percent+"%\n"
	        +""+((percent<=70)? "You are a bad friend "+player+" :(":"You are a good friend "+player+" :)") );
	      out.println("\n\nQuestions were designed and edited by Aleli(80%) and Bryan(20%)\n");
	      out.println("Programmed by Bryan Wodi, Mar 9, 2015. For Alyssa, for being such a good friend\n");
	      out.println("We all love you Alyssa\n");
	      out.println("Courtesy: Aleli & Bryan, on behalf of Walter, Richard, Tobi, Joshua and Nguvan\n");
	      out.println("\n\nLong live our friendship\n");
	      out.println("\n\n***************THE END****************\n");
	      buff.close();
	      out.close();
	      JOptionPane.showMessageDialog(null,result);
	      JOptionPane.showMessageDialog(null,"Check out your tanscripts in \"log.txt\" located in this parent directory");
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    }
	  }
}
