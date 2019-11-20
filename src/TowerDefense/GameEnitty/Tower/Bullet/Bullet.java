package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GameEnitty.Map.MapManager;
import TowerDefense.GamePlay.Player;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GamePlay.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.IOException;

public abstract class Bullet extends JPanel {
    protected int speed;
    protected Image im;
    protected Point pos;
    protected Point to;
    protected Monster target;
    int power;

    public Bullet(Point from, Point to, Monster target, int power) {
        this.pos = from;
        this.target = target;
        this.power = power;
        this.to = to;
    }

    private Point dau(Point from, Point to) {
        Point res = new Point(1, 1);
        if (from.getX() > to.getX() +3) res.setX(-1);
        if (from.getY() > to.getY() +3) res.setY(-1);
        if (to.getX() >= from.getX() -3 && to.getX() <= from.getX() +3) res.setX(0);
        if (to.getY() >= from.getY() -3 && to.getY() <= from.getY() +3) res.setY(0);
        return res;
    }
    private long time = System.currentTimeMillis();
    public void move() throws InterruptedException, IOException {
        if (System.currentTimeMillis() - time <=50) return;
        time = System.currentTimeMillis();

        this.pos.setX(this.pos.getX() + dau(this.pos, to).getX() * speed);
        this.pos.setY(this.pos.getY() + dau(this.pos, to).getY() * speed);

        //this.pos.setX((int) (this.pos.getX() + dau(this.pos, to).getX() * speed *(1+ distance(this.pos, to.center()))));
        //this.pos.setY((int) (this.pos.getY() + dau(this.pos, to).getY() * speed *(1+ distance(this.pos, to.center())));

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
                Player.bullets.remove(this);
                mon.damage(power);
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

        if (GameFrame.Debug == GameFrame.Debuging.ON)
        g.drawOval(
                this.pos.getX() -16,
                this.pos.getY() -16,
                64, 64
        );

    }

    public Monster getTarget() {
        return target;
    }

    public void setTarget(Monster target) {
        this.target = target;
    }

    public void setTo(Point to) {
        this.to = to;
    }
}









