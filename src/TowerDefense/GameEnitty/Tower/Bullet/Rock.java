package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GamePlay.GameFrame;
import TowerDefense.GamePlay.Player;

import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.io.IOException;

public class Rock extends Bullet {
    public Rock(Point from, Point to, Monster target, int power) {
        super(from, to, target, power);
        this.im = new ImageIcon("res/Bullet/Rock.png").getImage();
        this.to = new Point(to);
        this.speed = 2;
    }

}
