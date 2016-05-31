import java.util.Scanner;

public class Computer {
	int round;
	int bet; 
	String input;
	String keep;
	public Computer(){
		this.round = 1;
	}
	public void Asking_bet(){
		System.out.printf("Please enter your P-dollar bet for round %d (1-5 or 0 for quitting the game):",round);
		Scanner scanner = new Scanner(System.in);
		input = scanner.next();
		try{
			bet = Integer.parseInt(input);
		}
		catch(Exception e){
			System.out.println("Please enter a valid bet.");
			this.Asking_bet();
		}			
		//scanner.close();
		if((bet > 5) || (bet < 0)){
			System.out.println("Please enter a valid bet.");
			this.Asking_bet();
		}
	}
	public String Discard_Card(){
		System.out.print("Which cards do you want to keep?"); 
		Scanner scanner = new Scanner(System.in);
		return(scanner.nextLine());		
		
	}
	

}
