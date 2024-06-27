import random

class Game:
    def __init__(self):
        self.reset_game()

    def reset_game(self):
        self.number_to_guess = random.randint(1, 100)
        self.number_of_tries = 0

    def play(self):
        print("Witaj w grze 'Zgadnij liczbę!'")
        print("Mam na myśli liczbę z zakresu od 1 do 100.")

        win = False
        while not win:
            try:
                guess = int(input("Podaj swoją liczbę: "))
                self.number_of_tries += 1
                if guess < 1 or guess > 100:
                    print("Liczba musi być z zakresu od 1 do 100.")
                elif guess < self.number_of_tries:
                    print("Za mało!")
                elif guess > self.number_of_tries:
                    print("Za dużo!")
                else:
                    win = True
            except ValueError:
                print("Proszę wprowadzić poprawną liczbę!")
        print("Gratulacje! Odgadłeś liczbę {self.number_to_guess} w {self.number_of_tries} próbach.")

        play_again = input("Czy chcesz zagrać ponownie? (t/n): ").strip().lower()
        if play_again == 't':
            self.reset_game()
            self.play()

if __name__ == "__main__":
    game = Game()
    game.play()