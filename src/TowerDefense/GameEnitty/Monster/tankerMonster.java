package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.Point;

public class tankerMonster extends Monster {
    public tankerMonster(Point pos) {
        super(pos, "res/Monster/ghost1.png");
        this.HP     = 1500;
        this.speed  = 1;
        this.armor  = 10;
        this.reward = 50;
        this.maxHP  = 1500;
    }


}
