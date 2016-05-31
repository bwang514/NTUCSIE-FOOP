import java.util.Scanner;

public class PlayGame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		Player loser;
		int round = 0;
		int result[],i;
		result = new int[4];
		for(i = 0;i < 4;i++)
			result[i] = 0;
		while(true){
			System.out.printf("Well come to Oldmaid Game Center.\nYou have played %d round.\nNow You can choose different variants of Oldmaid.\n",round);
			Scanner scanner = new Scanner(System.in);
			System.out.println("(a) Tradition_Version (Remove any one card,)");
			System.out.println("(b) One-Ghost-Version (Adding one ghost card.)");
			System.out.println("(c) Two-Ghost-Version (Adding two ghost card.)");
			System.out.println("(d) Quit Game.");
			//Scanner scanner = new Scanner(System.in);
			input = scanner.next();
			if(input.charAt(0) == 'a'){
				Tradition_Version a = new Tradition_Version();
				loser = a.Run();
				System.out.printf("----------------\n%s loses.\n",loser.ID);
				result[Integer.parseInt(loser.ID.substring(6))]++;
				System.out.printf("Record :\n");
				for(i = 0;i < 4;i++)
					System.out.printf("Player%d : %d \n",i,result[i]);
				System.out.printf("----------------\n");
				round++;
			}
			else if(input.charAt(0) == 'b'){	
				One_Ghost_Version a = new One_Ghost_Version();
				loser = a.Run();
				System.out.printf("----------------\n%s loses.\n",loser.ID);
				result[Integer.parseInt(loser.ID.substring(6))]++;
				System.out.printf("Record :\n");
				for(i = 0;i < 4;i++)
					System.out.printf("Player%d : %d \n",i,result[i]);
				System.out.printf("----------------\n");
				round++;
			}
			else if(input.charAt(0) == 'c'){
				Two_Ghost_Version a = new Two_Ghost_Version();
				loser = a.Run();
				System.out.printf("----------------\n%s loses.\n",loser.ID);
				result[Integer.parseInt(loser.ID.substring(6))]++;
				System.out.printf("Record :\n");
				for(i = 0;i < 4;i++)
					System.out.printf("Player%d : %d \n",i,result[i]);
				System.out.printf("----------------\n");
				round++;
			}
			else if(input.charAt(0) == 'd'){
				System.out.println("Goodbye");
				break;
			}
			else{
				System.out.println("Please enter a valid option.");
			}
			
		}	
	}

}
