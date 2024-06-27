import javax.swing.*;

public class Main {

    public static void main(String[] args){
        // Uruchomienie GUi w wątku EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameGUI();
            }
        });
    }
}
