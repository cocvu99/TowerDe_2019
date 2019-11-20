package TowerDefense.GameEnitty.Tower;

import TowerDefense.GameEnitty.Tower.Bullet.FireBall;
import TowerDefense.GamePlay.Player;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Tower.Bullet.Arrow;
import TowerDefense.GamePlay.SoundLoader;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BasicTower extends Tower {

    public BasicTower(Point pos) {
        super(pos, "res/Map/basic_tower.png");
        this.price = 50;
        this.range = 64*5;
        this.damage = 100;
    }


    public void fire() {
        long timeNow = System.currentTimeMillis();
        if (timeNow - lastFired >= 500) {
            lastFired = timeNow;
            List<Monster> monsters = Player.monsters;
            for (Monster mon: Player.monsters) {
                if (distance(mon.getCentre(), this.pos) < (double) range - 80) {

                    //SoundLoader.play("fireshoot.wav");

                    Player.bullets.add(new Arrow(
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
