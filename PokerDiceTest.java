
/**
 * Write a description of class PokerDiceTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PokerDiceTest
{
    public static void main( String [] args){
        PokerDice game = new PokerDice();
        System.out.println("*Phase 1 Testing");
        
        System.out.println();

        System.out.println("*Testing Score*");
        System.out.println("Score: " + game.getScore());
        
        System.out.println();

        System.out.println("*Testing Rolls*");
        System.out.println("Rolls: " + game.getNumRolls());
        
        System.out.println();

        System.out.println("*Testing Rounds*");
        System.out.println("Rounds: " + game.getNumRounds());
        
        System.out.println();

        System.out.println("*Testing Ok to Roll*");
        if(!game.okToRoll()){
            System.out.print("You can not roll");
        }
        else{
            System.out.print("You can roll");
        }

        System.out.println();  
        System.out.println();

        System.out.println("*Testing Game Over*");
        if(!game.gameOver()){
            System.out.println("Game Over");
        }
        else{
            System.out.println("Not Game Over");
        }

        System.out.println();
        
        System.out.println("*Testing Phase 2*"); 
        
        System.out.println();
        
        System.out.println("*Testing ToString*");
        System.out.println(game.diceToString());

        System.out.println();
        
        System.out.println("*Testing hasStraight*");
        //System.out.println("Straight: " + game.hasStraight(3));

        System.out.println();
        
        System.out.println("*Testing hasStrictPair*");
        //System.out.println("Strict Pair: " + game.hasStrictPair());

        System.out.println();
        
        System.out.println("*Testing hasMuliples*");
        //System.out.println("Muliples: " + game.hasMultiples(2));

        System.out.println();
        
        System.out.println("*Testing Phase 3*");

        System.out.println();
        
        System.out.println("*Testing Three of a Kind*");
        game.checkThreeOfAKind();
        if(game.getScore() == 25){
            System.out.println("THREE_OF_A_KIND");
        }
        else{
            System.out.println("Not a THREE_OF_A_KIND");
        }

        System.out.println();
        
        System.out.println("*Testing Full House*");
        game.checkFullHouse();
        if(game.getScore() == 35){
            System.out.println("FULL_HOUSE");
        }
        else{
            System.out.println("Not a FULL_HOUSE");
        }

        System.out.println();
        
        System.out.println("*Testing Small Straight*");
        game.checkSmallStraight();
        if(game.getScore() == 30){
            System.out.println("SMALL_STRAIGHT");
        }
        else{
            System.out.println("Not a SMALL_STRAIGHT");
        }

        System.out.println();
        
        System.out.println("*Testing Large Straight*");
        game.checkLargeStraight();
        if(game.getScore() == 45){
            System.out.println("LARGE_STRAIGHT");
        }
        else{
            System.out.println("Not a LARGE_STRAIGHT");
        }      
        
        System.out.println();
        
        System.out.println("*Testing Five of a Kind*");
        game.checkFiveOfAKind();
        if(game.getScore() == 50){
            System.out.println("FIVE_OF_A_KIND");
        }
        else{
            System.out.println("Not a FIVE_OF_A_KIND");
        }
        
        System.out.println();
        
        System.out.println("*Testing Four of a Kind*");
        game.checkFourOfAKind();
        if(game.getScore() == 40){
            System.out.println("FOUR_OF_A_KIND");
        }
        else{
            System.out.println("Not a FOUR_OF_A_KIND");
        }
        
        System.out.println();
        
        System.out.println("*Testing checkChance*");
        game.checkChance();
        System.out.println("Score: " + game.getScore());

    }
}
