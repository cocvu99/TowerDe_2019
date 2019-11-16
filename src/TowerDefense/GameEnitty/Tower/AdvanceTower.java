package TowerDefense.GameEnitty.Tower;

import TowerDefense.GamePlay.Player;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Tower.Bullet.FireBall;

import java.util.List;

public class AdvanceTower extends Tower {

    public AdvanceTower(Point pos){
        super(pos, "res/Map/advand_tower.png");
        this.price = 100;
        this.range = 64*4;
        this.damage = 150;
    }

    private long lastFired;
    public void fire() {
        long timeNow = System.currentTimeMillis();
        if (timeNow - lastFired >= 700) {
            lastFired = timeNow;
            List<Monster> monsters = Player.monsters;
            for (int i = monsters.size() - 1; i >= 0; i--) {
                if (distance(monsters.get(i).getCentre(), this.pos) < (double) range) {
                    Player.bullets.add(new FireBall(
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
