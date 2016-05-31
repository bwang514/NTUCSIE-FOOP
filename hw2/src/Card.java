import static java.util.Comparator.*;
import java.util.Comparator;

public class Card {
	public String Suits;
	public int rank;
	public Card(String Suits,int rank){
		this.Suits = Suits;
		this.rank = rank;		
	}
	public void Print_Card(){
		System.out.print(this.Suits);
		if(this.rank < 11)
			System.out.printf("%d ",this.rank);
		else if(this.rank == 11)
			System.out.print("J ");
		else if(this.rank == 12)
			System.out.print("Q ");
		else if(this.rank == 13)
			System.out.print("K ");
	}
}
class CardComparator implements Comparator<Card> {
	@Override
    public int compare(Card a, Card b) { 	
		if(a.rank>=b.rank)
    		return 1;
    	else 
    		return -1;   			
	}
}





