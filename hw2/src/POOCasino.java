import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class POOCasino {

	public static void main(String[] args) {
		//Let's play a game.
		int i;
		Vector<Card> RF = new Vector<Card>();
        Collections.sort(RF,new CardComparator());
		String player_name;
		Computer computer = new Computer();
		Shuffler shuffler = new Shuffler();
		shuffler.Get_A_Deck();
		System.out.println("POOCasino Jacks or better, written by b02902096 OOP is OP.");
		System.out.print("Please enter your name: ");
		Scanner scanner = new Scanner(System.in);
		player_name = scanner.next();
		System.out.printf("Welcome, %s\n",player_name);
		Player player = new Player();
		while(player.Get_P_dollar() > 0){
			player.Show_Balance();
			computer.Asking_bet();
			if(computer.bet == 0)
				break;
			player.New_Balance(0 - computer.bet);
			player.Get_Card(shuffler.Distribute());						
			player.Print_Hand();
			player.Discard((computer.Discard_Card()));
			player.Get_Card_Again(shuffler.Distribute＿Again(player.hand.size()));
			Judge judge = new Judge(player.hand);
			player.New_Balance(judge.Check_Combination(computer.bet));
			computer.round++;
		//initialize again
			shuffler.Get_A_Deck();		
		}	
		System.out.printf("Good bye, %s. You played for %d round and have %d P-dollars now.",player_name,computer.round,player.Get_P_dollar());
		scanner.close();			
	}

}
