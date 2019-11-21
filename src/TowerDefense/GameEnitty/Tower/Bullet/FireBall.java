package TowerDefense.GameEnitty.Tower.Bullet;

import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GamePlay.GameFrame;
import TowerDefense.GamePlay.SoundLoader;

import javax.swing.*;
import java.awt.*;

public class FireBall extends Bullet{


    public FireBall(Point from, Point to, Monster target, int power) {
        super(from, to, target, power);
        this.im = new ImageIcon("res/Bullet/fireball.png").getImage();
        this.speed = 4;

        SoundLoader.play("fireball.wav");
    }
    public void paint(Graphics g) {
        g.drawImage(im, pos.getX(), pos.getY(), 25,15,this);

        if (GameFrame.Debug == GameFrame.Debuging.ON)
            g.drawOval(
                    this.pos.getX() -16,
                    this.pos.getY() -16,
                    64, 64
            );

    }
}
