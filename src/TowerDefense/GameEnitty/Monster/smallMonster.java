package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.Point;

public class smallMonster extends Monster {
    public smallMonster(Point pos) {
        super(pos, "res/Monster/ghost3.png");
        this.HP     = 200;
        this.speed  = 3;
        this.armor  = 0;
        this.reward = 10;
        this.maxHP  = 200;
    }


}
