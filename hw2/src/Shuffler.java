import java.util.Collections;
import java.util.Vector;

public class Shuffler {
	Vector<Card> Deck = new Vector<Card>();
	Vector<Card> RF = new Vector<Card>();
	public Shuffler(){
	}
	int i;
	public void Make_test_hand(){
		for(i = 0;i < 4;i++){
			Card tmp = new Card("C",i+10);
			this.RF.add(tmp);
		}
		Card tmp = new Card("C",1);
		this.RF.add(tmp);
        Collections.sort(this.RF,new CardComparator());
	}
	public void Get_A_Deck(){
		this.Deck.clear();
		for(i = 1;i <= 13;i++){
			Card tmp = new Card("C",i);
			this.Deck.add(tmp);
			Card tmp1 = new Card("D",i);		
			this.Deck.add(tmp1);
			Card tmp2 = new Card("H",i);		
			this.Deck.add(tmp2);
			Card tmp3 = new Card("S",i);		
			this.Deck.add(tmp3);
		}
	}
	public Vector<Card> Distribute(){
		Vector<Card> fivecard = new Vector<Card>();
		RandomIndex rand = new RandomIndex();
		rand.setSize(this.Deck.size());
		for(i = 0;i < 5;i++)
			fivecard.add(this.Deck.get(rand.getNext()));
		for(i = 0;i < 5;i++)
			this.Deck.remove(fivecard.get(i));
		return fivecard;					
	}
	public Vector<Card> Distribute＿Again(int hand_size){
		Vector<Card> card = new Vector<Card>();
		RandomIndex rand = new RandomIndex();
		rand.setSize(this.Deck.size());
		for(i = 0;i < (5 - hand_size);i++)
			card.add(this.Deck.get(rand.getNext()));
		for(i = 0;i < (5 - hand_size);i++)
			this.Deck.remove(card.get(i));
		return card;					
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