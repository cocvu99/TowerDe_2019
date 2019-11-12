package Game;

import Game.GameEnitty.Map.Road;
import Game.GameEnitty.Map.Tile;
import Game.GameEnitty.Monster.Monster;
import Game.GameEnitty.Tower.Bullet;
import Game.GameEnitty.Tower.Tower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameField extends JPanel implements Runnable {


    private Image image;
    private int x=-50, y=-50, k=0, temp=0,over;
    List<Monster> enemies = new ArrayList<Monster>();
    List<Bullet> bullets = new ArrayList<Bullet>();Bullet
    List<Tower> towers = new ArrayList<Tower>();
    gameOver gameOver = new gameOver();
    Road r = new Road();
    Tile tile = new Tile();
    private int knockEnemy=0;

    private int wait = 0,wait1=0;


    public GameField(){
        enemies.add(new Monster());
        Thread thread = new Thread(this);
        thread.start();
        ImageIcon imageIcon = new ImageIcon("image/nen2.png");
        image = imageIcon.getImage();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x=(int)e.getPoint().getX();
                y=(int)e.getPoint().getY();
                for (Tower tower: towers) {
                    if (new Rectangle(x, y, 50, 50).intersects(new Rectangle(tower.getX(),tower.getY(), 50, 50))) {
                        temp++;
                    }
                }
                Tower newTower = new Tower(x, y);
                if (newTower.asRoad(x, y) && tile.getCoin() >= 100&&temp==0) {
                    towers.add(newTower);
                    k++;
                    tile.setCoin(tile.getCoin() - 100);
                }
            }
        });
    }
    public void paint(Graphics g){
        g.drawImage(image,0,0,this);
        r.paint(g);
        for(Enemy enemy: enemies) {
            enemy.paint(g);
        }
        for(Bullet bullet: bullets)
            bullet.paint(g);
        for(Tower tower: towers)
            tower.paint(g);
        tile.paint(g);

        if(enemies.get(0).getX() >= 1000){
            gameOver.paint1(g);
        }
        if(knockEnemy==50){
            gameOver.paint2(g);
        }

    }
    @Override
    public void run() {
        while (true){
            repaint();
            if(wait>60) {
                enemies.add(new Enemy());
                wait = 0;
            }
            else
                wait++;

            if(wait1>10&&k>0) {
                for (Tower tower:towers)
                {
                    if(enemies.size()>0) {
                        Bullet bullet = new Bullet(tower.getX() + 20, tower.getY() + 20, enemies.get(0).getX(),
                                enemies.get(0).getY(), tower.getX() + 20, tower.getY() + 20);
                        bullets.add(bullet);
                        wait1 = 0;
                    }
                }
            }
            else
                wait1++;

            for(int i=0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                bullet.move();
                if(bullet.getY1() >= 600||bullet.getY1()<=0||bullet.getX1()>=1000||bullet.getX1()<=0) bullets.remove(i);
            }

            for(int i=0; i < enemies.size(); i++){
                Enemy enemy = enemies.get(i);
                enemy.move();
            }

            checkImpact();

            if(enemies.get(0).getX()>1000) break;
            if(knockEnemy == 50) break;

            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                            ex.printStackTrace();
            }
        }
    }

    public void checkImpact(){
        for (int i = 0; i< bullets.size()-1; i++) {
                Bullet bullet = bullets.get(i);
                int x = bullet.getX1() ;
                int y = bullet.getY1();
            for (int j = 0; j < enemies.size()-1; j++) {
                Enemy enemy = enemies.get(j);
                int xx = enemy.getX();
                int yy = enemy.getY();
                if (new Rectangle(x,y,10,10).intersects(new Rectangle(xx,yy,30,30))) {
                    bullets.remove(i);
                    enemy.setHp(enemy.getHp()-3);
                    if( enemy.getHp()==0){
                        enemies.remove(j);
                        knockEnemy++;
                        tile.setCoin(tile.getCoin()+10);
                    }
                }
            }
        }
    }

}
