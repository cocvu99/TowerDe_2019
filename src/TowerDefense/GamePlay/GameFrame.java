//another GameMain
package TowerDefense.GamePlay;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame {

    public static GameFrame gameFrame;
    public static Player player;

    public static final int WINDOW_HEIGHT = 640;
    public static final int WINDOW_WITH   = 1324;
    public static int GAME_LEVEL = 1;

    public enum GameState  {
        INITIALIZING,
        PLAYING,
        PAUSING,
        WINNING,
        LOSING,
        DESTROYING;
    }

    public static GameState gameState;

    public GameFrame() throws HeadlessException, IOException {
        setSize(WINDOW_WITH, WINDOW_HEIGHT);
        setTitle("Tower Defense");
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        player = new Player();
        add(player);

    }

    public static void main(String[] args) throws IOException {
        gameFrame = new GameFrame();
        gameState = GameState.PLAYING;
        gameFrame.setVisible(true);
    }
}