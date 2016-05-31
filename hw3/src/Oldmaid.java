import java.util.ArrayList;
import java.util.Collections;
class One_Ghost_Version extends Oldmaid{
	public One_Ghost_Version(){
		super();
	}
	public static ArrayList<Player> Distribute (Player Judge ){
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
	    Collections.shuffle(Judge.hand);
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
		for(i = 0;i < 14;i++)
			player.get(0).hand.add(Judge.hand.get(i));	
		for(i = 0;i < 13;i++){
			player.get(1).hand.add(Judge.hand.get(i+14));
			player.get(2).hand.add(Judge.hand.get(i+27));
			player.get(3).hand.add(Judge.hand.get(i+40));	
		}

		return player;
	}
	public Player Run(){
		Player Judge = new Player();
		int winner = 10;
		int turns = 0;
		int num = 4;
		int info[];
		int i;
		ArrayList<Player> player = new ArrayList<Player>();
		player = Distribute(Judge);
		Sort_Game(player);
		player.get(3).Sort_hand();
		System.out.println("Deal Cards");
		Print_Game(player);
		System.out.println("Drop cards");
		Check_Pairs_Game(player);
		Print_Game(player);
		System.out.println("Game start");
		info = new int[2];
		info[0] = num;
		info[1] = turns;
		Basic_Game_Flow(player,info);
		num = info[0];
		turns = info[1];
		System.out.println("Basic game over");
		System.out.println("Continue");
		Bonus_Game_Flow(player,info);
		return player.get(0);
	}
}
class Two_Ghost_Version extends Oldmaid{
	public Two_Ghost_Version(){
		super();
	}
	public static ArrayList<Player> Distribute (Player Judge ){
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

		return player;
	}
	public Player Run(){
		Player Judge = new Player();
		int winner = 10;
		int turns = 0;
		int num = 4;
		int info[];
		int i;
		ArrayList<Player> player = new ArrayList<Player>();
		player = Distribute(Judge);
		Sort_Game(player);
		player.get(3).Sort_hand();
		System.out.println("Deal Cards");
		Print_Game(player);
		System.out.println("Drop cards");
		Check_Pairs_Game(player);
		Print_Game(player);
		System.out.println("Game start");
		info = new int[2];
		info[0] = num;
		info[1] = turns;
		Basic_Game_Flow(player,info);
		num = info[0];
		turns = info[1];
		System.out.println("Basic game over");
		System.out.println("Continue");
		Bonus_Game_Flow(player,info);
		return player.get(0);
	}
}
class Tradition_Version extends Oldmaid{
	public Tradition_Version(){
		super();
	}
	public static ArrayList<Player> Distribute (Player Judge ){
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
	    Collections.shuffle(Judge.hand);
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
		for(i = 0;i < 13;i++){
			player.get(0).hand.add(Judge.hand.get(i));
			player.get(1).hand.add(Judge.hand.get(i+13));
			player.get(2).hand.add(Judge.hand.get(i+26));
		}
		for(i = 0;i < 12;i++)
			player.get(3).hand.add(Judge.hand.get(i+39));	
		return player;
	}
	public Player Run(){
		Player Judge = new Player();
		int winner = 10;
		int turns = 0;
		int num = 4;
		int info[];
		int i;
		ArrayList<Player> player = new ArrayList<Player>();
		player = Distribute(Judge);
		Sort_Game(player);
		player.get(3).Sort_hand();
		System.out.println("Deal Cards");
		Print_Game(player);
		System.out.println("Drop cards");
		Check_Pairs_Game(player);
		Print_Game(player);
		System.out.println("Game start");
		info = new int[2];
		info[0] = num;
		info[1] = turns;
		Basic_Game_Flow(player,info);
		num = info[0];
		turns = info[1];
		System.out.println("Basic game over");
		System.out.println("Continue");
		Bonus_Game_Flow(player,info);
		return player.get(0);
	}
}

