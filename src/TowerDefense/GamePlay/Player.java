package TowerDefense.GamePlay;

import TowerDefense.GameScreen.Tile;
import TowerDefense.GameEnitty.Map.*;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Monster.normalMonster;
import TowerDefense.GameEnitty.Monster.smallMonster;
import TowerDefense.GameEnitty.Monster.tankerMonster;
import TowerDefense.GameEnitty.Tower.AdvanceTower;

import TowerDefense.GameEnitty.Tower.Bullet.Bullet;
import TowerDefense.GameEnitty.Tower.KnightTrap;
import TowerDefense.GameEnitty.Tower.Tower;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player  extends JPanel implements Runnable {
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

    public Player() throws IOException {

        //towers.add(new BasicTower(new Point(0, 128)));
        //towers.add(new BasicTower(new Point(512, 300)));
        //towers.add(new BasicTower(new Point(12*64, 9*64)));
        //towers.add(new AdvanceTower(new Point(4*64, 4*64)));
        towers.add(new AdvanceTower(new Point(15*64, 7*64)));
        towers.add(new KnightTrap(new Point(3*64, 4*64)));


        JButton basicTowerButton= new JButton(new ImageIcon("res/Map/basic_tower.png"));
        basicTowerButton.setBounds(0,64,64, 64);
        add(basicTowerButton, BorderLayout.WEST);
        basicTowerButton.setVisible(true);
        //basicTowerButton.setIgnoreRepaint(true);
        //basicTowerButton.setContentAreaFilled(false);


        thread = new Thread(this);

        thread.start();
    }

    public void paint(Graphics g) {

        tile.paint(g);

        for (MapObject map : mapper)
            map.paint(g);

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
                createMonster(MapManager.MonsterSpan.charAt(i++));
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
