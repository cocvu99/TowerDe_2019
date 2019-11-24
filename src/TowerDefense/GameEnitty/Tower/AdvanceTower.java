package TowerDefense.GameEnitty.Tower;

import TowerDefense.GamePlay.Player;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Tower.Bullet.FireBall;
import TowerDefense.GamePlay.SoundLoader;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AdvanceTower extends Tower {

    public AdvanceTower(Point pos){
        super(pos, "res/Map/advance_tower.png");
        this.price = 100;
        this.range = 64*4;
        this.damage = 200;
    }


    private long lastFired;
    public void fire() {
        long timeNow = System.currentTimeMillis();
        if (timeNow - lastFired >= 700) {
            lastFired = timeNow;
            List<Monster> monsters = Player.monsters;
                for (Monster mon: Player.monsters) {
                    if (distance(mon.getCentre(), this.getCentre()) <= (double) range/2 ||
                            distance(new Point (mon.getPosition().getX() +64, mon.getPosition().getY() +64), this.getCentre()) <= (double) range/2) {

                        Player.bullets.add(new FireBall(
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
