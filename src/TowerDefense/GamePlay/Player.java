package TowerDefense.GamePlay;

import TowerDefense.GameScreen.Tile;
import TowerDefense.GameEnitty.Map.*;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Monster.normalMonster;
import TowerDefense.GameEnitty.Monster.smallMonster;
import TowerDefense.GameEnitty.Monster.tankerMonster;

import TowerDefense.GameEnitty.Tower.Bullet.Bullet;
import TowerDefense.GameEnitty.Tower.Tower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Player  extends JPanel implements Runnable {
    public static List<Monster> monsters = new ArrayList<Monster>();
    public static List<Bullet> bullets = new ArrayList<Bullet>();
    public static List<Tower> towers = new ArrayList<Tower>();
    public static List<MapObject> mapper;
    public static int Money;
    public static int Heart;

    public static void loadMapper() {
        try {
            mapper = MapManager.updatePlayMapper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Tile tile = new Tile();
    Thread thread;

    public Player() {
        thread = new Thread(this);
        thread.start();
        Heart = 1;
    }

    private void reset() {
        Heart = 1;
        Money = 2000;
        towers.clear();
        monsters.clear();
        bullets.clear();
        i = 0;
    }

    public void paint(Graphics g) {
        if (GameFrame.gameState == GameFrame.GameState.STARTING) {
            g.fillRect(GameFrame.WINDOW_WITH/2 - 64,
                    GameFrame.WINDOW_HEIGHT/2 - 32, 128, 64);
            this.reset();

            loadMapper();

            g.drawImage(new ImageIcon("res/Map/Screen/start.png").getImage(), 0, 0, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Consolas", Font.BOLD, 50));
            g.drawString("Tower Defense - Level "+GameFrame.GAME_LEVEL, 350, 600);
            //g.setFont(new Font("Consolas", Font.BOLD, 20));
        }

        else if (GameFrame.gameState == GameFrame.GameState.WINNING ||
                GameFrame.gameState == GameFrame.GameState.LOSING)
        {
            g.drawImage(new ImageIcon("res/Map/Screen/start.png").getImage(), 0, 0, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Consolas", Font.BOLD, 50));

            if (GameFrame.gameState == GameFrame.GameState.LOSING) {
                g.drawString("You Loosed!", 500, 600);
            }
            else if (GameFrame.gameState == GameFrame.GameState.WINNING) {
                g.drawString("You Won!", 500, 600);
            }

            loadMapper();

            g.setColor(Color.WHITE);
            g.fillRect(GameFrame.WINDOW_WITH/2 - 256 - 100,
                    GameFrame.WINDOW_HEIGHT/2, 128, 64);
            g.fillRect(GameFrame.WINDOW_WITH/2 + 256,
                    GameFrame.WINDOW_HEIGHT/2, 128, 64);

            g.setFont(new Font("Consolas", Font.BOLD, 20));
            g.setColor(Color.black);
            g.drawString("QUIT", GameFrame.WINDOW_WITH/2 - 256 - 75,
                    GameFrame.WINDOW_HEIGHT/2 + 25);
            g.drawString("RESTART", GameFrame.WINDOW_WITH/2 + 256 + 25,
                    GameFrame.WINDOW_HEIGHT/2 + 25);
        }

        else if (GameFrame.gameState == GameFrame.GameState.PLAYING) {

            for (MapObject map : mapper)
                map.paint(g);

            tile.paint(g);

            for (Tower tower : towers) {
                try {
                    tower.fire();
                    tower.paint(g);
                }catch (Exception e) {
                    System.out.println("Player.java: "+e.getMessage());
                }
            }

            for (Monster mons : monsters) {
                try {
                    mons.move();
                    mons.paint(g);
                } catch (Exception e) {
                    System.out.println("Player.java: "+e.getMessage());
                }
            }

            for (int i = bullets.size() - 1; i >= 0; i--) {
                bullets.get(i).paint(g);
                try {
                    bullets.get(i).move();
                } catch (Exception e) {
                    System.out.println("player.java: "+e.getMessage());
                }
            }

            if (GameFrame.hodingTower != null)
                g.drawImage(GameFrame.hodingTower.getIm(),
                        (int) getMousePosition().getX(),
                        (int) getMousePosition().getY(), null);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Consolas", Font.BOLD, 20));
            g.drawString(String.valueOf(Money), 1124, 135);
            g.drawString(String.valueOf(Heart), 1124, 183);
            g.drawString("50", 1124, 250);
            g.drawString("100", 1124, 310);
            g.drawString("200", 1124, 380);
        }
    }

    private long time = System.currentTimeMillis();
    private int i = 0;
    private  void createMonster(char c) {
        //System.out.println(c);
        switch (c) {
            case '1': monsters.add(new normalMonster(MapManager.spaner.getPos())); break;
            case '2': monsters.add(new smallMonster(MapManager.spaner.getPos())); break;
            case '3': monsters.add(new tankerMonster(MapManager.spaner.getPos())); break;
        }
    }

    @Override
    public void run() {
        while (true) {
            if (System.currentTimeMillis() - time > 1000 && i< MapManager.MonsterSpan.length()) {
                createMonster(MapManager.MonsterSpan.charAt(i++));
                time = System.currentTimeMillis();
                System.out.println("player.java: "+i);
            }

            repaint();
            try {
                thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setMapper(List<MapObject> mapper) {
        this.mapper = mapper;
    }

    public static List<Monster> getMonsters() {
        return monsters;
    }

}
