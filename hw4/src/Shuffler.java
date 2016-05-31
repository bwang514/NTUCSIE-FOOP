import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import foop.Card;
import foop.Hand;
public class Shuffler {
	ArrayList<Card> Deck = new ArrayList<Card>();
	public Shuffler(){}
	byte i;
	Hand Shuffler_Hand = new Hand(Deck);	
	public void Get_A_Deck(){
		this.Deck.clear();
		for(i = 1;i <= 13;i++){
			Card tmp = new Card((byte)4,(byte)i);
			this.Deck.add(tmp);
			Card tmp1 = new Card((byte)3,(byte)i);		
			this.Deck.add(tmp1);
			Card tmp2 = new Card((byte)2,(byte)i);		
			this.Deck.add(tmp2);
			Card tmp3 = new Card((byte)1,(byte)i);		
			this.Deck.add(tmp3);
		}
	}
	public Card Distribute(){
		RandomIndex rand = new RandomIndex();
		rand.setSize(this.Deck.size());
		Card tmp;
		tmp = this.Deck.get(rand.getNext());
		this.Deck.remove(tmp);
		return tmp;					
	}
}
class RandomIndex{
    //DATA:
    public int[] index;
    public int count = 0;
    public RandomIndex(){}
    
    //ACTIONS:
    public void setSize(int N){
	if (index == null || N != index.length){
	    index = new int[N];
	    initializeIndex();
	    permuteIndex();
	}
    }
    
    public void initializeIndex(){
	for(int i=0;i<index.length;i++)
	    index[i] = i;
    }

    public void permuteIndex(){
	java.util.Random rnd = new java.util.Random();
	for(int i=index.length-1;i>=0;i--){
	    int j = rnd.nextInt(i+1);
	    int tmp = index[j];
	    index[j] = index[i];
	    index[i] = tmp;
	}
    }

    public int getNext(){
	int res = index[count++];
	if (count == index.length){
	    permuteIndex();
	    count = 0;
	}
	return res;
    }
}