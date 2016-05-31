import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
	@Override
    public int compare(Card a, Card b) {
    	if((a.rank == 0) && (b.rank == 0))
    	{
    		if(a.Suits == "B")
    			return 1;
    		else
    			return -1;
    	}
		if(a.rank>b.rank)
    		return 1;
    	else if (a.rank < b.rank)
    		return -1;
    	else
    	{
    		if(a.GetSuitLevel() > b.GetSuitLevel())
    			return 1;
    		else 
    			return -1;
    	}
    		
    }
}
