package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GameEnitty.Map.Point;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

public class Bullet extends JPanel {
    protected int speed;
    Image im;
    Point pos;
    Point to;


    public Bullet(Point from, Point to) {
        this.pos = from;
        this.to = to;
    }

    public void move() {
        this.pos.setX(this.pos.getX() + this.pos.getX()*(speed/distance(this.pos, to)));
        this.pos.setY(this.pos.getY() + this.pos.getY()*(speed/distance(this.pos, to)));
        System.out.println("moved");
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


