import java.util.Collections;
import java.util.Vector;
import java.util.*;

class Player {
	String[] alpha = {"a","b","c","d","e"};
	Vector<Card> hand = new Vector<Card>();
	Vector<Card> remove = new Vector<Card>();
	private int i;
	private int P_dollar;
	//constuctor
	public Player(){
		this.P_dollar = 1000;
	}
	public void Show_Balance(){
		System.out.printf("You have %d P-dollar now.\n",this.P_dollar);

	}
	public int Get_P_dollar(){
		return this.P_dollar;
	}
	public void New_Balance(int delta_money){
		this.P_dollar += delta_money;
	}
	public void Get_Card(Vector<Card> cards){
		this.hand = cards;
	}
	//sort the cards on hand
	public void Sort_hand(){
        Collections.sort(this.hand,new CardComparator());
	}
	
	//print the cards on hand
	public void Print_Hand(){
		this.Sort_hand();
		for(i = 0;i < 5;i++){
			System.out.printf("(%s) ",alpha[i]);		
			this.hand.get(i).Print_Card();
		}
		System.out.println();
	}	
	public void Discard(String keep){
		System.out.println("Okay. I will discard");
		for(i = 0;i < 5 ; i++)
			if(!keep.contains(alpha[i])){
				System.out.printf("(%s) ",alpha[i]);
				this.hand.get(i).Print_Card();
				remove.add(this.hand.get(i));				
			}	 
		System.out.println();		
		for(i = 0;i < remove.size();i++)
			hand.remove(remove.get(i));		
	}
	public void Get_Card_Again(Vector<Card> card){
		this.hand.addAll(card);
		System.out.print("Your new cards are ");
		this.Sort_hand();
		for(i = 0;i < 5;i++){
			this.hand.get(i).Print_Card();
		}
		System.out.println("");
	}
}

