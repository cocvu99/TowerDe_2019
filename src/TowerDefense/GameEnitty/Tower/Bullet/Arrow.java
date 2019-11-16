package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;

import javax.swing.*;

public class Arrow extends Bullet {
    public Arrow(Point from, Point to, Monster target, int power) {
        super(from, to, target, power);
        this.im = new ImageIcon("res/Bullet/bullet2.png").getImage();
        this.speed = 4;
    }

}
