package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GamePlay.GameFrame;
import TowerDefense.GamePlay.Player;
import TowerDefense.GamePlay.SoundLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.IOException;

public class Rock extends Bullet {
    public Rock(Point from, Point to, Monster target, int power) {
        super(from, to, target, power);
        this.im = new ImageIcon("res/Bullet/Rock.png").getImage();
        this.to = new Point(to);
        this.speed = 2;

        SoundLoader.play("rock.wav");
    }
    public void paint(Graphics g) {
        g.drawImage(im, pos.getX(), pos.getY(), 20,20,this);

        if (GameFrame.Debug == GameFrame.Debuging.ON)
            g.drawOval(
                    this.pos.getX() -16,
                    this.pos.getY() -16,
                    64, 64
            );

    }
}
