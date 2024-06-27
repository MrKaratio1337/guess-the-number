#include <iostream>
#include <cstdlib>
#include <ctime>

class Game{
public:
    Game() {
        resetGame();
    }

    void resetGame(){
        srand(static_cast<unsigned int>(time(0)));
        numberToGuess = rand() % 100 + 1;
        numberOfTries = 0;
    }

    void play(){
        int guess = 0;
        bool win = false;

        std::cout << "Witaj w grze 'Zgadnij liczbę'!\n";
        std::cout << "Mam na myśli liczbę z zakresu od 1 do 100!\n"
        
        while(!win){
            std::cout << "Podaj swoją liczbę: ";
            std::cin >> guess;
            numberOfTries++;

            if(guess < 1 || guess > 100){
                std::cout << "Liczba musi być z zakresu od 1 do 100.\n";
            } else if(guess < numberToGuess){
                std::cout << "Za mało!\n";
            } else if(guess > numberToGuess){
                std::cout << "Za dużo!\n";
            } else {
                win = true;
            }
        }

        std::cout << "Gratulacje! Odgadłeś liczbę" << numberToGuess << " w " << numberOfTries << " próbach.\n";

        char choice;
        std::cout << "Czy chcesz zagrać ponownie? (t/n): ";
        std::cin >> choice;
        if(choice == 't' || choice == 'T'){
            resetGame();
            play();
        }
    }
private:
    int numberToGuess;
    int numberOfTries;
}

int main(){
    Game game;
    game.play();
    return 0;
}