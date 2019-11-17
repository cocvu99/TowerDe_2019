//another GameMain
package TowerDefense.GamePlay;

import TowerDefense.GameEnitty.Map.MapManager;
import TowerDefense.GameEnitty.Tower.AdvanceTower;
import TowerDefense.GameEnitty.Tower.BasicTower;
import TowerDefense.GameEnitty.Tower.KnightTrap;
import TowerDefense.GameEnitty.Tower.Tower;
import TowerDefense.GameEnitty.Map.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class GameFrame extends JFrame implements MouseListener {

    public static GameFrame gameFrame;
    public static Player player;

    public static final int WINDOW_HEIGHT = 640;
    public static final int WINDOW_WITH   = 1324;
    public static int GAME_LEVEL = 1;

    public static Tower hodingTower;

    public static Rectangle2D.Double basicTowerArea = new Rectangle2D.Double(1060,225,64,64);
    public static Rectangle2D.Double advanceTowerArea = new Rectangle2D.Double(1060,225+64+5,64,64);
    public static Rectangle2D.Double knightTrapTowerArea = new Rectangle2D.Double(1060,245+128,64,64);


    public static Rectangle2D.Double RestartButton
            = new Rectangle2D.Double(GameFrame.WINDOW_WITH/2 + 256,
            GameFrame.WINDOW_HEIGHT/2, 128, 64);

    public static Rectangle2D.Double quitButton
            = new Rectangle2D.Double(GameFrame.WINDOW_WITH/2 - 256 - 100,
            GameFrame.WINDOW_HEIGHT/2, 128, 64);

    @Override
    public void mouseClicked(MouseEvent e) {
        if (gameState == GameState.LOSING || gameState == GameState.WINNING) {
            if (quitButton.contains(new java.awt.Point(e.getX(), e.getY()))) {
                this.dispose();
            }
            if (RestartButton.contains(new java.awt.Point(e.getX(), e.getY()))); {
                gameState = GameState.STARTING;
            }
        }
        else if (gameState == GameState.STARTING) {
            gameState = GameState.PLAYING;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (basicTowerArea.contains(new java.awt.Point(e.getX(), e.getY()))) hodingTower =
                new BasicTower(new Point(0,0));
        else if (advanceTowerArea.contains(new java.awt.Point(e.getX(), e.getY()))) hodingTower =
                new AdvanceTower(new Point(0,0));
        else if (knightTrapTowerArea.contains(new java.awt.Point(e.getX(), e.getY()))) hodingTower =
                new KnightTrap(new Point(0,0));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = (e.getX()/64)*64;
        int y = (e.getY()/64)*64;

        if (hodingTower != null)
            hodingTower.setPos(x, y);
        try {
            if (MapManager.mapper[y / 64].charAt(x / 64) == '0') {
                if (Player.Money - hodingTower.getPrice() >= 0) {

                    //.println(x+" "+y+" "+hodingTower.toString());

                    Player.towers.add(hodingTower);
                    Player.Money -= hodingTower.getPrice();
                }
                hodingTower = null;
            }
        } catch (Exception exception) {
            hodingTower =null;
            //System.out.println(exception.getMessage());
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public enum GameState  {
        STARTING,
        PLAYING,
        WINNING,
        LOSING;
    }

    public static GameState gameState;

    public GameFrame() throws HeadlessException, IOException {
        setSize(WINDOW_WITH, WINDOW_HEIGHT);
        setTitle("Tower Defense");
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        gameState = GameState.STARTING;

        addMouseListener(this);

        player = new Player();
        add(player);

    }

    public static void main(String[] args) throws IOException {
        gameFrame = new GameFrame();
        gameFrame.setVisible(true);
    }
}
