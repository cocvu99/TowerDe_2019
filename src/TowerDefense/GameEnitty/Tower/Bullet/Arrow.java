package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GameEnitty.GameScreen.GameField;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Arrow extends Bullet {
    public Arrow(Point from, Point to, Monster target, int power) {
        super(from, to, target, power);
        this.im = new ImageIcon("res/Bullet/Fireball (1).png").getImage();
        this.speed = 5;
    }



}
