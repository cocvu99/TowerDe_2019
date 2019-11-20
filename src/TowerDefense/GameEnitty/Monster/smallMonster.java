package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.Point;

public class smallMonster extends Monster {
    public smallMonster(Point pos) {
        super(pos);
        this.imL    = MonsterImage.ghost3L;
        this.imR    = MonsterImage.ghost3R;
        this.im     = imR;
        this.HP     = 500;
        this.speed  = 3;
        this.armor  = 0;
        this.reward = 10;
        this.maxHP  = HP;
    }


}
