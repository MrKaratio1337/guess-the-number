document.addEventListener('DOMContentLoaded', () => {
    const guessInput = document.getElementById('guessInput');
    const guessButton = document.getElementById('guessButton');

    const result = document.getElementById('result');

    let numberToGuess = Math.floor(Math.random() * 100) + 1;
    let numberOfTries = 0;

    guessButton.addEventListener('click', () => {
        const guess = parseInt(guessInput.value);
        numberOfTries++;

        if(isNaN(guess) || guess < 1 || guess > 100){
            result.textContent = "Liczba musi być z zakresu od 1 do 100.";
        } else if(guess < numberToGuess){
            result.textContent = "Za mało!";
        } else if(guess > numberToGuess){
            result.textContent = "Za dużo!";
        } else{
            result.textContent = `Gratulacje! Odgadłeś liczbę ${numberToGuess} w ${numberOfTries} próbach.`;
            if(confirm("Czy chcesz zagrać ponownie?")){
                resetGame();
            }
        }
    });

    function resetGame(){
        numberToGuess = Math.floor(Math.random() * 100) + 1;
        numberOfTries = 0;
        guessInput.value = '';
        resetGame.textContent = '';
    }
});