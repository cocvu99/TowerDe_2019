package TowerDefense.GameEnitty.Tower;
import TowerDefense.GameEnitty.GameScreen.GameField;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Tower.Bullet.Arrow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Tower extends JPanel{

    protected int price;
    protected Point pos;
    protected Image im;
    protected int range;
    protected int damage;

    public Tower(Point pos, String fileName){
        ImageIcon imageIcon = new ImageIcon(fileName);
        this.im = imageIcon.getImage();
        this.pos= pos;
        this.lastFired = System.currentTimeMillis();
    }

    protected void drawRound(Graphics g) {
        g.drawOval(this.pos.getX()-range/2+32,this.pos.getY()-range/2+32 , range, range);
    }
    public void paint(Graphics g) {
        g.drawImage(im, pos.getX(), pos.getY(), this);
        drawRound(g);
    }

    private long lastFired;
    public void fire() {
        long timeNow = System.currentTimeMillis();
        if (timeNow - lastFired >= 500) {
            lastFired = timeNow;
            List<Monster> monsters = GameField.monsters;
            for (int i = monsters.size() - 1; i >= 0; i--) {

                if (distance(monsters.get(i).getPosition(), this.pos) < (double) range) {
                    GameField.bullets.add(new Arrow(
                            new Point(this.pos.getX()+32, this.pos.getY()+32),
                            monsters.get(i).getPosition(),
                            monsters.get(i),
                            this.damage
                    ));
                }
            }
        }

    }
    public double distance(Point from, Point to){
        return Math.sqrt(
                Math.pow((from.getX() - to.getX()), 2)
                        + Math.pow((from.getY() - to.getY()), 2)
        );
    }

}
