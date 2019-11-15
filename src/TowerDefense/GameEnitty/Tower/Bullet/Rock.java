package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;

import javax.swing.*;

public class Rock extends Bullet {
    public Rock(Point from, Point to, Monster target, int power) {
        super(from, to, target, power);
        this.im = new ImageIcon("res/Bullet/Rock.png").getImage();
        this.speed = 3;
    }
}
