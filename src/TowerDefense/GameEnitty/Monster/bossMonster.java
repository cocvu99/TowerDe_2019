package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.Point;

import javax.swing.*;

public class bossMonster extends Monster {
    public bossMonster(Point pos) {
        super(pos);

        this.im     = MonsterImage.bosR;
        this.imR    = im;
        this.imL    = MonsterImage.bossL;
        this.HP     = 6000;
        this.speed  = 1;
        this.armor  = 15;
        this.reward = 6000;
        this.maxHP  = HP;
    }

}
