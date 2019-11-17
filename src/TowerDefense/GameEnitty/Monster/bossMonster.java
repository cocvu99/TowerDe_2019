package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.Point;

public class bossMonster extends Monster {
    public bossMonster(Point pos) {
        super(pos, "res/Monster/boss.gif");
        this.HP     = 3000;
        this.speed  = 1;
        this.armor  = 15;
        this.reward = 3000;
        this.maxHP  = 3000;
    }

}
