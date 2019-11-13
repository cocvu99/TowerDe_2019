package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.Point;

public class bossMonster extends Monster {
    public bossMonster(Point pos) {
        super(pos, "res/Monster/Monster1.png");
        this.HP     = 200;
        this.speed  = 1;
        this.armor  = 10;
        this.reward = 50;
    }

}
