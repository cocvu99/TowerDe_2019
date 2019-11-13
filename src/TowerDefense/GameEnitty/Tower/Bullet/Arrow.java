package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GameEnitty.GameScreen.GameField;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Arrow extends Bullet {
    public Arrow(Point from, Point to) {
        super(from, to);
        this.im = new ImageIcon("res/Bullet/arrow.png").getImage();
        this.speed = 5;
        System.out.println("created");
    }



}