public class Oldmaid {
	public  Oldmaid() {}
	public void Bonus_Game_Flow(ArrayList<Player> player,int info[]){
		int num = info[0];
		int turns = info[1];
		while(num > 1){
			Draw_Card(player.get(turns % num),player.get((turns + 1) % num));
			if(player.get(turns % num).hand.size() == 0 && player.get((turns + 1) % num).hand.size() == 0){
				if(turns % num < (turns+1) % num){
					Double_Win(player.get(turns % num),player.get((turns+1) % num));
					info = Remove_Winner(player,info);
					num = info[0];
					turns = info[1];
				}
				else {
					Double_Win(player.get((turns + 1) % num),player.get((turns) % num));
					info = Remove_Winner(player,info);
					num = info[0];
					turns = info[1];
				}
				
			}
			else if(player.get(turns % num).hand.size() == 0 && player.get((turns + 1) % num).hand.size() != 0){
				Single_Win(player.get((turns) % num));
				info = Remove_Winner(player,info);
				num = info[0];
				turns = info[1];
			
			}
			else if(player.get((turns + 1) % num).hand.size() == 0 && player.get(turns % num).hand.size() != 0){
				Single_Win(player.get((turns + 1) % num));
				info = Remove_Winner(player,info);
				num = info[0];
				turns = info[1];
			}
			else 
				turns = (turns + 1) % num;		
		}
		System.out.println("Bonus game over");
		
	}
	public void Basic_Game_Flow(ArrayList<Player> player,int info[]){
		int num = info[0];
		int turns = info[1];
		if((player.get(0).hand.size() == 0) && (player.get(1).hand.size() == 0))
			Double_Win(player.get(0),player.get(1));
		else if((player.get(0).hand.size() == 0) && (player.get(1).hand.size() != 0))
			Single_Win(player.get(0));
		else if((player.get(0).hand.size() != 0) && (player.get(1).hand.size() == 0))
			Single_Win(player.get(1));
		
		while((player.get(0).hand.size()!= 0) && (player.get(1).hand.size()!= 0) && (player.get(2).hand.size()!= 0) && (player.get(3).hand.size()!= 0)){
				Draw_Card(player.get(turns % 4),player.get((turns + 1) % 4));
				if(player.get(turns % num).hand.size() == 0 && player.get((turns + 1) % num).hand.size() == 0){
					if(turns % num < (turns+1) % num)
						Double_Win(player.get(turns % num),player.get((turns+1) % num));
					else
						Double_Win(player.get( (turns+1) % num),player.get(turns % num));
				}
				else if((player.get(turns % num).hand.size()) == 0 && (player.get((turns + 1) % num).hand.size() != 0))
					Single_Win(player.get((turns) % num));	
				else if((player.get(turns % num).hand.size() != 0) && (player.get((turns + 1) % num).hand.size() == 0))
					Single_Win(player.get((turns+1) % num));
				else
					turns = (turns + 1) % 4;
		}
		info = Remove_Winner(player,info);
	}	
	public static int[] Remove_Winner(ArrayList<Player> player,int info[]){
		int i;
		for(i = 0;i < player.size();i++){
			if(player.get(i).hand.size() == 0){
				player.remove(i);
				info[0]--;
				info[1] %= info[0];
				i--;
			}
		}	
		return info;
	}
	public static void Draw_Card(Player draw,Player drawed){
		Card tmp;
		Collections.shuffle(drawed.hand);
		tmp = drawed.hand.get(0);
		if(tmp.Suits == "R")
			return;
		System.out.print(draw.ID);
		System.out.print(" draws a card from ");
		System.out.print(drawed.ID);
		System.out.print(" ");
		tmp.Print_Card();
		drawed.hand.remove(0);
		drawed.Sort_hand();
		draw.hand.add(tmp);
		draw.Sort_hand();
		draw.Check_Pairs();
		draw.Print_Hand();
		drawed.Print_Hand();
		
	}
	public static void Single_Win(Player winner){
		System.out.print(winner.ID);
		System.out.println(" wins");
	}
	public static void Double_Win(Player winner1,Player winner2){
		System.out.print(winner1.ID);
		System.out.print(" and ");	
		System.out.print(winner2.ID);
		System.out.println(" wins");	
	}
	public static void Check_Pairs_Game(ArrayList<Player> list){
		int i;
		for(i = 0;i < list.size();i++)
			list.get(i).Check_Pairs();
	};
	public static void Sort_Game(ArrayList<Player> list){
		int i;
		for(i = 0;i < list.size();i++)
			list.get(i).Sort_hand();
	};
	public static void Print_Game(ArrayList<Player> list){
		int i;
		for(i = 0;i < list.size();i++)
			list.get(i).Print_Hand();
	};
}
