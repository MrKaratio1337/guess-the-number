import kotlin.random.Random

class Game {
    private var numberToGuess = 0
    var numberOfTries = 0

    init{
        resetGame()
    }

    fun resetGame(){
        numberToGuess = Random.nextInt(1, 101)
        numberOfTries = 0
    }

    fun checkGuess(guess: Int): String {
        numberOfTries++;
        return when {
            guess < 1 || guess > 100 -> "Liczba musi być z zakresu od 1 do 100."
            guess < numberToGuess -> "Za mało!"
            guess > numberToGuess -> "Za dużo!"
            else -> "Gratulacje! Odgadłeś liczbę $numberToGuess w $numberOfTries próbach."
        }
    }
}