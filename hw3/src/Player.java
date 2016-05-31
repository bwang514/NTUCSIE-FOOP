import java.util.Collections;
import java.util.Vector;
import java.util.*;
class Player {
    String ID;
	Vector<Card> hand = new Vector<Card>();
	public void Sort_hand(){
        Collections.sort(this.hand,new CardComparator());
	}
	public void Print_Hand(){
		int i;
		System.out.print(this.ID);
		System.out.print(": ");
		for(i = 0;i<this.hand.size();i++){
			System.out.print(this.hand.get(i).Suits);
			System.out.print(this.hand.get(i).rank);
			System.out.print(" ");
		}
		System.out.println("");
	}
	public void Check_Pairs(){
		int size = this.hand.size();
		int i;	
		for(i = 0;i < size-1;i++){
			if((this.hand.get(i).rank != 0) && (this.hand.get(i).rank == this.hand.get(i+1).rank) )
			{
				this.hand.remove(i+1);
				this.hand.remove(i);
				i--;
				size -= 2;
			}
		}
	}
	
	
}

