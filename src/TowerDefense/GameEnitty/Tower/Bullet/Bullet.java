package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GameEnitty.GameScreen.GameField;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

public class Bullet extends JPanel {
    protected int speed;
    Image im;
    Point pos;
    Point to;
    Monster target;
    int power;

    public Bullet(Point from, Point to, Monster target, int power) {
        this.pos = from;
        this.target = target;
        this.power = power;
        this.to = to;
    }

    private Point dau(Point from, Point to) {
        Point res = new Point(1, 1);
        if (from.getX() - to.getX() < 0) res.setX(-1);
        if (from.getY() - to.getY() < 0) res.setY(-1);
        return res;
    }
    private long time = System.currentTimeMillis();
    public void move() {
        if (System.currentTimeMillis() - time <=50) return;
        time = System.currentTimeMillis();

        if (target == null) GameField.bullets.remove(this);

        this.pos.setX((int) (this.pos.getX() + dau(this.pos, to).getX() * speed * (this.pos.getX()/distance(this.pos, to))));
        this.pos.setY((int) (this.pos.getY() + dau(this.pos, to).getY() * speed * (this.pos.getY()/distance(this.pos, to))));

        System.out.println(pos.getX()+" "+pos.getY());

        for (Monster x : GameField.monsters) {
            if ((this.pos.getX() - x.getPosition().getX() < 64) && (this.pos.getX() - x.getPosition().getX() < 64))  {
                x.damage(power);
                GameField.bullets.remove(this);
            }
        }

        if (this.pos.getX() > GameFrame.WINDOW_WITH ||
                this.pos.getY() > GameFrame.WINDOW_HEIGHT ||
                this.pos.getX() < 0 ||
                this.pos.getY() <0) GameField.bullets.remove(this);
    }

    public void paint(Graphics g) {
        g.drawImage(im, pos.getX(), pos.getY(), this);
        g.drawRect(pos.getX(), pos.getY(), 24, 14);
        g.drawOval(this.pos.getX(), this.pos.getY(), 20, 30);
    }

    public int distance(Point from, Point to){
        return (int) Math.round(
                Math.sqrt(
                        Math.pow((from.getX() - to.getX()), 2)
                        + Math.pow((from.getY() - to.getY()), 2)
                )
        );
    }

}


