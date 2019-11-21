package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.Point;

public class bossMonster extends Monster {
    public bossMonster(Point pos) {
        super(pos);

        this.im     = MonsterImage.bosR;
        this.imR    = im;
        this.imL    = MonsterImage.bossL;
        this.HP     = 6000;
        this.speed  = 1;
        this.armor  = 15;
        this.reward = 100;
        this.maxHP  = HP;
        this.extraMove = 32;
    }

}
