import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI {

    private JFrame frame;
    private JTextField guessField;
    private JLabel resultLabel;
    private Game game;

    public GameGUI(){
        game = new Game();
        createAndShowGUI();
    }

    private void createAndShowGUI(){
        // Utworzenie okna głównego
        frame = new JFrame("Zgadnij liczbę");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Utworzenie panelu głównego
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Pole tekstowe do wpisania liczby
        guessField = new JTextField();
        panel.add(new JLabel("Podaj swoją liczbę (1-100)"));
        panel.add(guessField);

        // Przycisk zgadywania
        JButton guessButton = new JButton("Zgadnij!");
        guessButton.addActionListener(new GuessButtonListener());
        panel.add(guessButton);

        // Etykieta wyniku
        resultLabel = new JLabel("Wynik bedzie tutaj.", SwingConstants.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);

        frame.add(panel, BorderLayout.CENTER);

        // Wyświetlanie okna
        frame.setVisible(true);
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                int guess = Integer.parseInt(guessField.getText());
                String result = game.checkGuess(guess);
                resultLabel.setText(result);

                // Sprawdzenie czy gra się zakończyła
                if(result.startsWith("Gratulacje!")){
                    int option = JOptionPane.showConfirmDialog(frame, "Czy chcesz zagrać ponownie?", "Koniec gry", JOptionPane.YES_NO_OPTION);
                    if(option == JOptionPane.YES_OPTION){
                        game.resetGame();
                        resultLabel.setText("Wynik będzie tutaj.");
                        guessField.setText("");
                    } else{
                        System.exit(0);
                    }
                }
            } catch (NumberFormatException ex){
                resultLabel.setText("Proszę wprowadzić poprawną liczbę");
            }
        }
    }
}
