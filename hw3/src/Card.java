import static java.util.Comparator.*;

public class Card {
	public String Suits;
	public int rank;

	public Card(String Suits,int rank){
		this.Suits = Suits;
		this.rank = rank;		
	}
	public int GetSuitLevel(){
			int return_object = 0;
			if (this.Suits == "C")
				return_object = 1;
			else if (this.Suits == "D")
				return_object = 2;
			else if (this.Suits == "H")
				return_object = 3;
			else if (this.Suits == "S")
				return_object = 4;
			return return_object;
	}
	public void Print_Card(){
		System.out.print(this.Suits);
		System.out.println(this.rank);
	}
	
}




