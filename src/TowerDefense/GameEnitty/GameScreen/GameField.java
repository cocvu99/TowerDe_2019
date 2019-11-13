package TowerDefense.GameEnitty.GameScreen;

import TowerDefense.GameEnitty.GameScreen.Button.basicTowerButton;
import TowerDefense.GameEnitty.Map.*;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Monster.normalMonster;
import TowerDefense.GameEnitty.Monster.smallMonster;
import TowerDefense.GameEnitty.Monster.tankerMonster;
import TowerDefense.GameEnitty.Tower.BasicTower;
import TowerDefense.GameEnitty.Tower.Bullet;
import TowerDefense.GameEnitty.Tower.Tower;
import TowerDefense.GameEnitty.GameScreen.Button.basicTowerButton;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameField extends JPanel implements Runnable {
    List<Monster> monsters = new ArrayList<Monster>();
    List<Bullet> bullets = new ArrayList<Bullet>();
    List<Tower> towers = new ArrayList<Tower>();
    List<MapObject> mapper = MapManager.updateMapper();
    Tile tile = new Tile();
    Thread thread;

    public GameField() throws IOException {
        //monsters.add(new smallMonster(new Point(0, 64)));
        monsters.add(new tankerMonster(new Point(0, 64)));
        //monsters.add(new normalMonster(new Point(0,64)));
        towers.add(new BasicTower(new Point(0, 128)));

        thread = new Thread(this);
        thread.start();

    }

    public void paint(Graphics g) {
        for (MapObject map : mapper)
            map.paint(g);

        tile.paint(g);

        for (Monster mons : monsters) {
            mons.paint(g);
            mons.move();
        }
        for (Bullet bullet : bullets)
            bullet.paint(g);

        for (Tower tower : towers)
            tower.paint(g);

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
}
