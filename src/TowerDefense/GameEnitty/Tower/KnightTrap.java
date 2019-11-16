package TowerDefense.GameEnitty.Tower;

import TowerDefense.GamePlay.Player;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Tower.Bullet.Rock;

import java.util.List;

public class KnightTrap extends Tower {
    public KnightTrap(Point pos) {
        super(pos, "res/Map/Knight Post Front (1).png");
        this.price = 200;
        this.range = 2*64;
        this.damage = 150;
    }

    public void fire() {
        long timeNow = System.currentTimeMillis();
        if (timeNow - lastFired >= 500) {
            lastFired = timeNow;
            List<Monster> monsters = Player.monsters;
            for (int i = monsters.size() - 1; i >= 0; i--) {
                if (distance(monsters.get(i).getCentre(), this.pos) < (double) range) {
                    Player.bullets.add(new Rock(
                            new Point(this.pos.getX() + 32, this.pos.getY() + 32),
                            monsters.get(i).getPosition(),
                            monsters.get(i),
                            this.damage
                    ));
                }
            }
        }
    }
}
