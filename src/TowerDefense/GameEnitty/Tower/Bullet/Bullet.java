package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GameEnitty.GameScreen.GameField;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;

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
        this.to = to;
        this.target = target;
        this.power = power;
    }

    public void move() {
        this.pos.setX(this.pos.getX() + this.pos.getX()*(speed/distance(this.pos, to)));
        this.pos.setY(this.pos.getY() + this.pos.getY()*(speed/distance(this.pos, to)));
        if (Math.abs(pos.getX()-to.getX())>32 && Math.abs(pos.getY() - to.getY())>32 ) {
            target.damage(power);
            GameField.bullets.remove(this);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(im, pos.getX(), pos.getY(), this);
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


