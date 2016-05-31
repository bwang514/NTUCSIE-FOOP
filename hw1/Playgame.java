import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.*;
import java.util.Collections;


public class Playgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Player Judge = new Player();
	int winner = 10;
	int turns = 0;
	int num = 4;
	int i;
	for(i = 1;i <= 13;i++){
		Card tmp = new Card("C",i);
		Judge.hand.add(tmp);
		Card tmp1 = new Card("D",i);		
		Judge.hand.add(tmp1);
		Card tmp2 = new Card("H",i);		
		Judge.hand.add(tmp2);
		Card tmp3 = new Card("S",i);		
		Judge.hand.add(tmp3);
	}	
	Card tmp = new Card("R",0);
	Judge.hand.add(tmp);
	Card tmp1 = new Card("B",0);		
	Judge.hand.add(tmp1);
    Collections.shuffle(Judge.hand);
//	Using to test shuffle.
/*	for(i = 0;i < 52;i++){
		System.out.print(Judge.hand.get(i).Suits);
		System.out.print(Judge.hand.get(i).rank);
		System.out.println( );
	}*/
	Player A = new Player();
	A.ID = "player0";
	Player B = new Player();
	B.ID = "player1";
	Player C = new Player();
	C.ID = "player2";
	Player D = new Player();	
	D.ID = "player3";
	ArrayList<Player> player = new ArrayList<Player>();
	player.add(A);
	player.add(B);	
	player.add(C);
	player.add(D);
	for(i = 0;i < 14;i++){
		player.get(0).hand.add(Judge.hand.get(i));
		player.get(1).hand.add(Judge.hand.get(i+14));	
	}
	for(i = 0;i < 13;i++){
		player.get(2).hand.add(Judge.hand.get(i+28));
		player.get(3).hand.add(Judge.hand.get(i+41));	
	}
		
	player.get(0).Sort_hand();
	player.get(1).Sort_hand();
	player.get(2).Sort_hand();
	player.get(3).Sort_hand();
	System.out.println("Deal Cards");
	player.get(0).Print_Hand();
	player.get(1).Print_Hand();
	player.get(2).Print_Hand();
	player.get(3).Print_Hand();
	System.out.println("Drop cards");
	for(i = 0;i < 4;i++){
		player.get(i).Check_Pairs();
		player.get(i).Print_Hand();
	}	
	System.out.println("Game start");
	
	if((player.get(0).hand.size() == 0) && (player.get(1).hand.size() == 0)){	
		System.out.print(player.get(0).ID);
		System.out.print(" and ");	
		System.out.print(player.get(1).ID);
		System.out.println(" wins");	
	}
	else if((player.get(0).hand.size() == 0) && (player.get(1).hand.size() != 0)){
		System.out.print(player.get(0).ID);
		System.out.println(" wins");	
	}
	else if((player.get(0).hand.size() != 0) && (player.get(1).hand.size() == 0)){
		System.out.print(player.get(1).ID);
		System.out.println(" wins");	
	}

	while((player.get(0).hand.size()!= 0) && (player.get(1).hand.size()!= 0) && (player.get(2).hand.size()!= 0) && (player.get(3).hand.size()!= 0)){
			Collections.shuffle(player.get((turns + 1) % 4).hand);
			tmp = player.get((turns + 1) % 4).hand.get(0);
			System.out.print(player.get(turns % 4).ID);
			System.out.print(" draws a card from ");
			System.out.print(player.get((turns + 1) % 4).ID);
			System.out.print(" ");
			tmp.Print_Card();
			player.get((turns + 1) % 4).hand.remove(0);
			player.get((turns + 1) % 4).Sort_hand();
			player.get(turns % 4).hand.add(tmp);
			player.get(turns % 4).Sort_hand();
			player.get(turns % 4).Check_Pairs();
			player.get(turns % 4).Print_Hand();
			player.get((turns + 1) % 4).Print_Hand();
			if(player.get(turns % num).hand.size() == 0 && player.get((turns + 1) % num).hand.size() == 0){
				if(turns % num < (turns+1) % num){
					System.out.print(player.get(turns % num).ID);
					System.out.print(" and ");	
					System.out.print(player.get((turns+ 1) % num).ID);
					System.out.println(" wins");	
				}
				else{
					System.out.print(player.get((turns+1) % num).ID);
					System.out.print(" and ");	
					System.out.print(player.get(turns % num).ID);
					System.out.println(" wins");	
				}
			}
			else if((player.get(turns % num).hand.size()) == 0 && (player.get((turns + 1) % num).hand.size() != 0)){
				System.out.print(player.get((turns) % num).ID);
				System.out.println(" wins");		
			}	
			else if((player.get(turns % num).hand.size() != 0) && (player.get((turns + 1) % num).hand.size() == 0)){
				System.out.print(player.get((turns + 1) % num).ID);
				System.out.println(" wins");		
			}	
			else
				turns = (turns + 1) % 4;


	}
	for(i = 0;i < player.size();i++){
		if(player.get(i).hand.size() == 0){
			player.remove(i);
			num--;
			turns %= num;
			i--;
		}
	}
	System.out.println("Basic game over");
	System.out.println("Continue");
	while(num > 1){
		Collections.shuffle(player.get((turns + 1) % num).hand);
		tmp = player.get((turns + 1) % num).hand.get(0);
		System.out.print(player.get(turns % num).ID);
		System.out.print(" draws a card from ");
		System.out.print(player.get((turns + 1) % num).ID);
		System.out.print(" ");
		tmp.Print_Card();
		player.get((turns + 1) % num).hand.remove(0);
		player.get((turns + 1) % num).Sort_hand();
		player.get(turns % num).hand.add(tmp);
		player.get(turns % num).Sort_hand();
		player.get(turns % num).Check_Pairs();
		player.get(turns % num).Print_Hand();
		player.get((turns + 1) % num).Print_Hand();
		
		if(player.get(turns % num).hand.size() == 0 && player.get((turns + 1) % num).hand.size() == 0){
			if(turns % num < (turns+1) % num){
				System.out.print(player.get(turns % num).ID);
				System.out.print(" and ");	
				System.out.print(player.get((turns+ 1) % num).ID);
				System.out.println(" wins");	
				player.remove(turns % num);
				num--;
				turns %= num;
				player.remove((turns+1) % num);
				num--;
				turns %= num;
			}
			else {
				System.out.print(player.get((turns + 1) % num).ID);
				System.out.print(" and ");	
				System.out.print(player.get(turns % num).ID);
				System.out.println(" wins");	
				player.remove(turns % num);
				num--;
				turns %= num;
				player.remove((turns+1) % num);
				num--;
				turns %= num;
			}
			
		}
		else if(player.get(turns % num).hand.size() == 0 && player.get((turns + 1) % num).hand.size() != 0){
			System.out.print(player.get(turns % num).ID);
			System.out.println(" wins");	
			player.remove(turns % num);
			num--;
			turns %= num;
		}
		else if(player.get((turns + 1) % num).hand.size() == 0 && player.get(turns % num).hand.size() != 0){
			System.out.print(player.get((turns+ 1) % num).ID);
			System.out.println(" wins");	
			player.remove((turns+1) % num);
			num--;
			turns %= num;
		}
		else 
			turns = (turns + 1) % num;		
}	
	System.out.println("Bonus game over");
}//main


}
