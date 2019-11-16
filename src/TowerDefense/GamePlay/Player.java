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
    public static boolean endWave = false;

    static {
        try {
            mapper = MapManager.updatePlayMapper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Tile tile = new Tile();
    Thread thread;

    public Player() throws IOException {

        Money = 200;
        Heart = 10;

        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        //tùy vào gamestate
        if (GameFrame.gameState == GameFrame.GameState.PLAYING) {
            for (MapObject map : mapper)
                map.paint(g);

            tile.paint(g);

            for (Tower tower : towers) {
                tower.fire();
                tower.paint(g);
            }

            for (Monster mons : monsters) {
                mons.move();
                mons.paint(g);
            }

            for (int i = bullets.size() - 1; i >= 0; i--) {
                bullets.get(i).paint(g);
                bullets.get(i).move();
            }

            if (GameFrame.hodingTower != null)
                g.drawImage(GameFrame.hodingTower.getIm(),
                        (int) getMousePosition().getX(),
                        (int) getMousePosition().getY(), null);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 20));
        g.drawString(String.valueOf(Money), 1124, 135);
        g.drawString(String.valueOf(Heart), 1124, 183);
        g.drawString("50", 1124, 250);
        g.drawString("100", 1124, 310);
        g.drawString("200", 1124, 380);
    }

    private long time = System.currentTimeMillis();
    private int i = 0;
    private  void createMonster(char c) {
        System.out.println(c);
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
                try {
                    createMonster(MapManager.MonsterSpan.charAt(i++));
                }catch (StringIndexOutOfBoundsException e) {
                    endWave = true;
                }
                time = System.currentTimeMillis();
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
