import java.util.Vector;

public class Judge {
	Vector<Card> hand = new Vector<Card>();
	public Judge(Vector<Card> Check){
		this.hand = Check;
	}
	public int Check_Combination(int bet){
		int zero = 0;
		//Royal flush
		if(Is_Straight(this.hand) && Is_Flush(this.hand) && (this.hand.get(4).rank == 13)){
			if(bet < 5){
				System.out.printf("You get a royal flush hand. The payoff is %d\n" ,bet * 250);
				return(bet * 250);
			}
			else{
				System.out.println("You get a royal flush hand. The payoff is 4000");
				return 4000;
			}
		}
		//Straight flush
		else if(Is_Straight(this.hand) && Is_Flush(this.hand)){
			System.out.printf("You get a straight flush hand. The payoff is %d\n" ,bet * 50);
			return (bet * 50);
		}
		//Four of a kind
		else if((Check_Pairs(this.hand) == 3) && (this.hand.get(1).rank == this.hand.get(3).rank)){
			System.out.printf("You get a four of a kind hand. The payoff is %d\n" ,bet * 25);
			return(bet * 25);
		}
		//Full house
		else if((Check_Pairs(this.hand) == 3) && (Check_Three_Kind(this.hand) == 1)){
			System.out.printf("You get a full house hand.The payoff is %d\n" ,bet * 9);
			return(bet * 9);
		}
		//Flush
		else if (Is_Flush(this.hand)){
			System.out.printf("You get a flush hand. The payoff is %d\n" ,bet * 6);
			return (bet * 6);
		}	
		//Straight
		else if (Is_Straight(this.hand)){
			System.out.printf("You get a straight hand. The payoff is %d\n" ,bet * 4);
			return (bet * 4);
		}
		//Three of Kind
		else if(Check_Three_Kind(this.hand) == 1){
			System.out.printf("You get a three of a kind hand. The payoff is %d\n" ,bet * 3);
			
			return (bet * 3);
		}
		//Two Pair
		else if(Check_Pairs(this.hand) == 2){
			System.out.printf("You get a two pair hand. The payoff is %d\n" ,bet * 2);
			return (bet * 2);
		}
		//JOB
		else if(Jack_Or_Better(this.hand)){
			System.out.printf("You get a jack or better hand. The payoff is %d\n" ,bet);
			return (bet);
		}
		//GG	
		else{
			System.out.println("The payoff is 0");
			return (0);
		}
	}
	public boolean Is_Straight(Vector<Card> Check){ 
		boolean straight = true;
		if((Check.get(0).rank < 10) && (Check.get(0).rank > 1))
		{	
			for(int i = 0 ;i < 4 ; i++){
				if(Check.get(i+1).rank != Check.get(i).rank + 1)
					straight = false;
			}
			return straight;
		}
		
		else if(Check.get(0).rank == 1){
				if(Check.get(4).rank == 5){
					for(int i = 0 ;i < 4 ; i++){
						if(Check.get(i+1).rank != Check.get(i).rank + 1)
							straight = false;
					}
					return straight;
				}
				else if(Check.get(4).rank == 13){
					for(int i = 1 ;i < 4 ; i++){
						if(Check.get(i+1).rank != Check.get(i).rank + 1)
							straight = false;	
					}
					return straight;
				}
				else 
					return false; 
		}
		else
			return false;
	}	
	public boolean Is_Flush(Vector<Card> Check){
		boolean flush = true;
		for(int i = 0 ; i < 4 ; i++){
			if(Check.get(i+1).Suits != Check.get(i).Suits)
				flush = false;
		}
		return flush;
	}
	public int Check_Pairs(Vector<Card> Check){
		int Pair_Count = 0;
		for(int i = 0;i < 4;i++){
			if(Check.get(i+1).rank == Check.get(i).rank)
				Pair_Count++;
		}
		return Pair_Count;	
	}
	public int Check_Three_Kind(Vector<Card> Check){
		int Three_Count = 0;
		for(int i = 0;i < 3;i++){
			if((Check.get(i+1).rank == Check.get(i).rank) && (Check.get(i+2).rank == Check.get(i).rank))
				Three_Count++;
		}
		return Three_Count;
	}
	public boolean Jack_Or_Better(Vector<Card> Check){
		int rank = 0;
		for(int i = 0;i < 4;i++){
			if(Check.get(i+1).rank == Check.get(i).rank)
			rank = Check.get(i).rank;	
		}
		if((rank > 10) || (rank == 1)){
			return true;
		}
		else 
			return false;
	}
}
