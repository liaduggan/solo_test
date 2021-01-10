//using Scanner instead of JOptionPane to keep everything in the terminal window
import java.util.Scanner;
//imported util Arrays to print the char array
import java.util.Arrays;

public class WordsGame{
	//move main method to Applet later

	public static void main(String[] args){
		//create array of computer words
		String[] words = {"backup", "bit", "buffer", "bug", "binary", "bus", "cache", "cookie", "compiler", "data", "debug", "desktop", "disk" };
		//create counter
		int counter = 0;
		//user will set limit (how many rounds they want to play)
		int roundsLimit = 5;
		String player1 = "Player1";
		String player2 = "Player2";
		int ptsP1 = 0;
		int ptsP2 = 0;

		 //6 characters for testing
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f','g','h','i','o','u','t','s'};
		//create string of 12 chars from the alphabet as charDis (character display)
        String charDis;
        //create string user input for a guess
        String userGuess;

		//must happen at the start of each round
		int round = roundsLimit-counter;
		System.out.println(round);
		while (counter<roundsLimit){
			System.out.println(round+" rounds remain");
			System.out.println(Arrays.toString(alphabet)+" is the alphabet");
			System.out.println(Arrays.toString(words)+" are the computer words");
			//Create string buffer to randomly append 12 letters from alphabet array
			StringBuffer strBuff=new StringBuffer();
			for(int i=0;i<12;i++){
				strBuff.append(alphabet[(int) (Math.random() * alphabet.length)]);
				strBuff.append(" ");
			 }
			charDis=strBuff.toString();

			System.out.println(charDis+" is the character display for round "+round);


			//something to manage turns

			//take user input using terminal
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a word");
			userGuess = scan.nextLine();
			System.out.println(userGuess+" is the userGuess");
			StringBuffer checkStr=new StringBuffer();
			String newDis=charDis;
			
			if(userGuess.length()<12){
				System.out.println(userGuess.length()+" is the word length");
				checkStr.append("");
				for(int i=0;i<userGuess.length();i++){
					System.out.println(userGuess.charAt(i)+" is now i ");
					System.out.println(checkStr+ " is checkStr");
					//if the checkStr != charDis is to try to replace "newDis" string with the buffer contents only after the first loop
					// if(checkStr.equals(charDis) == true){
					// 	newDis=checkStr.toString();
					// 	System.out.println(checkStr+ " false");
					// }
					for(int j=0;j<newDis.length();j=j+2){
						System.out.println(" j:"+newDis.charAt(j)+" matches "+ userGuess.charAt(i)+"?");
						if(newDis.charAt(j) == userGuess.charAt(i)) {
							checkStr.append('*');
							//checkStr.append(charDis.charAt(charDis.length()-j));
							
							System.out.println(checkStr+ " is checkStr");
						}
						else if (newDis.charAt(j) == '*'){
							checkStr.append('*');
						}
						else if (newDis.charAt(j) != userGuess.charAt(i)){
							checkStr.append(newDis.charAt(j));
							//System.out.println(checkStr+ " is checkStr");
						}
					}
				}
				System.out.println(checkStr+ " is checkStr");

					counter=counter++;

				// for (int i = 0; i < words.length; i++) {
				// 	if (words[i].equalsIgnoreCase(userGuess)) {
				// 		System.out.println(userGuess+" is correct and matches " + words[i]);
				// 		ptsP1 = ptsP1 + userGuess.length();
				// 		System.out.println(player1+" now has "+ ptsP1 + " points");
				// 		break;
				// 	} else {
				// 		System.out.println(userGuess+" is wrong");
				// 		System.out.println(0+" points awarded");
				// 	}
				// counter=counter++;
				// System.out.println("for method ends");
				// }

				
			}
			else{
				System.out.println(userGuess+" is incorrect length");
			}
		}





		System.out.println("while method ends");

	}
}