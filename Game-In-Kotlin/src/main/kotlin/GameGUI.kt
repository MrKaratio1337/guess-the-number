import java.awt.BorderLayout
import java.awt.GridLayout
import javax.swing.*

class GameGUI {
    private val frame: JFrame = JFrame("Zgadnij liczbę")
    private val guessField: JTextField = JTextField()
    private val resultLabel: JLabel = JLabel("Wynik będzie tutaj.", SwingConstants.CENTER)
    private val game: Game = Game()

    init{
        createAndShowGUI()
    }

    private fun createAndShowGUI(){
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.setSize(400, 200)
        frame.layout = BorderLayout()

        val panel = JPanel()
        panel.layout = GridLayout(3, 1)

        panel.add(JLabel("Podaj swoją liczbę (1-100):"))
        panel.add(guessField)

        val guessButton = JButton("Zgadnij")
        guessButton.addActionListener{
            try{
                val guess = guessField.text.toInt()
                val result = game.checkGuess(guess)
                resultLabel.text = result

                if(result.startsWith("Gratulacje!")){
                    val option = JOptionPane.showConfirmDialog(frame, "Czy chcesz zagrać ponownie?", "Koniec Gry", JOptionPane.YES_OPTION)
                    if(option == JOptionPane.YES_OPTION){
                        game.resetGame()
                        resultLabel.text = "Wynik będzie tutaj."
                        guessField.text = ""
                    } else{
                        System.exit(0)
                    }
                }
            } catch (ex: NumberFormatException){
                resultLabel.text = "Proszę wprowadzić poprawną liczbę"
            }
        }

        panel.add(guessButton)

        frame.add(panel, BorderLayout.CENTER)
        frame.add(resultLabel, BorderLayout.SOUTH)

        frame.isVisible = true
    }
}