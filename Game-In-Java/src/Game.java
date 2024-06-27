import java.util.Random;

public class Game {

    private int numberToGuess;
    private int numberOfTries;

    public Game(){
        resetGame();
    }

    public void resetGame(){
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        numberOfTries = 0;
    }

    public String checkGuess(int guess){
        numberOfTries++;
        if(guess < 1 || guess > 100){
            return "Liczba musi być z zakresu od 1 do 100.";
        } else if(guess < numberToGuess){
            return "Za mało!";
        } else if(guess > numberToGuess){
            return "Za dużo!";
        } else {
            return "Gratulacje! Odgadłeś liczbę " + numberToGuess + " w " + numberOfTries + " próbach.";
        }
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }
}
