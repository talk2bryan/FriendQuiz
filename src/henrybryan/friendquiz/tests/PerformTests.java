package henrybryan.friendquiz.tests;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.swing.JOptionPane;

import henrybryan.friendquiz.objects.Game;
import henrybryan.friendquiz.objects.MultiChoiceQuestion;
import henrybryan.friendquiz.objects.WrittenQuestion;



public class PerformTests {
	static int count = -1;
	
	public static void main(String [] args)throws IOException{
	    boolean test1=true;
	    boolean test2;
	    test2 = checkClass();//writeFile();
	    count = -1;
	    System.out.println("readFile() " + (test1? "passed":"failed")+ " the test");
	    System.out.println("checkClass() " + (test2? "passed":"failed")+ " the test");
	    System.out.println("End of this test");
	  }
	  
	  public static boolean writeFile(String q, String ans){
	    boolean result= false;
	    PrintWriter out;
	    
	    try
	    {
	      //file = new FileWriter(new File("Responses.txt"));
	      out = new PrintWriter(new FileOutputStream(new File("Responses.txt"),true));
	      
	      out.println("Q: "+q);
	      out.println("A: "+ans+"\n");
	      result = true;
	      out.close();
	    }
	    catch(Exception p)
	    {
	      System.out.println(p);
	    }
	    return result;
	  }
	  
	  public static boolean checkClass(){
	    boolean result= false;
	    Game []newGame;
	    double totalScore = 0.0;
	    double maxScore = 112.0;
	    double percent;
	    try
	    {
	      FileReader in;
	      BufferedReader buff;
	      String line;
	      String[]tokens;
	      String qstn,answer;
	      
	      char ch;
	      in = new FileReader("MultiChoiceQuestion.txt");
	      buff = new BufferedReader(in);
	      line = buff.readLine();
	      newGame = new Game[Integer.parseInt(line)];
	      line = buff.readLine();
	      PrintWriter out= new PrintWriter(new FileOutputStream(new File("log.txt")),true);
	      out.println("Here are the list of questions and answers\n\n\n\n");
	      
	      while(line != null)
	      {
	        line = line.trim();
	        tokens = line.split("-");
	        
	        ch = tokens[0].charAt(0);
	        
	        switch(ch)
	        {
	          case 'R': 
	            newGame[++count] = new WrittenQuestion(tokens[1].trim(),tokens[2].trim(),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
	            
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
	            newGame[++count] = new MultiChoiceQuestion(tokens[1].trim(),tokens[2].trim(),tokens[3].trim(),tokens[4].trim(),Integer.parseInt(tokens[5]),Integer.parseInt(tokens[6]),Integer.parseInt(tokens[7]));
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
	      buff.close();
	      out.close();
	      result= true;
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    }
	    if(0<= totalScore)
	      percent = (double)Math.round(((totalScore/maxScore)*100.0)*100)/100;
	    else
	      percent = 0.0;
	    System.out.println(percent);
	    return result;
	  }

}
