
/**
 * Write a description of class PokerDice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PokerDice
{
    // instance variables - replace the example below with your own
    private GVdie[] dice;
    private int[] tally;
    private int score;
    private int numRolls;
    private int numRounds;

    private static final int NUM_DICE = 5;
    private final static int FIVE_OF_A_KIND = 50; 
    private final static int FOUR_OF_A_KIND = 40; 
    private final static int THREE_OF_A_KIND = 25; 
    private final static int FULL_HOUSE= 35; 
    private final static int SMALL_STRAIGHT = 30; 
    private final static int LARGE_STRAIGHT = 45; 

    /**
     * Constructor for objects of class PokerDice
     */
    public PokerDice()
    {
        //initialise GVdie Array
        dice = new GVdie[NUM_DICE];
        for( int i = 0; i <= NUM_DICE - 1; i++){
            dice[i] = new GVdie();
        }

        tally = new int[7];
        resetGame();

    }

    public void resetGame(){
        //initalise instance variables
        score = 0;
        numRolls = 0;
        numRounds = 0; 

        for(GVdie d : dice){
            d.setBlank();
            d.setHeld(false);
        }

        for(int num : tally){
            num = 0;
        }
    }

    public int getScore(){
        return score;
    }

    public int getNumRolls(){
        return numRolls;
    }   

    public int getNumRounds(){
        return numRounds;
    }

    public boolean okToRoll(){
        return(numRolls < 3);
    }

    public boolean gameOver(){
        return(numRounds == 7);
    }

    public GVdie[] getDice(){
        return dice;
    }

    public String diceToString(){
        String s = "["; 
        s += dice[0].getValue();
        for(int i = 1; i < dice.length; i++){
            s += "," + dice[i].getValue();
        }
        s += "]";
        return s;
    }

    private void tallyDice(){
        for(int i = 0; i < tally.length; i++){
            tally[i] = 0;
        }

        for (GVdie d : dice){
            tally[d.getValue()] += 1;
        }
    }

    private boolean hasStraight(int length){
        tallyDice();
        int streak = 0;
        boolean hasStraight = false;
        for(int i = 0; i < tally.length; i++){
            if(tally[i] > 0){
                streak++;
                if(streak == length){
                    hasStraight = true;
                }
            }
            else{
                streak = 0;
            }
        }
        return hasStraight;
    }

    private boolean hasMultiples(int count){
        tallyDice();
        boolean hasMultiples = false;
        for(int i = 1; i < tally.length; i++){
            if(tally[i] >= count){
                hasMultiples = true;
            }
        }
        return hasMultiples;
    }

    private boolean hasStrictPair(){
        tallyDice();
        boolean hasStrictPair = false;
        for(int i = 1; i < tally.length; i++){
            if(tally[i] == 2){
                hasStrictPair = true;
            }
        }
        return hasStrictPair;
    }

    private void nextRound(){
        numRolls = 0;
        numRounds++; 

        for(GVdie d : dice){
            d.setBlank();
            d.setHeld(false);
        }

        for(int num : tally){
            num = 0;
        }
    }

    public void setDice(int [] values){
        for( int i = 0; i < values.length; i++){
            if(values[i] < 1 || values[i] > 6){
                values[i] = 1;
            }

            dice[i].roll();
            while(values[i]  != dice[i].getValue()){
                dice[i].roll();
            }
        }
    }
    
    public void rollDice(){
        numRolls++;
        for(GVdie d : dice){
            if(!d.isHeld()){
                d.roll();
            }
        }
    }
    
    public void checkThreeOfAKind(){
        if(hasMultiples(3)){
            score += THREE_OF_A_KIND;
        }
        nextRound();
    }
    
    public void checkFullHouse(){
        if((hasMultiples(3) && hasStrictPair()) 
        || hasMultiples(5)){
            score += FULL_HOUSE;
        }
        nextRound();
    }
    
    public void checkSmallStraight(){
        if(hasStraight(4)){
            score += SMALL_STRAIGHT;
        }
        nextRound();
    }
    
    public void checkLargeStraight(){
        if(hasStraight(5)){
            score += LARGE_STRAIGHT;
        }
        nextRound();
    }
    
    public void checkFiveOfAKind(){
        if(hasMultiples(5)){
            score += FIVE_OF_A_KIND;
        }
        nextRound();
    }
    
    public void checkFourOfAKind(){
        if(hasMultiples(4)){
            score += FOUR_OF_A_KIND;
        }
        nextRound();
    }
    
    public void checkChance(){
        int sum = 0; 
        for(GVdie d : dice){
            sum += d.getValue();
        }
        score += sum;
        nextRound();
    }
}
