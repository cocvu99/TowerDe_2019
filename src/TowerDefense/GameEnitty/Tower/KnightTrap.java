package TowerDefense.GameEnitty.Tower;

import TowerDefense.GameEnitty.Tower.Bullet.FireBall;
import TowerDefense.GamePlay.Player;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Tower.Bullet.Rock;
import TowerDefense.GamePlay.SoundLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class KnightTrap extends Tower {
    public KnightTrap(Point pos) {
        super(pos, "res/Map/Knight Post Front (1).png");
        this.price = 200;
        this.range = 3*64;
        this.damage = 350;
    }


    public void fire() {
        long timeNow = System.currentTimeMillis();
        if (timeNow - lastFired >= 800) {
            lastFired = timeNow;
            List<Monster> monsters = Player.monsters;

            for (Monster mon: Player.monsters) {
                if (distance(mon.getCentre(), this.pos) < (double) range) {

                    //SoundLoader.play("fireshoot.wav");

                    Player.bullets.add(new Rock(
                            new Point(this.pos.getX() + 32, this.pos.getY() + 32),
                            mon.getPosition(),
                            mon,
                            this.damage
                    ));
                    break;
                }
            }
        }
    }
}
