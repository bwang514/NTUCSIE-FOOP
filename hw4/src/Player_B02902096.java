import java.util.ArrayList;

import foop.Card;
import foop.Hand;
import java.util.Random;

public class Player_B02902096 extends foop.Player{
	Hand hand;
	public int order;
	public int bet = 0;
	double original_chips;
	public Player_B02902096(int chips) {
		super(chips);
		original_chips = chips;
	}

	public boolean buy_insurance(Card my_open, Card dealer_open, ArrayList<Hand> current_table) {
		//System.out.println("decide insurance");	
		if(my_open.getValue() == 1){
				 Random ran = new Random();
				 if( ran.nextInt(30) == 0 )  //3.33% chance to buy insurance if player got Ace.
					 return true;
				 else 
					 return false;			
			}
			else{
				Random ran = new Random();
				 if(ran.nextInt(10) > 1 )  //80% chance to buy insurance if player didn't get Ace.
					 return true;
				 else 
					 return false;
			}
	}
	public boolean do_double(Hand my_open, Card dealer_open, java.util.ArrayList<Hand> current_table) {
		return (this.get_chips() > (original_chips / 2));
	}

	public boolean do_split(ArrayList<Card> my_open, Card dealer_open,ArrayList<Hand> current_table) {
		return (my_open.get(0).getValue() == 1);

	}

	public boolean do_surrender(Card my_open, Card dealer_open, ArrayList<Hand> current_table) {

		 Random ran = new Random();
		 if( ran.nextInt(3) == 0 )  
			 return true;
		 else 
			 return false;		
	}

	public boolean hit_me(Hand my_open, Card dealer_open, ArrayList<Hand> current_table)
	{
	//	System.out.println("decide hit");
		 Random ran = new Random();
		 return(ran.nextInt(2) == 0 ) ;
		// TODO Auto-generated method stub
	}
	public int make_bet(ArrayList<Hand> last_table, int total_player, int my_position) {
	//	System.out.println("making bet");
		Random ran = new Random();
		int bet = ran.nextInt((int)this.get_chips()/10 + 1) + 1;
		if(bet > (int)this.get_chips())
			bet = (int)this.get_chips();
		if(bet == 0)
			bet = 1;
		//System.out.println("bet = " + bet);
		return(bet) ;
	}
	public String toString() {
		// TODO Auto-generated method stub
 		return ("" +this.get_chips() + "");
	}
}
