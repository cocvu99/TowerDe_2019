package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.Point;

public class tankerMonster extends Monster {
    public tankerMonster(Point pos) {
        super(pos);
        this.imL    = MonsterImage.ghost1L;
        this.imR    = MonsterImage.ghost1R;
        this.im     = imL;
        this.HP     = 3000;
        this.speed  = 1;
        this.armor  = 20;
        this.reward = 50;
        this.maxHP  = HP;
    }


}
