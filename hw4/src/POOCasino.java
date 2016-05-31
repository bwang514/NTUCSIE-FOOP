import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import foop.Player;
import foop.Player.BrokeException;
import foop.Player.NegativeException;
import foop.Card;
import foop.Hand;
public class POOCasino {
	static void print_hand(ArrayList<Card> hand){
		int i;
		for(i = 0;i < hand.size();i++){
			System.out.print(hand.get(i).getSuit());
			System.out.print(" ");
			System.out.print(hand.get(i).getValue());
			System.out.print("  ");
		}
		System.out.println(" ");		
	}
	static byte count_point(ArrayList<Card> hand){
		byte point = 0;
		for(int i = 0;i < hand.size();i++){
			if(hand.get(i).getValue() == 1)
				point += 11;
			else if (hand.get(i).getValue() >= 10)
				point += 10;
			else 
				point += hand.get(i).getValue();		
		}
		while(point > 21){
			for(int i = 0;i < hand.size();i++){
				if(hand.get(i).getValue() == 1)
						point -= 10;					
			}	
			if(point > 21) break;
		}
	//	System.out.println("inside count   " + point);
		return point;
	}
	public static void main(String[] args) throws NegativeException, BrokeException {
		// TODO Auto-generated method stub
		int i;
		int init_chips = Integer.parseInt(args[1]);
		int round = Integer.parseInt(args[0]);
		int round_rec = Integer.parseInt(args[0]);
		int total_player = 4;
		boolean[] broke = {false,false,false,false};
		int[] position = new int[4];
		double[] bet = new double[4];
		boolean BlackJack = false;
		byte[] point = {0,0,0,0,0,0,0,0,0};
		boolean initial,soft17 = false;
		ArrayList<Hand> last_table = new ArrayList();
		ArrayList<Hand> current_table = new ArrayList();
		ArrayList<Hand> clone_table = new ArrayList();
		Player[] Player_List = new Player[4]; 
		int[] split_num = new int[4];
		int split_count = 0;
		Card bowl = new Card((byte)1,(byte)1);
		ArrayList<ArrayList<Card>> table = new ArrayList<ArrayList<Card>>(); 
		ArrayList<Player_B02902096> Players = new ArrayList<Player_B02902096>();
		for(i = 0;i < 4;i++){
			position[i] = 0;
		}
		Card tmp = new Card((byte)1,(byte)1);
		for(i = 2;i < 6;i++){
			Class c = null;       
	        try {
	            c = Class.forName(args[i]);           
	            Class[] params = new Class[1];
	            params[0] = Integer.TYPE;
	            Constructor constructor = c.getConstructor(params);
	            
	            Object[] paramObjs = new Object[1];
	            paramObjs[0] = init_chips;
	           	Player_List[i-2] = (Player) constructor.newInstance(paramObjs);
	        } 
	        catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        catch (SecurityException e) {
	            e.printStackTrace();
	        } 
	        catch (NoSuchMethodException e) {
	            e.printStackTrace();
	        } 
	        catch (IllegalArgumentException e) {
	            e.printStackTrace();
	        } 
	        catch (InstantiationException e) {
	            e.printStackTrace();
	        } 
	        catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } 
	        catch (InvocationTargetException e) {
	            e.printStackTrace();
	        }
		}
		/* the first card is open,second is face down,just for the convenience. 
		 * 
		 */
		boolean first_round = true;
		while(round > 0){
			System.out.println("\nround " + (round_rec - round + 1) +" : \n");
			
			split_count = 0;
			boolean[] double_down = {false,false,false,false};
			boolean[] split = {false,false,false,false};
			boolean[] busted = {false,false,false,false,false,false,false,false,false};
			boolean[] insurance = {false,false,false,false};
			boolean[] surrender = {false,false,false,false};
			initial = true;
			soft17 = false;
			Shuffler Dealer = new Shuffler();		
			Dealer.Get_A_Deck();	
			//build last_table and clear the table
			if(!first_round){
				for(i = 0;i < table.size();i++){
				last_table.add(new Hand(table.get(i)));	
				table.get(i).clear();
				}
			}
			for(i = 0;i < 4;i++){
				if(!broke[i])
					System.out.println(args[2+i] + "(Player" + (i+1) + ")'s status:" + Player_List[i] + "");
				else
					System.out.println(args[2+i] + "(Player" + (i+1) + ") is broke");
				//Player_List[i].toString();
			}
			
			//make bet
			for(i = 0;i < 4;i++){
				if(broke[i])
					continue;
				bet[i] = Player_List[i].make_bet(last_table,total_player,position[i]);
				System.out.println("player " + (i+1) + "'s bet = " + bet[i]);
			}			
			//deal 2 card to everyone
			for(i = 0;i < 5;i++){
				if(i != 4 && broke[i])
					continue;
				ArrayList<Card> deck = new ArrayList<Card>();
				table.add(deck);
				bowl = Dealer.Distribute();
				table.get(i).add(bowl);
				current_table.add(new Hand(table.get(i)));
				bowl = Dealer.Distribute();
				table.get(i).add(bowl);
				
				if(i < 4)
					System.out.print("player " + (i+1) + "'s start hand : ");
				else
					System.out.print("Dealer's start hand : ");
				print_hand(table.get(i));
				point[i] = count_point(table.get(i));
				//System.out.println("initial point = " + point[i]);
			}
			//ask for insurance
			if(table.get(4).get(0).getValue() == 1){
				for(i = 0;i < 4;i++){
					if(broke[i])
						continue;
					insurance[i] = Player_List[i].buy_insurance(table.get(i).get(0),table.get(4).get(0),current_table);
					if(insurance[i])
						System.out.println("player " + (i+1) + " buy insurance.");
					else
						System.out.println("player " + (i+1) + " did not buy insurance.");

				}
			}
			//ask for surrender
			if((table.get(4).get(0).getValue() == 1 && table.get(4).get(1).getValue() < 10) || (table.get(4).get(1).getValue() == 1 && table.get(4).get(0).getValue() < 10)){
				for(i = 0;i < 4;i++){
					if(broke[i])
						continue;
					surrender[i] = Player_List[i].do_surrender(table.get(i).get(0),table.get(i).get(0),current_table);
					if(surrender[i]){
						System.out.println("player " + (i+1) + " surrender." );
					}
				}
			}	
			//ask player to show cards and make decision
			for(i = 0;i < 4;i++){
				initial = true;
				if(broke[i])
					continue;
				if(surrender[i] == false){
					if(table.get(i).get(0).getValue() == table.get(i).get(1).getValue())
						split[i] = Player_List[i].do_split(table.get(i), table.get(4).get(0),current_table);
					if(split[i]){
						System.out.println("player " + (i+1) + " split." );
						split_num[i] = 5 + split_count;
						split_count++;
						ArrayList<Card> deck = new ArrayList<Card>();
						table.add(deck);
						table.get(split_num[i]).add(table.get(i).get(1));
						table.get(i).remove(1);	
						//split into two decks							
						double_down[i] = Player_List[i].do_double(current_table.get(i), table.get(4).get(0), current_table);
						if(double_down[i]){
							System.out.println("player " + (i+1) + " double." );
						}
						if(!busted[i]){
							boolean stand = true;
							while(Player_List[i].hit_me(current_table.get(i), table.get(4).get(0), current_table)){
								System.out.println("player " + (i+1) + " hit." );
								bowl = Dealer.Distribute();
								table.get(i).add(bowl);
								point[i] = count_point(table.get(i));
								System.out.println("Player " + (i+1) + "'s first hand :");
								print_hand(table.get(i));
							//	System.out.println("Player " + (i+1) + "'s first point = " + point[i]);
								stand = false;
								if(point[i] > 21){
									busted[i] = true;
									break;
								}
							}
							if(stand){
								point[i] = count_point(table.get(i));
								System.out.println("Player " + (i+1) + "'s first hand");
								print_hand(table.get(i));
						//		System.out.println("Player " + (i+1) + "s first point = " + point[i]);
							}	
							System.out.println("player " + (i+1) + " stand." );
						}		
						if(!busted[split_num[i]]){
							boolean stand = true;
							while(Player_List[i].hit_me(current_table.get(i), table.get(4).get(0), current_table)){
								System.out.println("player " + (i+1) + " hit." );
								bowl = Dealer.Distribute();
								table.get(split_num[i]).add(bowl);
								point[split_num[i]] = count_point(table.get(split_num[i])); 
								System.out.println("Player " + (i+1) + "'s second hand :");
								print_hand(table.get(split_num[i]));
							//	System.out.println("Player " + (i+1) + "'s second point = " + point[split_num[i]]);
								stand = false;
								if(point[split_num[i]] > 21){
									busted[split_num[i]] = true;
									break;
								}
							}
							if(stand){
								point[split_num[i]] = count_point(table.get(split_num[i])); 
								System.out.println("Player " + (i+1) + "'s second hand :");
								print_hand(table.get(split_num[i]));
							//	System.out.println("Player " + (i+1) + "'s second point = " + point[split_num[i]]);
							}	
							System.out.println("player " + (i+1) + " stand." );
						}		
						
					}
					else{
						if(!busted[i]){
							boolean stand = true;
							while(Player_List[i].hit_me(current_table.get(i), table.get(4).get(0), current_table)){
								System.out.println("player " + (i+1) + " hit." );
								bowl = Dealer.Distribute();
								table.get(i).add(bowl);
								point[i] = count_point(table.get(i));
								System.out.println("Player " + (i+1) + "'s hand :");
								print_hand(table.get(i));
							//	System.out.println("Player " + (i+1) + " point = " + point[i]);
								stand = false;
								if(point[i] > 21){
									busted[i] = true;
									System.out.println("player " + (i+1) + " busted." );
									break;
								}
							}
							if(stand){
								System.out.println("Player " + (i+1) + "'s hand :");
								print_hand(table.get(i));
								//System.out.println("Player " + (i+1) + " point = " + point[i]);
							}
							if(point[i] <= 21)
								System.out.println("player " + (i+1) + " stand." );
						}		
					}						
					//update current table
					current_table.clear();
					for(int j = 0;j < table.size();j++)
							current_table.add(new Hand(table.get(i)));		
					
				}//one player end
			}
			//dealer's turn
			while(point[4] <= 17){
				if(point[4] == 17){
					for(int j = 0;j < table.get(4).size();j++)
						if(table.get(4).get(j).getValue() == 1)
							soft17 = true;
					if(!soft17)
						break;
					
				}
				bowl = Dealer.Distribute();
				table.get(4).add(bowl);
				point[4] = count_point(table.get(4)); 
				System.out.println("dealer " + " hit." );
				print_hand(table.get(4));			
			}
			if(point[4] > 21)
				System.out.println("Dealer busted ");
			else
				System.out.println("Dealer stand ");
			for(i = 0; i < 4;i++){
				if(split[i]){
					System.out.println("Player " + (i+1) + " first point = " + point[i]);
					System.out.println("Player " + (i+1) + " second point = " + point[split_num[i]]);
				}
				else
					System.out.println("Player " + (i+1) + " point = " + point[i]);

			}
			System.out.println("dealer point = " + point[4]);
			//Check the result
			//Dealer BJ or not;
			if(point[4] == 21 && table.get(4).size() == 2)
				BlackJack = true;
			
			for(i = 0;i < 4;i++){
				point[i] = count_point(table.get(i)); 
				double earn = 0,lose = 0;
				if(broke[i])
					continue;
				if(double_down[i])
					bet[i] *= 2;
				if(split[i]){ 
					if(surrender[i])
						lose = bet[i] /2 ;
					else if (busted[split_num[i]])
						lose = bet[i];
					else if (point[split_num[i]] == 21 && table.get(split_num[i]).size() == 2){
						if(!BlackJack){								
							earn = bet[i] * (1.5);
						}
					}
					else if (point[4] > 21){
						earn = bet[i];
					}
					else if(BlackJack){
						if(insurance[i])
							lose = bet[i] / 2;
						else
							lose = bet[i];
					}
					else{
						if(point[split_num[i]] > point[4])
							earn = bet[i];
						else if (point[split_num[i]] < point[4])
							lose = bet[i];			
					}
					try{
						Player_List[i].decrease_chips(lose);
					}
					catch(NegativeException e){
						System.out.println("ilegal chips.");
						return;
					}
					catch(BrokeException e){
						broke[i] = true; 
						System.out.println("Player " + i + " is broke.");
					}					
					Player_List[i].increase_chips(earn);
					earn = 0;
					lose = 0;
				}
				if(surrender[i])
					lose = bet[i] /2 ;
				else if (busted[i])
					lose = bet[i];
				else if (point[i] == 21 && table.get(i).size() == 2){
					if(!BlackJack){								
						earn = bet[i] * (1.5);
					}
				}
				else if (point[4] > 21){
					earn = bet[i];
				}
				else if(BlackJack){
					if(insurance[i])
						lose = bet[i] / 2;
					else
						lose = bet[i];
				}
				else{
					if(point[i] > point[4])
						earn = bet[i];
					else if (point[i] < point[4])
						lose = bet[i];			
				}
				try{
					Player_List[i].decrease_chips(lose);
				}
				catch(NegativeException e){
					System.out.println("ilegal chips.");
					return;
				}
				catch(BrokeException e){
					broke[i] = true; 
					System.out.println("Player " + (i+1) + " is broke.");
				}				
				Player_List[i].increase_chips(earn);
				System.out.print(args[i+2] +" (Player" + (i+1) + ")'s status:");
				System.out.println(Player_List[i]);
				//Player_List[i].toString();
			}//end result		
			round--;
			first_round = false;			
			boolean end = true;
			for(i = 0;i < 4;i++){
				if(!broke[i])
					end = false;
			}
			if(end)
				break;
		}
		System.out.println("\nGame over");
			
		
		
	}
	
	
}


//some code for testing

/*for(i = 0;i < 4;i++){
for(int j = 0;j < 1;j++){
	System.out.print(clone_table.get(i).getCards().get(j).getSuit() + " ");
	System.out.println(clone_table.get(i).getCards().get(j).getValue());
}
}

{
						try{
							Player_List[i].decrease_chips(bet[i] / 2);
						}
						catch(NegativeException e){
							System.out.println("ilegal chips.");
							return;
						}
						catch(BrokeException e){
							broke[i] = true; 
						}
					}	*/	
