import java.util.ArrayList;
import java.util.Iterator;
/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 7.0
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> listOfLots;
    // The number that will be given to the next lot entered into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        listOfLots = new ArrayList<>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        listOfLots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot aLot : listOfLots) {
            System.out.println(aLot.toString());
        }
    }

    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            //Bid aBid = new Bid(bidder, value);
            //boolean successful = selectedLot.bidFor(aBid);
            //question 2
            boolean successful = selectedLot.bidFor(new Bid(bidder,value));
            if(successful) {
                System.out.println("The bid for lot number " +
                    lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                    " already has a bid of: " +
                    highestBid.getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null if a lot with this 
     * number does not exist.
     * @param lotNumber The number of the lot to return.
     * @return The lot with the given number, or null.
     */
    public Lot getLot(int lotNumber)
    { //question 5 ,og7
        // the impact on the code if you remove a lot you risk getting internal errors 
        //question 6 ,og 8
        for (Lot aLot : listOfLots){
            if(aLot.getNumber()==lotNumber){
                return aLot;

            }
        }
        System.out.println("Lot number: " + lotNumber +
            " does not exist.");
        return null;
    }

    //queston 3
    public void close(){
        for(Lot alot : listOfLots){
            Bid Highest = alot.getHighestBid();
            if (Highest == null){
                System.out.println("no bid for lot number"+ alot.getNumber());

            }
            else{
                System.out.println("Highest bid for lot number"+ alot.getNumber() + "was"+ Highest.getValue());
                System.out.println("bidder was"+ Highest.getBidder().getName());
            }
        }
    }
    //question 4 og 6
    public ArrayList<Lot> getUnsold(){
        ArrayList<Lot>unsold = new ArrayList<>();
        for(Lot alot : listOfLots){
            Bid Highest = alot.getHighestBid();
            if (Highest == null){
                unsold.add(alot);

            }

        }
        return getUnsold();
    }
    public Lot removeLot(int number){
     Iterator<Lot>it = listOfLots.iterator();
     while(it.hasNext()) {
         Lot alot = it.next();
         if (alot.getNumber()==number) 
         {
             
             return alot;
             
         }
         
     }
     return null;
    }  
    
//question 8 ,og 10
}

