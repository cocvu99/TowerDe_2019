package TowerDefense.GameEnitty.GameScreen;

import TowerDefense.GameEnitty.GameScreen.Button.basicTowerButton;
import TowerDefense.GameEnitty.Map.*;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Monster.normalMonster;
import TowerDefense.GameEnitty.Monster.smallMonster;
import TowerDefense.GameEnitty.Monster.tankerMonster;
import TowerDefense.GameEnitty.Tower.BasicTower;

import TowerDefense.GameEnitty.Tower.Bullet.Bullet;
import TowerDefense.GameEnitty.Tower.Tower;
import TowerDefense.GameEnitty.GameScreen.Button.basicTowerButton;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameField extends JPanel implements Runnable {
    public static List<Monster> monsters = new ArrayList<Monster>();
    public static List<Bullet> bullets = new ArrayList<Bullet>();
    public static List<Tower> towers = new ArrayList<Tower>();
    public static List<MapObject> mapper;

    static {
        try {
            mapper = MapManager.updateMapper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Tile tile = new Tile();
    Thread thread;

    public GameField() throws IOException {
        monsters.add(new smallMonster(new Point(0, 64)));
        monsters.add(new tankerMonster(new Point(0, 64)));
        monsters.add(new normalMonster(new Point(0,64)));
        towers.add(new BasicTower(new Point(0, 128)));
        towers.add(new BasicTower(new Point(512, 300)));

        thread = new Thread(this);
        thread.start();

    }

    public void paint(Graphics g) {
        for (MapObject map : mapper)
            map.paint(g);

        tile.paint(g);

        for (Monster mons : monsters) {
            mons.move();
            mons.paint(g);
        }
        for (Tower tower : towers) {
            tower.fire();
            tower.paint(g);
        }
        for (int i=bullets.size()-1; i>=0; i--) {
            bullets.get(i).paint(g);
            bullets.get(i).move();
        }

    }

    @Override
    public void run() {
        while (true) {
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
