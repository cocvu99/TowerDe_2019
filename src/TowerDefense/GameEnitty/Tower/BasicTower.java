package TowerDefense.GameEnitty.Tower;

import TowerDefense.GameEnitty.GameScreen.GameField;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Tower.Bullet.Arrow;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasicTower extends Tower {

    public BasicTower(Point pos) {
        super(pos, "res/Map/basic_tower.png");
        this.price = 50;
        this.range = 256;
        this.damage = 100;
    }

    public void fire() {
        long timeNow = System.currentTimeMillis();
        if (timeNow - lastFired >= 500) {
            lastFired = timeNow;
            List<Monster> monsters = GameField.monsters;
            for (int i = monsters.size() - 1; i >= 0; i--) {
                if (distance(monsters.get(i).getCentre(), this.pos) < (double) range) {
                    GameField.bullets.add(new Arrow(
                            new Point(this.pos.getX() + 32, this.pos.getY() + 32),
                            monsters.get(i).getPosition(),
                            monsters.get(i),
                            this.damage
                    ));
                    break;
                }
            }
        }
    }
}
