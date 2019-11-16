package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GamePlay.Player;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GamePlay.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Bullet extends JPanel {
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
        if (from.getX() - to.getX() > 0) res.setX(-1);
        if (from.getY() - to.getY() > 0) res.setY(-1);
        if (from.getX() - to.getY() == 0) res.setX(0);
        if (from.getY() - to.getY() == 0) res.setY(0);
        return res;
    }
    private long time = System.currentTimeMillis();

    public void move() {

        if (to == null) {
            Player.bullets.remove(this);
            return;
        }

        if (Player.monsters.isEmpty()) Player.bullets.clear();
        if (System.currentTimeMillis() - time <=50) return;
        time = System.currentTimeMillis();

        if (target == null) Player.bullets.remove(this);

        this.pos.setX(this.pos.getX() + dau(this.pos, to).getX() * speed);
        this.pos.setY(this.pos.getY() + dau(this.pos, to).getY() * speed);

        //this.pos.setX((int) (this.pos.getX() + dau(this.pos, to).getX() * speed *(1+ distance(this.pos, to.center()))));
        //this.pos.setY((int) (this.pos.getY() + dau(this.pos, to).getY() * speed *(1+ distance(this.pos, to.center()))));


        //System.out.println(pos.getX()+" "+pos.getY());

        Ellipse2D.Double range = new Ellipse2D.Double(
                this.pos.getX() - 16,
                this.pos.getY() - 16,
                64, 64
        );

        //kiểm tra va chạm
        for (Monster mon : Player.monsters)  {
            if(range.contains(new java.awt.Point(
                    mon.getPosition().getX() + 32,
                    mon.getPosition().getY() + 32)))
            {
                mon.damage(power);
                Player.bullets.remove(this);
                break;
            }
        }
        //xóa khi ra khỏi màn hình
        if (this.pos.getX() > GameFrame.WINDOW_WITH ||
                this.pos.getY() > GameFrame.WINDOW_HEIGHT ||
                this.pos.getX() < 0 ||
                this.pos.getY() <0) Player.bullets.remove(this);
    }

    public void paint(Graphics g) {
        g.drawImage(im, pos.getX(), pos.getY(), this);

        /* //DEBUG
        g.drawRect(pos.getX(), pos.getY(), 24, 14);
        g.drawOval(
                this.pos.getX() -16,
                this.pos.getY() -16,
                64, 64
        );

         */

    }

    public static double distance(Point from, Point to){
        return  Math.sqrt(
                        Math.pow((from.getX() - to.getX()), 2)
                        + Math.pow((from.getY() - to.getY()), 2)

        );
    }

}


